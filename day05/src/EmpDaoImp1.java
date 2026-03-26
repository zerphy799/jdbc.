import util.DBObject;
import util.DbUtil;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class EmpDaoImp1 implements EmpDAO{


    @Override
    public int save(Emp emp) {
       String sql = "insert into emp values(?,?,?,?,?,?)";
       return DbUtil.executeUpdatePrepare(sql,emp.getId(),emp.getName(),emp.getGender(),emp.getDepart(),emp.getSal(),emp.getHireDate());
    }

    @Override
    public int delete(String id) {
     String sql = "delete from emp where id=?";
     return DbUtil.executeUpdatePrepare(sql,id);
    }

    @Override
    public int update(Emp emp) {
        String sql ="update emp set name=?,gender=?,depart=?,hiredate=? sal=? where id=?";
        return DbUtil.executeUpdatePrepare(sql,emp.getName(),emp.getGender(),emp.getDepart(),emp.getHireDate(),emp.getSal(),emp.getId());
    }

    @Override
    public Emp selectId(String id) throws SQLException {
        String sql = "select id,name,gender,depart,sal,hiredate from emp where id=?";
        DBObject dbObject = DbUtil.executeQueryPrepared(sql, id);
        ResultSet resultSet = dbObject.getResultSet();
        if (resultSet.next()) {
            Emp emp = new Emp();
            emp.setId(resultSet.getString(1));
            emp.setName(resultSet.getString(2));
            emp.setGender(resultSet.getString(3));
            emp.setDepart(resultSet.getBoolean(4));
            emp.setSal(Float.parseFloat(resultSet.getString(5)));
            emp.setHireDate(resultSet.getDate(6));
            return emp;
        }
        return null;
    }
}
