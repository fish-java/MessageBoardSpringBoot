package com.github.zhang89.messageboardsbjdbc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.zhang89.messageboardsbjdbc.domain.User;
import com.github.zhang89.messageboardsbjdbc.dao.imp.UserDaoImpJDBC;
import com.github.zhang89.messageboardsbjdbc.util.Mapper;
import com.github.zhang89.messageboardsbjdbc.util.Token;
import org.json.simple.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
@RequestMapping("/users")
public class Users {
    @PostMapping()
    public ResponseEntity<String> createUser(
            @RequestHeader(value = "username") String user_name,
            @RequestHeader(value = "password") String password) throws SQLException {
        HttpHeaders resHeaders = new HttpHeaders();

        String token = Token.generateToken();
        User newUser = new User(user_name,password, token);
        boolean isCreate = new UserDaoImpJDBC().createUser(newUser);
        if(!isCreate){
            return new ResponseEntity<String>("{}",resHeaders,HttpStatus.FORBIDDEN);
        }
        JSONObject res = new JSONObject();
        res.put("token", token);
        return new ResponseEntity<String>(res.toJSONString(),resHeaders,HttpStatus.CREATED);
    }
}
