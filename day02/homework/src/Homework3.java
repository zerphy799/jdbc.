import java.sql.SQLException;

public class Homework3 {
    public static void main(String[] args) {
        String sql = "select * from emp where depart='false';";
        DBObject dbObject = DbUtil.executeQuery(sql);
        while (true) {
            try {
                if (dbObject.getResultSet().next()) {
                    System.out.println(dbObject.getResultSet().getString("name") + "\t"
                            + dbObject.getResultSet().getString("depart") + "\t"
                            + dbObject.getResultSet().getString("sal") + "\t"
                            + dbObject.getResultSet().getString("gender") + "\t"
                            + dbObject.getResultSet().getString("hiredate"));
                } else break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        DbUtil.close(dbObject);
    }
}
