package com.github.zhang89.messageboardsbjdbc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.zhang89.messageboardsbjdbc.common.ConnectionUtil;
import com.github.zhang89.messageboardsbjdbc.dao.imp.MessageDaoImpJDBC;
import com.github.zhang89.messageboardsbjdbc.domain.Message;
import com.github.zhang89.messageboardsbjdbc.util.Mapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Controller
@RequestMapping("/messages")
public class Messages {
    @GetMapping()
    public ResponseEntity<String> getMessagesList() throws SQLException{

        HttpHeaders responseHeaders = new HttpHeaders();
        List<Message> messages = new MessageDaoImpJDBC().getMessages();

        if(messages == null){
            return new ResponseEntity<String>("error", responseHeaders, HttpStatus.NO_CONTENT);
        }

        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < messages.size(); i++) {
            jsonArray.add(messages.get(i));
        }

        String res;
        try {
            res = Mapper.getJSONStringFromObj(jsonArray);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return new ResponseEntity<String>("error",responseHeaders,HttpStatus.FORBIDDEN);
        }
        responseHeaders.set("Content-Type", "application/json");
        return new ResponseEntity<String>(res, responseHeaders, HttpStatus.OK);

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
