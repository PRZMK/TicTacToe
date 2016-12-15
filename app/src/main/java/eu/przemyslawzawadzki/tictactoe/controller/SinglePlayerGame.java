package eu.przemyslawzawadzki.tictactoe.controller;

import java.util.Random;

/**
 * Created by przemyslawz on 14.12.2016.
 */

public class SinglePlayerGame extends TicTacToeGame {
    private Random mRand;

    private static volatile SinglePlayerGame instance;

    private SinglePlayerGame() {
        super();
        mRand = new Random();
    }

    public static SinglePlayerGame createSinglePlayer(){
        if (instance == null){
            synchronized (SinglePlayerGame.class){
                if(instance == null){
                    instance = new SinglePlayerGame();
                }
            }
        }
        return instance;
    }



    @Override
    public int getOpponentMove() {
        int move;

        for (int i = 0; i < BOARD_SIZE; i++) {
            if (mBoard[i] != HUMAN_PLAYER && mBoard[i] != ANDROID_PLAYER) {
                char curr = mBoard[i];
                mBoard[i] = ANDROID_PLAYER;
                if (checkForWinner() == 3) {
                    setMove(ANDROID_PLAYER, i);
                    return i;
                } else
                    mBoard[i] = curr;
            }
        }

        for (int i = 0; i < BOARD_SIZE; i++) {
            if (mBoard[i] != HUMAN_PLAYER && mBoard[i] != ANDROID_PLAYER) {
                char curr = mBoard[i];
                mBoard[i] = HUMAN_PLAYER;
                if (checkForWinner() == 2) {
                    setMove(ANDROID_PLAYER, i);
                    return i;
                } else
                    mBoard[i] = curr;
            }
        }

        do {
            move = mRand.nextInt(BOARD_SIZE);
        } while (mBoard[move] == HUMAN_PLAYER || mBoard[move] == ANDROID_PLAYER);

        setMove(ANDROID_PLAYER, move);
        return move;
    }


}
