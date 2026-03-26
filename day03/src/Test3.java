import com.alibaba.druid.pool.DruidDataSource;
import com.sun.tools.javac.Main;

import java.sql.Connection;
import java.sql.SQLException;

public class Test3 {
    public static void main(String[] args) throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/dbtest1");
        dataSource.setUsername("root");
        dataSource.setPassword("147258369jk");
        dataSource.setInitialSize(5);//自动连接数量
        dataSource.setMinIdle(5);
        dataSource.setMaxActive(20);
        dataSource.setMaxWait(60000);
        dataSource.setTimeBetweenEvictionRunsMillis(60000);//每60秒检测一次空闲连接
        dataSource.setMinEvictableIdleTimeMillis(300000);//空闲连接超过30秒自动回收
        Connection connection1 = dataSource.getConnection();
        System.out.println(connection1);
    }
}
