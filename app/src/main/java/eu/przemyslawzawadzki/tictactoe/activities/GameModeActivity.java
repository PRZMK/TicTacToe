package eu.przemyslawzawadzki.tictactoe.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import eu.przemyslawzawadzki.tictactoe.enums.GameMode;
import eu.przemyslawzawadzki.tictactoe.R;

public class GameModeActivity extends AppCompatActivity {
    public static final String MODE = "mode";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_mode);
    }

    public void multiPlayerMode(View view) {
        Intent intent = new Intent(getApplicationContext(),GameActivity.class);
        intent.putExtra(MODE, GameMode.MULTI_PLAYER_MODE);
        startActivity(intent);
    }

    public void singlePlayerMode(View view) {
        Intent intent = new Intent(getApplicationContext(),GameActivity.class);
        intent.putExtra(MODE,GameMode.SINGLE_PLAYER_MODE);
        startActivity(intent);
    }
}
