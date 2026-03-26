package HomeWork;

import util.DbUtil;

import java.sql.*;
import java.time.LocalDateTime;

public class User implements UserDAO {
    private String username;
    private String password;

    public User() {
    }

    @Override
    public void register(String username, String password) throws SQLException {
         String sql1 = "insert into user(id,name, password) values(1,?,?)";
         String sql2 = "select * from user where name=?";
        Connection connection = DbUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql2);
        preparedStatement.setString(1, username);
        preparedStatement.execute();
        ResultSet resultSet = preparedStatement.getResultSet();
        if (resultSet.next()) {
            System.out.println("账号已存在");
            DbUtil.close(resultSet);
            DbUtil.close(preparedStatement);
        }else {
            PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
            preparedStatement1.setString(1, username);
            preparedStatement1.setString(2, password);
            preparedStatement1.execute();
            System.out.println("注册成功");
           DbUtil.close(preparedStatement1);
        }
        DbUtil.close(connection);
    }

    @Override
    public void login(String username, String password) throws SQLException {
        String sql1 = "select * from user where name=? and password=?";
        Connection connection = DbUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql1);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            System.out.println("登录成功");
            String sql2 ="update user set lasttime =? where name=? and password=?";
            PreparedStatement preparedStatement1 = connection.prepareStatement(sql2);
            preparedStatement1.setString(1, String.valueOf(LocalDateTime.now()));
            preparedStatement1.setString(2, username);
            preparedStatement1.setString(3, password);
            preparedStatement1.execute();
            DbUtil.close(preparedStatement1);
        }else {
            System.out.println("登录失败");
        }
        DbUtil.close(preparedStatement,connection,resultSet);
    }
}
