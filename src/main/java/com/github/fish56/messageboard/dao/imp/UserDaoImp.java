package com.github.fish56.messageboard.dao.imp;

import com.github.fish56.messageboard.dao.UserDao;
import com.github.fish56.messageboard.entity.User;
import com.github.fish56.messageboard.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDaoImp implements UserDao {
    private static UserDaoImp instance;
    private UserDaoImp(){}
    public static UserDaoImp getInstance(){
        if(instance == null) {
            synchronized (UserDaoImp.class){
                if(instance == null) {
                    instance = new UserDaoImp();
                }
            }
        }
        return  instance;
    }

    @Override
    public List<User> selectMany() {
        User user = new User();
        return UserDaoImp.getInstance().selectMany(user);
    }

    @Override
    public User selectOneByToken(String token) {
        User user = new User();
        user.setToken(token);
        List<User> res = UserDaoImp.getInstance().selectMany(user);
        if(res == null || res.size() == 0){
            return null;
        }
        return res.get(0);
    }

    @Override
    public boolean insertOne(User user) {
        SqlSession session = SqlSessionFactoryUtil.getSqlSession();
        int res = session.insert("insertOneUser",user);
        session.commit();
        SqlSessionFactoryUtil.closeSqlSession(session);
        return res == 1;
    }

    @Override
    public boolean updateOne(User user) {
        SqlSession session = SqlSessionFactoryUtil.getSqlSession();
        int res = session.update("updateOneUser", user);
        session.commit();
        SqlSessionFactoryUtil.closeSqlSession(session);
        return res == 1;
    }

    @Override
    public boolean deleteOneByKey(String kt) {
        return false;
    }

    @Override
    public User selectOneByKey(String username) {
        User user = new User();
        user.setUsername(username);
        List<User> res = UserDaoImp.getInstance().selectMany(user);
        if(res == null || res.size() == 0){
            return null;
        }
        return res.get(0);
    }

    @Override
    public List<User> selectMany(User user) {
        SqlSession session = SqlSessionFactoryUtil.getSqlSession();
        List<User> users = session.selectList("selectManyUsers", user);
        session.commit();
        SqlSessionFactoryUtil.closeSqlSession(session);
        return users;
    }
}
