package HomeWork;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestEmp {
    public static void main(String[] args) throws ParseException, SQLException {
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
        Emp emp =new Emp(true,new Date(sim.parse("2021-04-12").getTime()),"女","李清照",8923.45f );
        emp.select();
    }
}
