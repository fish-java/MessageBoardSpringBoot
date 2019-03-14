package com.github.fish56.messageboard.dao.imp;

import com.github.fish56.messageboard.dao.MessageDao;
import com.github.fish56.messageboard.entity.Message;
import com.github.fish56.messageboard.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MessageDaoImp implements MessageDao {
    private static MessageDaoImp instance;
    private MessageDaoImp(){}
    public static MessageDaoImp getInstance(){
        if(instance == null) {
            synchronized (MessageDaoImp.class){
                if(instance == null) {
                    instance = new MessageDaoImp();
                }
            }
        }
        return  instance;
    }

    @Override
    public List<Message> selectMany(Message Message) {
        SqlSession session = SqlSessionFactoryUtil.getSqlSession();
        List<Message> Messages = session.selectList("selectManyMessages", Message);
        session.commit();
        SqlSessionFactoryUtil.closeSqlSession(session);
        return Messages;
    }
    @Override
    public List<Message> selectMany() {
        Message message = new Message();
        return MessageDaoImp.getInstance().selectMany(message);
    }
    @Override
    public Message selectOneByKey(Integer id) {
        Message message = new Message();
        message.setId(id);
        SqlSession session = SqlSessionFactoryUtil.getSqlSession();
        message = session.selectOne("selectOneMessage", message);
        session.commit();
        SqlSessionFactoryUtil.closeSqlSession(session);
        return message;
    }
    @Override
    public Message selectOneByUsername(String username) {
        Message message = new Message();
        message.setUsername(username);
        List<Message> res = MessageDaoImp.getInstance().selectMany(message);
        if(res == null || res.size() == 0){
            return null;
        }
        return res.get(0);
    }


    @Override
    public boolean insertOne(Message Message) {
        SqlSession session = SqlSessionFactoryUtil.getSqlSession();
        int res = session.insert("insertOneMessage",Message);
        session.commit();
        SqlSessionFactoryUtil.closeSqlSession(session);
        return res == 1;
    }

    @Override
    public boolean updateOne(Message Message) {
        SqlSession session = SqlSessionFactoryUtil.getSqlSession();
        int res = session.update("updateOneMessage", Message);
        session.commit();
        SqlSessionFactoryUtil.closeSqlSession(session);
        return res == 1;
    }

    @Override
    public boolean deleteOneByKey(Integer kt) {
        return false;
    }



}
