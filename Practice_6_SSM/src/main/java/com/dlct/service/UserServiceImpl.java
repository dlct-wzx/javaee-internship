package com.dlct.service;

import com.dlct.Mapper.UserMapper;

public class UserServiceImpl implements UserService{
    private UserMapper userMapper;
    @Override
    public String selectUserByName(String name) {
        return userMapper.selectUserByName(name);
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
