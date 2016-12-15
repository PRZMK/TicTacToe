package eu.przemyslawzawadzki.tictactoe.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import eu.przemyslawzawadzki.tictactoe.enums.GameMode;
import eu.przemyslawzawadzki.tictactoe.controller.GameModeChooser;
import eu.przemyslawzawadzki.tictactoe.controller.MultiPlayerGame;
import eu.przemyslawzawadzki.tictactoe.R;
import eu.przemyslawzawadzki.tictactoe.controller.TicTacToeGame;

/**
 * Created by przemyslawz on 14.12.2016.
 */

public class GameActivity extends AppCompatActivity {

    public static final int[] BUTTON_ID = {R.id.button_1_1, R.id.button_1_2, R.id.button_1_3, R.id.button_2_1, R.id.button_2_2, R.id.button_2_3, R.id.button_3_1, R.id.button_3_2, R.id.button_3_3};
    private TicTacToeGame mGame;

    private ImageButton mBoardButtons[] = new ImageButton[TicTacToeGame.BOARD_SIZE];

    private TextView mInfoTextView;
    private TextView mHumanCount;
    private TextView mTieCount;
    private TextView mAndroidCount;

    private int mHumanCounter = 0;
    private int mTieCounter = 0;
    private int mAndroidCounter = 0;

    private boolean mHumanFirst = true;
    private boolean mGameOver = false;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        mInfoTextView = (TextView) findViewById(R.id.information);
        mHumanCount = (TextView) findViewById(R.id.user_score);
        mTieCount = (TextView) findViewById(R.id.tiesCount);
        mAndroidCount = (TextView) findViewById(R.id.opponent_score);

        mHumanCount.setText(String.valueOf(mHumanCounter));
        mTieCount.setText(String.valueOf(mTieCounter));
        mAndroidCount.setText(String.valueOf(mAndroidCounter));
        GameMode mode = (GameMode) getIntent().getSerializableExtra(GameModeActivity.MODE);
        mGame = GameModeChooser.getGameWithMode(mode);
        startNewGame();

    }

    private ImageButton getButtonWithNumber(int i){
        ImageButton button = mBoardButtons[i];
        if(button == null){
            button = (ImageButton) findViewById(BUTTON_ID[i]);
        }
        return button;
    }

    private void startNewGame() {
        mGame.clearBoard();

        for (int i = 0; i < mBoardButtons.length; i++) {
            getButtonWithNumber(i).setBackgroundResource(R.color.common_plus_signin_btn_text_dark_disabled);
            getButtonWithNumber(i).setEnabled(true);
            getButtonWithNumber(i).setOnClickListener(new ButtonClickListener(i));
        }

        if (mHumanFirst) {
            mInfoTextView.setText(R.string.first_human);
            mHumanFirst = false;
        } else {
            mInfoTextView.setText(R.string.turn_computer);
            int move = mGame.getOpponentMove();
            setMove(TicTacToeGame.ANDROID_PLAYER, move);
            mHumanFirst = true;
        }
    }

    public void restartGame(View view) {
        mGameOver = false;
        startNewGame();
    }

    private class ButtonClickListener implements View.OnClickListener {
        int location;

        public ButtonClickListener(int location) {
            this.location = location;
        }

        @Override
        public void onClick(View view) {
            if (!mGameOver) {
                if (getButtonWithNumber(location).isEnabled()) {
                    setMove(TicTacToeGame.HUMAN_PLAYER, location);
                    int winner = mGame.checkForWinner();
                    if (winner == 0) {
                        mInfoTextView.setText(R.string.turn_computer);
                        int move = mGame.getOpponentMove();
                        setMove(TicTacToeGame.ANDROID_PLAYER, move);
                        winner = mGame.checkForWinner();
                    }
                    if (winner == 0) {
                        mInfoTextView.setText(R.string.turn_human);
                    } else if (winner == 1) {
                        mInfoTextView.setText(R.string.result_tie);
                        mTieCounter++;
                        mTieCount.setText(String.valueOf(mTieCounter));
                        mGameOver = true;

                    } else if (winner == 2) {
                        mInfoTextView.setText(R.string.result_human_wins);
                        mHumanCounter++;
                        mHumanCount.setText(String.valueOf(mHumanCounter));
                        mGameOver = true;
                    } else {
                        mInfoTextView.setText(R.string.result_android_wins);
                        mAndroidCounter++;
                        mAndroidCount.setText(String.valueOf(mAndroidCounter));
                        mGameOver = true;
                    }
                }
            }
        }
    }

    private void setMove(char player, int location) {

        mGame.setMove(player, location);
        getButtonWithNumber(location).setEnabled(false);

        if (player == TicTacToeGame.HUMAN_PLAYER) {
            getButtonWithNumber(location).setColorFilter(Color.GREEN);
            getButtonWithNumber(location).setBackgroundResource(R.drawable.cross);
            if(mGame instanceof MultiPlayerGame) {
                ((MultiPlayerGame) mGame).sendMoveToOpponent(location);
            }
        } else {
            getButtonWithNumber(location).setBackgroundColor(Color.RED);
            getButtonWithNumber(location).setBackgroundResource(R.drawable.circle);
        }
    }
}
