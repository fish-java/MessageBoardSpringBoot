package com.github.fish56.messageboard.dao.imp;

import com.github.fish56.messageboard.entity.User;
import com.github.fish56.messageboard.utils.Printer;
import com.github.fish56.messageboard.utils.RandomString;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class UserDaoImpTest {

    @Test
    public void selectUserByToken() {
        String token = "i86zPDI0TOocmXK4XAfv6toRj6AyU7";
        User res = UserDaoImp.getInstance().selectOneByToken(token);
        Assert.assertEquals("Ache", res.getUsername());
        Printer.user(res);
    }

    @Test
    public void insertOne() {
        User user = new User();
        user.setUsername("Ache");
        user.setPassword("1232151");
        user.setToken(RandomString.Token.generateToken());
        boolean res = UserDaoImp.getInstance().insertOne(user);
        Assert.assertTrue(res);
    }

    @Test
    public void updateOne() {
        User user = new User();
        user.setUsername("Ache");
        user.setPassword("eee");
        user.setToken(RandomString.Token.generateToken());
        boolean res = UserDaoImp.getInstance().updateOne(user);
        Assert.assertTrue(res);
    }

    @Test
    public void updateOne2() {
        User user = new User();
        user.setUsername("NotExists");
        user.setPassword("eee");
        user.setToken(RandomString.Token.generateToken());
        boolean res = UserDaoImp.getInstance().updateOne(user);
        Assert.assertTrue(res);
    }

    @Test
    public void deleteOneByKey() {
    }

    @Test
    public void selectOneByKey() {
        User user = UserDaoImp.getInstance().selectOneByKey("ache");
        Assert.assertTrue(user != null);
        Printer.user(user);
    }

    @Test
    public void selectMany() {
        List<User> users = UserDaoImp.getInstance().selectMany();
        Assert.assertTrue(users != null);
        Printer.users(users);
    }
}