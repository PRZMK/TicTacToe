package eu.przemyslawzawadzki.tictactoe.model;

import android.support.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by przemyslawz on 14.12.2016.
 */

public class LoginAutorization {
    private static Map<String, String> CREDENTIALS = new HashMap<>();
    static {
        CREDENTIALS.put("foo@example.com","hello");
        CREDENTIALS.put("bar@example.com","world");
    }

    public static final String LOGIN_SUCCESS_RESULT = "Login to TicTacToe game";
    public static final String LOGIN_FAIL_RESULT = "lfr";
    public static final String REGISTER_RESULT = "Register new user to TicTacToe game";

    public static String checkCredential(String username, String password){
        if(CREDENTIALS.containsKey(username)) {
            return checkPassword(username, password);
        }else {
            CREDENTIALS.put(username,password);
            return REGISTER_RESULT;
        }
    }

    @NonNull
    private static String checkPassword(String username, String password) {
        if (CREDENTIALS.get(username).equals(password)) {
            return LOGIN_SUCCESS_RESULT;
        } else {
            return LOGIN_FAIL_RESULT;
        }
    }

    ;
}
