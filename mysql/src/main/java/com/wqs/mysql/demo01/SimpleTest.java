package com.wqs.mysql.demo01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 直接使用mysql连接数据库
 */
public class SimpleTest {
    public static void main(String[] args) throws Exception {

        //1、加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2、获取连接
        Connection connection = DriverManager.getConnection
                ("jdbc:mysql://127.0.0.1:3306/test?serverTimezone=Asia/Shanghai", "root", "123456");
        //3、获取statement
        Statement statement = connection.createStatement();
        //4、执行语句
        String sql = "select * from account";
        ResultSet resultSet = statement.executeQuery(sql);
        //5、将结果取出并存为对象
        while (resultSet.next()) {
            //6、将结果中的特定名称字段转化为对应类型，然后设置为Account实例的变量值
            Account account = new Account();
            account.setId(resultSet.getInt("id"));
            account.setUsername(resultSet.getString("username"));
            account.setPassword(resultSet.getString("password"));
            account.setCreateTime(resultSet.getDate("createTime"));
            System.out.println(account);
        }
        //7、必须资源关闭
        resultSet.close();
        statement.close();
        connection.close();
    }
}
