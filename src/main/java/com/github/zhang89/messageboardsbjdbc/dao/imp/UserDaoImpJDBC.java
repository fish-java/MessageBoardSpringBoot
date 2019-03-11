package com.github.zhang89.messageboardsbjdbc.dao.imp;

import com.github.zhang89.messageboardsbjdbc.common.ConnectionUtil;
import com.github.zhang89.messageboardsbjdbc.dao.UserDao;
import com.github.zhang89.messageboardsbjdbc.domain.User;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpJDBC implements UserDao {
    @Override
    public User getUserByName(String username) {
        String sql = "select user_name,password,token,birthday,phone_number," +
                "email, create_datetime from users where user_name = ?";
        PreparedStatement ps = ConnectionUtil.getPreparedStatement(sql);
        try {
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            if(!rs.next()){
                return null;
            }
            String user_name = rs.getString("user_name");
            String password = rs.getString("password");
            String token = rs.getString("password");
            User user = new User(user_name, null,null);
            user.setPassword(password);
            user.setToken(token);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                ps.close();
            }catch (Exception e1){}
            return null;
        }
    }

    @Override
    public User getUserByToken(String token) {
        return null;
    }

    @Override
    public boolean createUser(User user) {
        String sql = "insert into users(user_name, password,token," +
                "birthday, phone_number, email, birthday)" +
                "values(?, ?, ?, ? ,?, ?, ?);";
        PreparedStatement ps = ConnectionUtil.getPreparedStatement(sql);
        try {
            ps.setString(1,user.getUser_name());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getToken());
            ps.setInt(4,user.getPhone_number());
            ps.setString(5,user.getEmail());
            ps.setDate(6,new Date(user.getBirthday().getTime()));
            boolean rs = ps.execute();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
