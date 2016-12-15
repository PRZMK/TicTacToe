package eu.przemyslawzawadzki.tictactoe.controller;

import eu.przemyslawzawadzki.tictactoe.enums.GameMode;

/**
 * Created by przemyslawz on 15.12.2016.
 */

public class GameModeChooser {

    public static TicTacToeGame getGameWithMode(GameMode mode) {
        switch (mode) {
            case MULTI_PLAYER_MODE: {
                return new MultiPlayerGame();
            }
            case SINGLE_PLAYER_MODE: {
                return new SinglePlayerGame();
            }
            default:
                return new SinglePlayerGame();
        }
    }

    public static TicTacToeGame getSinglePlayerGame() {
        return new SinglePlayerGame();
    }

    public static TicTacToeGame getMultiPlayerGame() {
        return new MultiPlayerGame();
    }

}
