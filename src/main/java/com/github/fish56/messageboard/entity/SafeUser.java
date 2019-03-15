package com.github.fish56.messageboard.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SafeUser {
    private String username;
    private String email;
    private Date birthday;
    private Date createDatetime;
    private Date updateDatetime;
    private Integer phoneNumber;

    public SafeUser(User user){
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.birthday = user.getBirthday();
        this.createDatetime = user.getCreateDatetime();
        this.updateDatetime = user.getUpdateDatetime();
        this.phoneNumber = user.getPhoneNumber();
    }
    public static List<SafeUser> SafeUserList(List<User> users){
        List<SafeUser> safeUsers = new ArrayList<>();
        for (User user : users){
            safeUsers.add(new SafeUser(user));
        }
        return safeUsers;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
