package com.github.zhang89.messageboardsbjdbc.dao;

import com.github.zhang89.messageboardsbjdbc.domain.User;

public interface UserDao {
    public User getUserByName(String username);
    public User getUserByToken(String token);
    public boolean createUser(User user);
}
