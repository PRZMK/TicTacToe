package eu.przemyslawzawadzki.tictactoe.controller;

import java.util.Random;

/**
 * Created by przemyslawz on 14.12.2016.
 */

public abstract class TicTacToeGame {

    protected char[] mBoard;
    public final static int BOARD_SIZE = 9;

    public static final char HUMAN_PLAYER = 'X';
    public static final char ANDROID_PLAYER = '0';
    public static final char EMPTY_SPACE = ' ';


    public TicTacToeGame() {
        mBoard = new char[BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++)
            mBoard[i] = EMPTY_SPACE;


    }
    public abstract int getOpponentMove();


    public void clearBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            mBoard[i] = EMPTY_SPACE;
        }
    }

    public void setMove(char player, int location) {
        mBoard[location] = player;
    }



    public int checkForWinner() {
        for (int i = 0; i <= 6; i += 3) {
            if (mBoard[i] == HUMAN_PLAYER &&
                    mBoard[i + 1] == HUMAN_PLAYER &&
                    mBoard[i + 2] == HUMAN_PLAYER) {
                return 2;
            }
            if (mBoard[i] == ANDROID_PLAYER &&
                    mBoard[i + 1] == ANDROID_PLAYER &&
                    mBoard[i + 2] == ANDROID_PLAYER) {
                return 3;
            }
        }

        for (int i = 0; i <= 2; i++) {
            if (mBoard[i] == HUMAN_PLAYER &&
                    mBoard[i + 3] == HUMAN_PLAYER &&
                    mBoard[i + 6] == HUMAN_PLAYER) {
                return 2;
            }
            if (mBoard[i] == ANDROID_PLAYER &&
                    mBoard[i + 3] == ANDROID_PLAYER &&
                    mBoard[i + 6] == ANDROID_PLAYER) {
                return 3;
            }
        }

        if ((mBoard[0] == HUMAN_PLAYER &&
                mBoard[4] == HUMAN_PLAYER &&
                mBoard[8] == HUMAN_PLAYER) ||
                mBoard[2] == HUMAN_PLAYER &&
                        mBoard[4] == HUMAN_PLAYER &&
                        mBoard[6] == HUMAN_PLAYER) {
            return 2;
        }
        if ((mBoard[0] == ANDROID_PLAYER &&
                mBoard[4] == ANDROID_PLAYER &&
                mBoard[8] == ANDROID_PLAYER) ||
                mBoard[2] == ANDROID_PLAYER &&
                        mBoard[4] == ANDROID_PLAYER &&
                        mBoard[6] == ANDROID_PLAYER) {
            return 3;
        }
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (mBoard[i] != HUMAN_PLAYER && mBoard[i] != ANDROID_PLAYER)
                return 0;
        }

        return 1;
    }
}
