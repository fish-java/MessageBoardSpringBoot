package com.github.zhang89.messageboardsbjdbc.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class RandomStringTest {

    @Test
    public void nextString() {
        System.out.println(new RandomString(20));
        System.out.println(new RandomString(40).nextString());
    }
}