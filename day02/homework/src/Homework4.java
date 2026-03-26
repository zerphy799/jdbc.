import java.sql.SQLException;

public class Homework4 {
    public static void main(String[] args) throws SQLException {
        String sql = "select * from emp where depart='false';";
        DBObject dbObject = DbUtil.executeQuery(sql);
        float sum = 0.00f;
        while (dbObject.getResultSet().next()){
            sum+=dbObject.getResultSet().getFloat("sal");
        }
        System.out.println(sum);
        DbUtil.close(dbObject);
    }
}
