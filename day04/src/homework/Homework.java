package homework;

import util.DbUtil;

import java.sql.*;

public class Homework {
    public static void main(String[] args) throws SQLException {
        Connection connection = DbUtil.getConnection();
       // String sql="{call transfer()}";
        String sql1="select fund(@ac);";
        String sql2="set @ac =20230101;";
       // CallableStatement callableStatement= connection.prepareCall(sql);
        CallableStatement callableStatement1=connection.prepareCall(sql1);
        Statement statement = connection.createStatement();
        statement.execute(sql2);
        //   callableStatement.execute();
        callableStatement1.execute();
        callableStatement1.registerOutParameter(1, Types.INTEGER);

    }
}
