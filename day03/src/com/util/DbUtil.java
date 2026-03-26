package com.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.zaxxer.hikari.HikariDataSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ResourceBundle;

public class DbUtil {
    private static final String Driver;
    private static final String URL;
    private static final String Username;
    private static final String Password;
    private static final String poolClass;
    static {
        ResourceBundle rb = ResourceBundle.getBundle("com.util.dbutil");
        Driver = rb.getString("Driver");
        URL = rb.getString("Url");
        Username = rb.getString("Username");
        Password = rb.getString("Password");
        poolClass = rb.getString("pool.class");
    }
    public static Connection getConnection()  {
        try {
            return DriverManager.getConnection(URL, Username, Password);
        } catch (SQLException e ){
            System.out.println("数据库连接失败");
        }
        return null;
    }

    public static Statement getStatement(Connection connection)  {
        try {
            return connection.createStatement();
        } catch (SQLException e) {
          e.printStackTrace();
        }
        return null;
    }
    public static void close( Statement statement) {
       if (statement != null) {
           try {
                statement.close();
            } catch (SQLException e) {}
       }

    }
    public static void close( Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {}
        }

    }
    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {}
        }

    }
    public static void close(Statement statement, Connection connection) {
        close(statement);
        close(connection);
    }
    public static void close(Statement statement, Connection connection,ResultSet resultSet) {
        close(statement);
        close(connection);
        close(resultSet);
    }

    public static int executeUpdate(Statement statement, String sql){
        try {
            return statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //增删改操作
    public static int  executeUpdate( String sql) {
        Connection connection = getConnection();
        Statement statement = getStatement(connection);
        int i=executeUpdate(statement,sql);
        close(statement,connection);
        return i;
    }
    //查询操作
    public static DBObject executeQuery(String sql) {
        Connection connection = getConnection();
        Statement statement = getStatement(connection);
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new DBObject(connection,resultSet,statement);
    }
    public static void close(DBObject dbObject) {
        close(dbObject.getStatement(),dbObject.getConnection(),dbObject.getResultSet());
    }
    public static int executeUpdatePrepare(String sql,Object... args ) {
        Connection connection = getConnection();
        PreparedStatement statement = null;
        try {
            statement=connection.prepareStatement(sql);
            int index=1;
            for (Object arg : args) {
                statement.setObject(index++,arg);
            }
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(statement,connection);
        }
        return -1;
    }



    //针对prepareStatement的查询操作
    public static DBObject executeQueryPrepared(String sql ,Object... args) {
        Connection connection = getConnection();
        PreparedStatement statement = null;
        try {
            statement= connection.prepareStatement(sql);
            int index=1;
            for (Object object:args) {
                statement.setObject(index++,object);
            }
            ResultSet resultSet = statement.executeQuery();
            return new DBObject(connection,resultSet,statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Connection getPoolConnection(){
        Connection connection = null;
        try {
            Class<?> aClass = Class.forName(poolClass);
            Object o=aClass.getConstructor().newInstance();
            Method method = aClass.getMethod("setDriverClassName",String.class);
            method.invoke(o,Driver);
            if(aClass.getName().equals(DruidDataSource.class.getName())) {
                method = aClass.getMethod("setUrl",String.class);
                method.invoke(o,URL);
            }else if(aClass.getName().equals(HikariDataSource.class.getName())) {
                Method method1 = aClass.getMethod("setJdbcUrl",String.class);
                method1.invoke(o,URL);
            }
            Method method1 = aClass.getMethod("setUsername",String.class);
            method1.invoke(o,Username);
            Method method2 = aClass.getMethod("setPassword",String.class);
            method2.invoke(o,Password);
            Method method3 = aClass.getMethod("getConnection");
            return  (Connection) method3.invoke(o);
        } catch (Exception e) {
          e.printStackTrace();
        }
        return null;
    }
}
