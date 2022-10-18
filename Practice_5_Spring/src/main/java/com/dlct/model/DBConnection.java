package com.dlct.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private String driver;
    private String url;
    private String user;
    private String passwd;
    static Connection con;

    public Connection getCon() throws ClassNotFoundException, SQLException {

        if(con == null){
            Class.forName(driver);
            con = DriverManager.getConnection(url,user,passwd);
        }
        return con;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public DBConnection(String driver, String url, String user, String passwd) {
        this.driver = driver;
        this.url = url;
        this.user = user;
        this.passwd = passwd;
    }

    public DBConnection() {
    }
}
