package com.github.fish56.messageboard.utils;

import java.util.regex.Pattern;

public class NameVerifier {
    public static boolean isValid(String s){
        // should begin with a alphabet, no special char.
        return Pattern.matches("^[A-Za-z][A-Za-z0-9]*",s);
    }
}
