package com.wqs.mysql.demo01;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * 直接使用mysql连接数据库
 * 定义一个文件，将文件转换为Properties对象来完成参数的设置
 */
public class SimpleTest2 {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    private static void getConfiguration(String fileName) throws Exception{
        //读取外部文件
        InputStream resourceAsStream = SimpleTest2.class.getClassLoader().getResourceAsStream(fileName);
        Properties properties = new Properties();
        properties.load(resourceAsStream);
        //获取配置参数
        driver = properties.getProperty("mysql.driver-class-name");
        url = properties.getProperty("mysql.url");
        username = properties.getProperty("mysql.username");
        password = properties.getProperty("mysql.password");
    }

    public static void main(String[] args) throws Exception {
        //加载mysql配置
        getConfiguration("mysql.properties");

        //1、加载驱动
        Class.forName(driver);
        //2、获取连接
        Connection connection = DriverManager.getConnection(url, username, password);
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
