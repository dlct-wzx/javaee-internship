package com.dlct.Mapper;

import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select pwd from ssm.user where name=#{name}")
    public String selectUserByName(String name);

}
