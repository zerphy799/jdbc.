package homework;

import com.util.DbUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Homework {
    public static void main(String[] args) throws SQLException, FileNotFoundException {
        String sql="update team set logo =? where name='湖人队'";
        Connection poolConnection = DbUtil.getPoolConnection();
        PreparedStatement preparedStatement = poolConnection.prepareStatement(sql);
        preparedStatement.setBlob(1,new FileInputStream("C:\\Users\\ljh\\Pictures\\DSC_1198.JPG"));
        preparedStatement.execute();
        DbUtil.close(preparedStatement,poolConnection);
    }
}
