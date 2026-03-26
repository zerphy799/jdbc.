package homework;

import com.util.DbUtil;

import java.sql.*;
import java.text.ParseException;
import java.util.List;

public class Homework1 {
    public static void main(String[] args) throws SQLException, ParseException {
        String sql="insert into team (name,locale,founded) values (?,?,?)";
        Connection poolConnection = DbUtil.getPoolConnection();
        poolConnection.setAutoCommit(false);
        PreparedStatement preparedStatement = poolConnection.prepareStatement(sql);
        List<team> getteam = team.getteam();
        for (int i = 0; i < 3; i++) {
            preparedStatement.setString(1,getteam.get(i).getName());
            preparedStatement.setString(2,getteam.get(i).getLocale());
            preparedStatement.setDate(3,getteam.get(i).getFounded());
             preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();
        poolConnection.commit();
        DbUtil.close(preparedStatement,poolConnection);
    }
}
