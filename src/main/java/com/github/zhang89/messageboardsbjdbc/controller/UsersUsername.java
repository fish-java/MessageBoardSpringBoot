package com.github.zhang89.messageboardsbjdbc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.zhang89.messageboardsbjdbc.dao.imp.UserDaoImpJDBC;
import com.github.zhang89.messageboardsbjdbc.domain.User;
import com.github.zhang89.messageboardsbjdbc.util.Mapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/users/{username}")
public class UsersUsername {
    @GetMapping()
    public ResponseEntity<String> getUser(@PathVariable String username){
        HttpHeaders resHeaders = new HttpHeaders();

        System.out.println("handler request from getUser");
        User user = new UserDaoImpJDBC().getUserByName(username);

        if(user == null){
            return new ResponseEntity<String>("user not exists",resHeaders, HttpStatus.NOT_FOUND);
        }

        try {
            String resJSONString = Mapper.getJSONStringFromObj(user);
            resHeaders.set("Content-Type", "application/json");
            return new ResponseEntity<String>(resJSONString, resHeaders, HttpStatus.OK);
        } catch (JsonProcessingException e){
            return new ResponseEntity<String>("can not convert to json",resHeaders,HttpStatus.BAD_REQUEST);
        }
    }
}
