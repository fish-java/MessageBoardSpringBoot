package com.github.zhang89.messageboardsbjdbc.controller;

import com.github.zhang89.messageboardsbjdbc.common.ConnectionUtil;
import com.github.zhang89.messageboardsbjdbc.dao.MessagesModel;
import com.github.zhang89.messageboardsbjdbc.dao.imp.MessageDaoImpJDBC;
import com.github.zhang89.messageboardsbjdbc.domain.Message;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@RestController("/messages")
public class Messages {
    @GetMapping
    public ResponseEntity<String> getMessagesList() throws SQLException{
        HttpHeaders responseHeaders = new HttpHeaders();

        Statement sm = ConnectionUtil.getStatement();
        if(sm == null){
            return new ResponseEntity<String>("error in connected to sql", responseHeaders, HttpStatus.FORBIDDEN);
        }

        String sql = "select id, content, user_name, create_datetime, update_datetime from messages limit 10;";
        ResultSet rs = sm.executeQuery(sql);
        String body = MessagesModel.getMessagesJSONArrayStringFromResultSet(rs);

        ConnectionUtil.releaseStatement(sm);
        responseHeaders.set("Content-Type", "application/json");

        return new ResponseEntity<String>(body, responseHeaders, HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<String> Message(
            @RequestHeader(value = "content") String content,
            @RequestHeader(value = "user_name") String user_name)
            throws SQLException{
        HttpHeaders responseHeaders = new HttpHeaders();
        Message message = new Message(content, user_name);
        boolean hasInsert = new MessageDaoImpJDBC().insertMessage(message);

        if(!hasInsert){
            return new ResponseEntity<String>("error", responseHeaders, HttpStatus.FORBIDDEN);
        }

        return new ResponseEntity<String>("success", responseHeaders, HttpStatus.OK);
    }
}
