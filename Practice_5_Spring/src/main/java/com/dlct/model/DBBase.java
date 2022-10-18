package com.dlct.model;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class DBBase {

    @Resource
    DBConnection connection;

    public ResultSet selectAll(String sql) throws  ClassNotFoundException, SQLException {
        Connection con = connection.getCon();
        Statement stat = con.createStatement();
        ResultSet res = stat.executeQuery(sql);
        return res;
    }

    public int updataUser(String sql) throws SQLException, ClassNotFoundException {
        Connection con = connection.getCon();
        Statement stat = con.createStatement();
        return stat.executeUpdate(sql);
    }

}


