import util.DbUtil;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class Test3 {
    public static void main(String[] args) throws SQLException {
        String sql = "{?= call getName(?)}";
        Connection connection= DbUtil.getConnection();
        CallableStatement callableStatement =connection.prepareCall(sql);
        callableStatement.registerOutParameter(1, Types.VARCHAR);
        callableStatement.setString(2,"1");
        callableStatement.execute();
        String name=callableStatement.getString(1);
        System.out.println(name);
    }
}
