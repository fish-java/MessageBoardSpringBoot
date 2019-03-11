package com.github.zhang89.messageboardsbjdbc.dao.imp;

import com.github.zhang89.messageboardsbjdbc.common.ConnectionUtil;
import com.github.zhang89.messageboardsbjdbc.dao.MessageDao;
import com.github.zhang89.messageboardsbjdbc.domain.Message;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MessageDaoImpJDBC implements MessageDao {

    @Override
    public boolean insertMessage(Message message) {
        String sql = "insert into messages(content, user_name) value(?, ?)";
        PreparedStatement ps = ConnectionUtil.getPreparedStatement(sql);
        try {
            ps.setString(1,message.getContent());
            ps.setString(2,message.getUser_name());
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                ps.close();
            }catch (Exception e1){}
            return false;
        }
    }

    @Override
    public Message selectMessageById(int id) {
        return null;
    }

    @Override
    public boolean updateMessageById(Message message) {
        return false;
    }

    @Override
    public boolean deleteMessage(Message message) {
        return false;
    }

    @Override
    public boolean deleteMessageByID(int id) {
        return false;
    }

    @Override
    public List<Message> getMessages() {
        return null;
    }

    @Override
    public List<Message> getMessages(int limit) {
        return null;
    }

    @Override
    public List<Message> getMessages(int limit, int offset) {
        return null;
    }

    @Override
    public List<Message> getMessagesByUserName(String user_name) {
        return null;
    }

    @Override
    public List<Message> getMessagesByUserName(String user_name, int limit) {
        return null;
    }
}
