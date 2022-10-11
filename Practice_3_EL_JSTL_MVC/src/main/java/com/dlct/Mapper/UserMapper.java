package com.dlct.Mapper;

import com.dlct.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> queryAllUser();
    User queryUserByName(String name);
}
