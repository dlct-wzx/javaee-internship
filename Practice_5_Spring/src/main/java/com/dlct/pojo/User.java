package com.dlct.pojo;

public class User {
    private int id;
    private String user_name;
    private String passwd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public User() {
    }

    public User(int id, String user_name, String passwd) {
        this.id = id;
        this.user_name = user_name;
        this.passwd = passwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", user_name='" + user_name + '\'' +
                ", passwd='" + passwd + '\'' +
                '}';
    }
}
