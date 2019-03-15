package com.github.fish56.messageboard.utils;

import org.apache.commons.text.StringEscapeUtils;
import org.junit.Test;

public class XSS {
    @Test
    public void trans(){
        String a = "sdfsd<script></script>";
        String s = StringEscapeUtils.escapeHtml4(a);
        System.out.println(s);
    }
}
