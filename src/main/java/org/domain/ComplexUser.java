package org.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComplexUser {
    private int id;
    private  String info;
    private User user;//复杂对象   对象套对象

    private List<User> userList;//集合管理对象   对象套集合

    private HashMap<String,User> usermap;

    @Override
    public String toString() {
        return "ComplexUser{" +
                "id=" + id +
                ", info='" + info + '\'' +
                ", user=" + user +
                ", userList=" + userList +
                ", usermap=" + usermap +
                '}';
    }

    public HashMap<String, User> getUsermap() {
        return usermap;
    }

    public void setUsermap(HashMap<String, User> usermap) {
        this.usermap = usermap;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
