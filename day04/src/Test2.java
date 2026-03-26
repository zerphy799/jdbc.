import util.DbUtil;

import java.sql.*;

public class Test2 {
    public static void main(String[] args) throws SQLException {
        Connection conn = DbUtil.getConnection();
        String sql ="{call selectstaff(?)}";
        CallableStatement callableStatement= conn.prepareCall(sql);
        callableStatement.setString(1, "1");
        callableStatement.execute();
        ResultSet resultSet=callableStatement.getResultSet();
        ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
        int count=resultSetMetaData.getColumnCount();
        while(resultSet.next()){
            for (int i = 1; i <= count; i++) {
                System.out.print(resultSet.getString(i)+"\t");
            }
        }
        while(callableStatement.getMoreResults()){
            System.out.println("\n--------------------");
            resultSet=callableStatement.getResultSet();
            resultSetMetaData=resultSet.getMetaData();
            int count1=resultSetMetaData.getColumnCount();
            while(resultSet.next()){
                for (int i = 1; i <= count1; i++) {
                    System.out.print(resultSet.getString(i)+"\t");
                }
            }
        }
        DbUtil.close(callableStatement,conn);
    }
}
