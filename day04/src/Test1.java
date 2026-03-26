import util.DbUtil;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test1 {
    public static void main(String[] args) throws SQLException {
        Connection connection= DbUtil.getConnection();
        String sql ="{call noparam()}";
        CallableStatement callableStatement =connection.prepareCall(sql);
        callableStatement.execute();
        ResultSet resultSet=callableStatement.getResultSet();
        while(resultSet.next()){
            System.out.println(resultSet.getString(1));
            System.out.println(resultSet.getString(2));
        }
        DbUtil.close(callableStatement,connection);
    }
}
