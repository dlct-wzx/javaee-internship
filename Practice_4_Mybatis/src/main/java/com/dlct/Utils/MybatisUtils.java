package com.dlct.Utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//sqlSession工具类
public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;
    static {    //静态语句块，在加载时就会运行
        try{
            String resources = "Mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resources);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    //用于获取sqlsession
    public  static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }

}
