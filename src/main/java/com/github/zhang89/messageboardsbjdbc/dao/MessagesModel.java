package com.github.zhang89.messageboardsbjdbc.dao;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MessagesModel {
    public static String
      getMessagesJSONArrayStringFromResultSet(ResultSet rs){
        if(rs == null){
            return "[]";
        }
        JSONArray messages = new JSONArray();
        try {
            while (rs.next()){
                JSONObject message = new JSONObject();
                message.put("id", rs.getInt("id"));
                message.put("content",rs.getString("content"));
                message.put("user_name",rs.getString("user_name"));
                message.put("create_datetime",rs.getString("create_datetime"));
                messages.add(message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messages.toJSONString();
    }
}
