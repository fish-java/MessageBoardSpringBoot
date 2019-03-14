package com.github.fish56.messageboard.dao;

import com.github.fish56.messageboard.entity.User;

public interface UserDao extends Dao<User, String> {
    public User selectOneByToken(String token);
}
