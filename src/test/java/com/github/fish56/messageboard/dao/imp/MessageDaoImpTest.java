package com.github.fish56.messageboard.dao.imp;

import com.github.fish56.messageboard.entity.Message;
import com.github.fish56.messageboard.utils.Printer;
import com.github.fish56.messageboard.utils.RandomString;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class MessageDaoImpTest {
    @Test
    public void insertOne() {
        Message Message = new Message();
        Message.setContent("Hello world, this is from Java");
        Message.setUsername("Zhang");
        boolean res = MessageDaoImp.getInstance().insertOne(Message);
        Assert.assertTrue(res);
    }

    @Test
    public void updateOne() {
        Message Message = new Message();
        Message.setId(2);
        Message.setContent("Change by Java");
        boolean res = MessageDaoImp.getInstance().updateOne(Message);
        Assert.assertTrue(res);
    }

    @Test
    public void deleteOneByKey() {
    }

    @Test
    public void selectOneByKey() {
        Message message = MessageDaoImp.getInstance().selectOneByKey(3);
        Assert.assertEquals(3,message.getId());
        Printer.message(message);
    }

    @Test
    public void selectMany() {
        List<Message> messages = MessageDaoImp.getInstance().selectMany();
        Assert.assertTrue(messages != null);
        Printer.messages(messages);
    }
}