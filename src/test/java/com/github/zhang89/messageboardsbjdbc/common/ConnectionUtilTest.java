package com.github.zhang89.messageboardsbjdbc.common;

import org.junit.Test;

import java.sql.ResultSet;
import java.sql.Statement;

import static org.junit.Assert.*;

public class ConnectionUtilTest {

    @Test
    public void getStatement() throws Exception {
        String sql = "select user_name,password,token,birthday,phone_number," +
                "email, create_datetime from users";
        String sql2 = "select user_name,password,token,birthday," +
                "email, create_datetime from users";
        String sql3 = "select user_name,password,token,phone_number," +
                "email, create_datetime from users";
        Statement sm = ConnectionUtil.getStatement();
        Statement sm2 = ConnectionUtil.getStatement();
        Statement sm3 = ConnectionUtil.getStatement();
        ResultSet rs = sm.executeQuery(sql);
        sm.executeQuery(sql);
        sm2.executeQuery(sql2);
        sm.close();
        sm3.executeQuery(sql3);

    }
}