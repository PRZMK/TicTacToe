package eu.przemyslawzawadzki.tictactoe.controller;

import java.util.Map;

/**
 * Created by przemyslawz on 15.12.2016.
 */
public class MultiPlayerGame extends TicTacToeGame {

    private static volatile MultiPlayerGame instance;

    private MultiPlayerGame() {
        super();
    }

    public static MultiPlayerGame createMultiPlayer(){
        if (instance == null){
            synchronized (SinglePlayerGame.class){
                if(instance == null){
                    instance = new MultiPlayerGame();
                }
            }
        }
        return instance;
    }

    @Override
    public int getOpponentMove() {
        return 1;
    }

    public void sendMoveToOpponent(int i){

    }
}
