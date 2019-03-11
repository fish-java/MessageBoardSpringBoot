package com.github.zhang89.messageboardsbjdbc.dao;

import com.github.zhang89.messageboardsbjdbc.domain.Message;

import java.util.List;

public interface MessageDao {
    public boolean insertMessage(Message message);
    public Message selectMessageById(int id);
    public boolean updateMessageById(Message message);
    public boolean deleteMessage(Message message);
    public boolean deleteMessageByID(int id);

    // get Messages, default value: limit 10, offset 20
    public List<Message> getMessages();
    public List<Message> getMessages(int limit);
    public List<Message> getMessages(int limit, int offset);

    public List<Message> getMessagesByUserName(String user_name);
    public List<Message> getMessagesByUserName(String user_name, int limit);
}
