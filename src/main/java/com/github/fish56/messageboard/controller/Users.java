package com.github.fish56.messageboard.controller;

import com.github.fish56.messageboard.dao.imp.UserDaoImp;
import com.github.fish56.messageboard.entity.User;
import com.github.fish56.messageboard.utils.NameVerifier;
import com.github.fish56.messageboard.utils.RandomString;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/users")
public class Users {
    @PostMapping
    public ResponseEntity<HashMap> createUser(
            @RequestHeader(value = "username") String username,
            @RequestHeader(value = "password") String password) {
        if(!NameVerifier.isValid(username)){
            HashMap<String, String> res = new HashMap<>();
            res.put("message", "name should start with alphabet and no special char");
            return new ResponseEntity<HashMap>(res, HttpStatus.NOT_FOUND);
        }

        String token = RandomString.Token.generateToken();
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setToken(token);
        boolean isCreate = UserDaoImp.getInstance().insertOne(user);
        HashMap<String, String> res = new HashMap<>();
        if(!isCreate){
            res.put("message", "failed to insert to database");
            return new ResponseEntity<HashMap>(res,HttpStatus.FORBIDDEN);
        }
        res.put("message", "success");
        res.put("token", token);
        return new ResponseEntity<HashMap>(res,HttpStatus.CREATED);
    }
}
