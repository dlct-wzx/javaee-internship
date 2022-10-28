package com.dlct.pojo;

public class Users {
    private String name;
    private String pwd;

    public String getName() {
        return name;
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

    public Users(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    public Users() {
    }

    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
