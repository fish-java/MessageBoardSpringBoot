package com.github.fish56.messageboard.dao;

import com.github.fish56.messageboard.entity.Message;

import java.util.List;

public interface MessageDao extends Dao<Message, Integer> {
    public Message selectOneByUsername(String name);
}
