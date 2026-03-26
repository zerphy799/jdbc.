package HomeWork;

import util.DBObject;
import util.DbUtil;

import java.sql.*;

public class Emp implements EmpDAO {
    boolean g;
    boolean d;
    boolean n;
    boolean s;
    boolean da;
    private String gender;
    private String name;
    private Boolean depart;
    private float sal;
    private Date date;

    @Override
    public void select() throws SQLException {
        String sql = "desc emp;";
       Connection connection = DbUtil.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            String filed = resultSet.getString("Field");
            switch (filed) {
                case "name" -> n = resultSet.getString("Null").equals("Yes");
                case "gender" -> g = resultSet.getString("Null").equals("Yes");
                case "depart" -> d = resultSet.getString("Null").equals("Yes");
                case "sal" -> s = resultSet.getString("Null").equals("Yes");
                case "date" -> da = resultSet.getString("Null").equals("Yes");
            }
        }
        if (n) {
            String sql2 = "select * from emp where name='" + name + "'";
            sout(sql2);
        } else if (g) {
            String sql2 = "select * from emp where gender='" + gender + "'";
            sout(sql2);
        } else if (d) {
            String sql2 = "select * from emp where depart='" + depart + "'";
            sout(sql2);
        } else if (s) {
            String sql2 = "select * from emp order by sal asc";
            sout(sql2);
        } else if (da) {
            String sql2 = "select * from emp order by hiredate desc";
            sout(sql2);
        } else {
            String sql2 = "select * from emp where name='" + name + "'" + "and gender='" + gender + "'" + "and sal='" + sal + "'" + "and hiredate ='" + date + "'" + "and depart ='" + depart + "'";
            sout(sql2);
        }
    }

    private void sout(String sql2) throws SQLException {
        Connection connection3 = DbUtil.getConnection();
        Statement statement2 = connection3.createStatement();
        ResultSet resultSet2 = statement2.executeQuery(sql2);
        while (resultSet2.next()) {
            System.out.println(resultSet2.getString(1) + '\t');
            System.out.println(resultSet2.getString(2) + '\t');
            System.out.println(resultSet2.getString(3) + '\t');
            System.out.println(resultSet2.getString(4) + '\t');
            System.out.println(resultSet2.getString(5) + '\t');
            System.out.println(resultSet2.getString(6) + '\t');
        }
        DbUtil.close(resultSet2);
        DbUtil.close(statement2, connection3);
    }

    public Emp(Boolean depart, Date date, String gender, String name, float sal) {
        this.depart = depart;
        this.date = date;
        this.gender = gender;
        this.name = name;
        this.sal = sal;
    }
}
