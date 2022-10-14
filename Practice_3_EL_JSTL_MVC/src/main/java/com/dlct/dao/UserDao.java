package com.dlct.dao;

import com.dlct.pojo.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    List<User> queryAllUser() throws SQLException;
    User queryUserByName(String name) throws SQLException;
}
