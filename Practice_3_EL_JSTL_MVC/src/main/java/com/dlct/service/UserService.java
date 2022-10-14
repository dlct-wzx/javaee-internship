package com.dlct.service;

import com.dlct.dao.UserDao;
import com.dlct.pojo.User;
import com.dlct.utils.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService implements UserDao{

    @Override
    public List<User> queryAllUser() throws SQLException {
        //查询所有用户
        Connection connection = JdbcUtils.getConnection();
        Statement stat = connection.createStatement();
        String sql = "select * from ssm.user";
        ResultSet res = stat.executeQuery(sql);

        ArrayList<User> users = new ArrayList<>();
        User user = new User();
        while(res.next()){
            user.setName(res.getString("name"));
            user.setPwd(res.getString("pwd"));
            users.add(user);
        }

        JdbcUtils.close(connection, stat, res);
        return users;
    }

    @Override
    public User queryUserByName(String name) throws SQLException {
        //查询所有用户
        Connection connection = JdbcUtils.getConnection();
        Statement stat = connection.createStatement();
        String sql = "select * from javaee_practice.user where name=" + name;
        ResultSet res = stat.executeQuery(sql);

        User user = new User();
        while(res.next()){
            user.setName(res.getString("name"));
            user.setPwd(res.getString("pwd"));
        }

        JdbcUtils.close(connection, stat, res);
        return user;
    }
}
