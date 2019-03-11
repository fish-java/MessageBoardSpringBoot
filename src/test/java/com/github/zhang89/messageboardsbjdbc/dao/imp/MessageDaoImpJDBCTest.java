package com.github.zhang89.messageboardsbjdbc.dao.imp;

import com.github.zhang89.messageboardsbjdbc.domain.Message;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MessageDaoImpJDBCTest {

    @Test
    public void getMessages() {
        List<Message> messages = new MessageDaoImpJDBC().getMessages(10, 0);
        Assert.assertTrue(messages != null);
        for (int i = 0; i < messages.size(); i++) {
            System.out.println(messages.get(i).getContent());
        }
    }
}