package com.github.zhang89.messageboardsbjdbc.dao.imp;

import com.github.zhang89.messageboardsbjdbc.domain.Message;
import com.github.zhang89.messageboardsbjdbc.domain.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserDaoImpJDBCTest {

    @Test
    public void getUserByName() {
        User user = new UserDaoImpJDBC().getUserByName("Jon");
        Assert.assertTrue(user != null);
        System.out.println(user.getToken());
    }
}