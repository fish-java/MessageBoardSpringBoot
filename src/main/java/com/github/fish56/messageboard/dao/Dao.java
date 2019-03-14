package com.github.fish56.messageboard.dao;

import com.github.fish56.messageboard.entity.Message;

import java.util.List;

public interface Dao<T, KeyType> {
    public boolean insertOne(T t);
    public boolean updateOne(T t);
    public boolean deleteOneByKey(KeyType primaryKey);
    public T selectOneByKey(KeyType primaryKey);
    public List<T> selectMany(T t);
    public List<T> selectMany();
}
