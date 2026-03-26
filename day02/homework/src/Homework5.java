import java.sql.Date;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

public class Homework5 {
    public static void main(String[] args) throws SQLException {
        String sql = "select * from emp where depart='false';";
        DBObject dbObject = DbUtil.executeQuery(sql);
        while(dbObject.getResultSet().next()){
            Date hiredate = dbObject.getResultSet().getDate("hiredate");
            LocalDate date=LocalDate.now();
            LocalDate localDate = hiredate.toLocalDate();
            long between = ChronoUnit.DAYS.between(localDate,date);
            if(between/365>3){
                String sql1="update emp set sal=sal+300;";
                DbUtil.executeUpdate(sql1);
            }
        }
    }
}
