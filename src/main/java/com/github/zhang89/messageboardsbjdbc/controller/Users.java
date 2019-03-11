package com.github.zhang89.messageboardsbjdbc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.zhang89.messageboardsbjdbc.domain.User;
import com.github.zhang89.messageboardsbjdbc.dao.imp.UserDaoImpJDBC;
import com.github.zhang89.messageboardsbjdbc.util.Mapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController("/users")
public class Users {
//    @PostMapping("/users")
//    public ResponseEntity<String> createUser(
//            // auto check if header exists
//            @RequestHeader(value = "username") String user_name,
//            @RequestHeader(value = "password") String password) throws SQLException {
//        HttpHeaders resHeaders = new HttpHeaders();
//
//        String sqlCheckIfUsernameExist = "select user_name from users where user_name = ? ;";
//        PreparedStatement psmCheck = ConnectionUtil.getPreparedStatement(sqlCheckIfUsernameExist);
//        psmCheck.setString(1,user_name);
//
//        ResultSet rs = psmCheck.executeQuery(sqlCheckIfUsernameExist);
//        if(rs.getRow() > 0){
//            JSONObject errRes = new JSONObject();
//            errRes.put("message", "user name already exists");
//            ConnectionUtil.releasePreparedStatement(psmCheck);
//            return new ResponseEntity<String>(errRes.toJSONString(), resHeaders, HttpStatus.FORBIDDEN);
//        }
//
//        // preparedStatement 用起来安全，需要拼接字符串的时候也比普通的舒服
//        // 不懂为什么以前喜欢使用一般的
//        String token = "It is a token..";
//        String sqlCreateUser = "insert into users(user_name, password, token) value(?,?,?);";
//
//        PreparedStatement psmCreate = ConnectionUtil.getPreparedStatement(sqlCreateUser);
//        psmCreate.setString(1,user_name);
//        psmCreate.setString(2,password);
//        psmCreate.setString(3,token);
//
//        boolean isSuccess = psmCreate.execute(sqlCreateUser);
//        if(!isSuccess){
//            return new ResponseEntity<String>("error", resHeaders, HttpStatus.FORBIDDEN);
//        }
//        return new ResponseEntity<String>("sdf",resHeaders,HttpStatus.CREATED);
//    }

    @PostMapping("/users")
    public ResponseEntity<String> createUser(
            @RequestHeader(value = "username") String user_name,
            @RequestHeader(value = "password") String password) throws SQLException {
        HttpHeaders resHeaders = new HttpHeaders();

        //Users newUser = new Users()
        return new ResponseEntity<String>("sdf",resHeaders,HttpStatus.CREATED);
    }

    @GetMapping("/users/{username}")
    public ResponseEntity<String> getUser(@PathVariable String username){
        HttpHeaders resHeaders = new HttpHeaders();

        System.out.println("handler request from getUser");
        User user = new UserDaoImpJDBC().getUserByName(username);
        if(user == null){
            return new ResponseEntity<String>("error",resHeaders,HttpStatus.NOT_FOUND);
        }

        try {
            String resJSONString = Mapper.getJSONStringFromObj(user);
            return new ResponseEntity<String>(resJSONString, resHeaders, HttpStatus.OK);
        } catch (JsonProcessingException e){
            return new ResponseEntity<String>("error",resHeaders,HttpStatus.BAD_REQUEST);
        }
    }

}
