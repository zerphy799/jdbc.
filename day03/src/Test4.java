import com.util.DbUtil;

import java.sql.Connection;

public class Test4 {
    public static void main(String[] args) {
        Connection connection = DbUtil.getPoolConnection();
        System.out.println(connection);
    }
}
