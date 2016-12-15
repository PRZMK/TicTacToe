package eu.przemyslawzawadzki.tictactoe.controller;

import eu.przemyslawzawadzki.tictactoe.enums.GameMode;

/**
 * Created by przemyslawz on 15.12.2016.
 */

public class GameModeChooser {

    public static TicTacToeGame getGameWithMode(GameMode mode) {
        switch (mode) {
            case MULTI_PLAYER_MODE: {
                return GameModeChooser.getMultiPlayerGame();
            }
            case SINGLE_PLAYER_MODE: {
                return GameModeChooser.getSinglePlayerGame();
            }
            default:
                return GameModeChooser.getSinglePlayerGame();
        }
    }

    public static TicTacToeGame getSinglePlayerGame() {
        return SinglePlayerGame.createSinglePlayer();
    }

    public static TicTacToeGame getMultiPlayerGame() {
        return MultiPlayerGame.createMultiPlayer();
    }

}
