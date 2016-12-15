package eu.przemyslawzawadzki.tictactoe.controller;

/**
 * Created by przemyslawz on 15.12.2016.
 */
public class MultiPlayerGame extends TicTacToeGame {

    public MultiPlayerGame() {
        super();
    }

    @Override
    public int getOpponentMove() {
        return 1;
    }

    public void sendMoveToOpponent(int i){

    }
}
