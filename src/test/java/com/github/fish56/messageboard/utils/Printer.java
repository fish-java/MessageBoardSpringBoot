package com.github.fish56.messageboard.utils;

import com.github.fish56.messageboard.entity.Message;
import com.github.fish56.messageboard.entity.User;

import java.util.List;

public class Printer {
    public static void user(User user){
        System.out.println(user.getUsername() + user.getPassword()
          + user.getPassword());
    }
    public static void users(List<User> users){
        for(User user : users){
            Printer.user(user);
        }
    }
    public static void message(Message message){
        System.out.println(message.getUsername() + message.getContent());
    }
    public static void messages(List<Message> messages){
        for(Message message : messages){
            Printer.message(message);
        }
    }
}
