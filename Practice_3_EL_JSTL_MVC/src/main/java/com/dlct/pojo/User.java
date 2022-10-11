package com.dlct.pojo;

public class User {
    private String name;
    private String pwd;

    public String getName() {
        return name;
    }

    public User(String name) {
        this.name = name;
    }

    public User() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
