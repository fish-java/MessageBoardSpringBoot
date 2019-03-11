package com.github.zhang89.messageboardsbjdbc.dao.imp;

import com.github.zhang89.messageboardsbjdbc.common.ConnectionUtil;
import com.github.zhang89.messageboardsbjdbc.dao.MessageDao;
import com.github.zhang89.messageboardsbjdbc.domain.Message;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
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
        return getMessages(10);
    }

    @Override
    public List<Message> getMessages(int limit) {
        return getMessages(limit, 0);
    }

    @Override
    public List<Message> getMessages(int limit, int offset) {
        String sql = "select id,content,user_name,update_datetime from messages"
                      + " order by update_datetime limit ? offset ?;";
        PreparedStatement ps = ConnectionUtil.getPreparedStatement(sql);
        ResultSet rs = null;
        List<Message> messages = new LinkedList<Message>();
        try {
            ps.setInt(1,limit);
            ps.setInt(2,offset);
            rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String content = rs.getString("content");
                String user_name = rs.getString("user_name");
                Date date = rs.getDate("update_datetime");
                Message message = new Message(content, user_name);
                message.setId(id);
                message.setUpdate_time(date);
                messages.add(message);
            }
            ps.close();
            return messages;
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                ps.close();
            }catch (Exception e1){
                e1.printStackTrace();
            }
            return null;
        }
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
