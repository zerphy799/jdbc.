import com.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test2 {
    public static void main(String[] args) throws SQLException {
        Connection connection= DbUtil.getConnection();
        String sql="insert into team values(default,?)";
        connection.setAutoCommit(false);
        PreparedStatement statement=connection.prepareStatement(sql);
        for (int i = 1; i <=10000; i++) {
            statement.setString(1,"球队"+i);
            statement.addBatch();
           if(i%1000==0){
               statement.executeBatch();
               statement.clearBatch();
           }
        }
        connection.commit();
        DbUtil.close(statement,connection);
        System.out.println("执行完成");
    }
}
