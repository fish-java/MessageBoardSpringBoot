package com.github.fish56.messageboard.controller.users;

import com.github.fish56.messageboard.dao.imp.UserDaoImp;
import com.github.fish56.messageboard.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/users/{username}")
public class Username {
    @GetMapping
    public ResponseEntity<? extends Object> getUser(@PathVariable String username){
        User user = UserDaoImp.getInstance().selectOneByKey(username);

        if(user == null){
            HashMap<String, String> res = new HashMap<>();
            res.put("message", "user not found");
            return new ResponseEntity<HashMap>(res, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Object>(user, HttpStatus.OK);
    }
}
