package com.github.zhang89.messageboardsbjdbc.util;

public class Token {
    private static RandomString rs = new RandomString(30);
    public static String generateToken(){
        return rs.nextString();
    }
}
