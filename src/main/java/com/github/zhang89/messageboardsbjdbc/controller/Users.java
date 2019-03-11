package com.github.zhang89.messageboardsbjdbc.controller;

import com.github.zhang89.messageboardsbjdbc.common.ConnectionUtil;
import com.github.zhang89.messageboardsbjdbc.domain.Message;
import org.json.simple.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@RestController("/user")
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

    public ResponseEntity<String> createUser(
            @RequestHeader(value = "username") String user_name,
            @RequestHeader(value = "password") String password) throws SQLException {
        HttpHeaders resHeaders = new HttpHeaders();

        //Users newUser = new Users()
        return new ResponseEntity<String>("sdf",resHeaders,HttpStatus.CREATED);
    }
}
