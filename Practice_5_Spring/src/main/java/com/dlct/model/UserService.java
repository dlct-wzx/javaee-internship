package com.dlct.model;

import com.dlct.pojo.User;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Repository;


import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Resource
    private DBBase dbBase;
    static String SELECTSQL = "select * from user_p5";

    public List<User> list() throws SQLException, ClassNotFoundException {
        ResultSet rs = dbBase.selectAll(SELECTSQL);
        List<User> users = new ArrayList<User>();
        while (rs.next()){
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUser_name(rs.getString("user_name"));
            user.setPasswd(rs.getString("passwd"));
            users.add(user);
        }
        return users;
    }

    public int updataUser(User user) throws SQLException, ClassNotFoundException {
        String sql="update javaee_practice.user_p5 " +
                "set user_name= '" + user.getUser_name() + "', " +
                "passwd='" + user.getPasswd() + "' where id ="+ user.getId();
        return dbBase.updataUser(sql);
    }

    public int insertUser(User user) throws SQLException, ClassNotFoundException {
        String sql = "insert into javaee_practice.user_p5(user_name, passwd)" +
                "VALUES ( '" + user.getUser_name() + "' , '" + user.getPasswd() + "')";
        return dbBase.updataUser(sql);
    }

    public int deleteUser(int id) throws SQLException, ClassNotFoundException {
        String sql = "delete from javaee_practice.user_p5 where id=" + id;
        return dbBase.updataUser(sql);
    }

}
