package com.github.zhang89.messageboardsbjdbc.util;

import com.github.zhang89.messageboardsbjdbc.domain.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class MapperTest {

    @Test
    public void getJSONStringFromObj() throws Exception{
        User user = new User("Jon","123dsf","dsf");
        System.out.println(Mapper.getJSONStringFromObj(user));
    }

    @Test
    public void getJSONStringFromList() throws Exception{
        List<User> users = new ArrayList<User>();
        User user = new User("Jon","123dsf","dsf");
        users.add(user);
        System.out.println(Mapper.getJSONStringFromObj(users));
    }

    @Test
    public void getJSONStringFromSet() throws Exception{
        Set<User> users = new HashSet<User>();
        User user = new User("Jon","123dsf","dsf");
        users.add(user);
        System.out.println(Mapper.getJSONStringFromObj(users));
    }
}