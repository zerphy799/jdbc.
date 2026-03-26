import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

public class Test {
    public static void main(String[] args) {

    }
    public static Connection getConnection1() throws SQLException {
        Driver driver = new com.mysql.cj.jdbc.Driver();
        Properties info =new Properties();
        info.setProperty("user","root");
        info.setProperty("password","147258369jk");
        String url = "jdbc:mysql://localhost:3306/dbtest1";
        Connection connect = driver.connect(url, info);
      return  connect;
    }
    public static Connection getConnection2() throws Exception {
        Class<?> aclass =Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) aclass.newInstance();
        Properties info =new Properties();
        info.setProperty("user","root");
        info.setProperty("password","147258369jk");
        String url = "jdbc:mysql://localhost:3306/dbtest1";
        return driver.connect(url, info);
       }
}
