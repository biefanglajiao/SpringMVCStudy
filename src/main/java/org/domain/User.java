package org.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class User {
    //json格式返回的参数实例
    private  String name;
    private  int id;
    private  String password;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    //在pojo类中使用
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
