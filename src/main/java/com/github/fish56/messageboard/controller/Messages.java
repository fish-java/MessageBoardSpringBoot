package com.github.fish56.messageboard.controller;

import com.github.fish56.messageboard.dao.imp.MessageDaoImp;
import com.github.fish56.messageboard.entity.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/messages")
public class Messages {
    @GetMapping()
    public List getMessagesList(){
        List<Message> messages = MessageDaoImp.getInstance().selectMany();
        return messages;
    }

    @PostMapping()
    public ResponseEntity<HashMap> Message( @RequestBody String content,
            @RequestHeader(value = "username") String username) {
        Message message = new Message();
        message.setUsername(username);
        message.setContent(content);
        boolean hasInsert = MessageDaoImp.getInstance().insertOne(message);
        HashMap<String ,String> res = new HashMap();
        if(!hasInsert){
            res.put("message", "Can not insert to database");
            return new ResponseEntity<HashMap>(res, HttpStatus.FORBIDDEN);
        }
        res.put("message", "success");
        return new ResponseEntity<HashMap>(res, HttpStatus.OK);
    }
}
