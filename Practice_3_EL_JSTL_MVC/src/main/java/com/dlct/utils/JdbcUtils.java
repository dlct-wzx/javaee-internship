package com.dlct.utils;

import java.sql.*;

public class JdbcUtils {
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/ssm?useSSL=true&characterEncoding=UTF-8&useUnicode=true&serverTimezone=GMT";
    private static final String userName = "root";
    private static final String passWord = "123456";

    //获取连接
    public static Connection getConnection(){
        Connection connection = null;
        try {
            //注册驱动
            Class.forName(driver);
            //获取连接
            connection = DriverManager.getConnection(url, userName, passWord);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //关闭连接
    public static boolean close(Connection connection,Statement statement,ResultSet resultSet){
        boolean flag = true;
        try {
            if (connection!=null){
                connection.close();
            }
            if (statement!=null){
                statement.close();
            }
            if (resultSet!=null){
                resultSet.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }
}
