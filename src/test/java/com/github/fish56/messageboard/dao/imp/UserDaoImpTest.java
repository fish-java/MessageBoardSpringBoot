package com.github.fish56.messageboard.dao.imp;

import com.github.fish56.messageboard.entity.User;
import com.github.fish56.messageboard.utils.Printer;
import com.github.fish56.messageboard.utils.RandomString;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class UserDaoImpTest {
    private static String nameOfNewCreatedUser;
    private static String tokenOfNewCreatedUser;

    // create a user before test, easy for
    // follow test
    @BeforeClass
    public static void insertOne() {
        User user = new User();
        // create a new username with random string
        // low probability that collision with exist username
        String name = RandomString.Token.generateToken().substring(0,8);
        user.setUsername(name);
        user.setPassword("1232151");
        String token = RandomString.Token.generateToken();
        user.setToken(token);
        boolean res = UserDaoImp.getInstance().insertOne(user);
        Assert.assertTrue(res);

        // save name and token for next test
        nameOfNewCreatedUser = name;
        tokenOfNewCreatedUser = token;
    }

    @Test
    public void selectUserByToken() {
        String token = tokenOfNewCreatedUser;
        User res = UserDaoImp.getInstance().selectOneByToken(token);
        Assert.assertEquals(nameOfNewCreatedUser, res.getUsername());
        Printer.user(res);
    }


    @Test
    public void updateOne() {
        User user = new User();
        user.setUsername(nameOfNewCreatedUser);
        user.setPassword("esdfeeesf");
        String newToken = RandomString.Token.generateToken();
        user.setToken(newToken);
        boolean res = UserDaoImp.getInstance().updateOne(user);
        Assert.assertTrue(res);

        tokenOfNewCreatedUser = newToken;
    }

    @Test
    public void updateOne2() {
        User user = new User();
        user.setUsername("NotExistsName");
        user.setPassword("eee");
        user.setToken(RandomString.Token.generateToken());
        boolean res = UserDaoImp.getInstance().updateOne(user);
        Assert.assertFalse(res);
    }

    @Test
    public void deleteOneByKey() {
    }

    @Test
    public void selectOneByKey() {
        User user = UserDaoImp.getInstance().selectOneByKey(nameOfNewCreatedUser);
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