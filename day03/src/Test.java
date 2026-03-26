import com.util.DBObject;
import com.util.DbUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException, FileNotFoundException {
     String sql="insert into peacture values(default,?,?)";
        Connection connection= DbUtil.getConnection();
        if (connection != null) {
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,"图片1");
            pstmt.setBlob(2,new FileInputStream("C:\\Users\\ljh\\Desktop\\DSC_1052.JPG"));
            pstmt.executeUpdate();
            System.out.println("执行完成");
            DbUtil.close(pstmt,connection);
        }
    }
}
