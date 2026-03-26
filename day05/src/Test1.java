import java.sql.Date;
import java.util.UUID;

public class Test1 {
    public static void main(String[] args) {
        testInsert();
    }
    public static void testInsert(){
        Emp emp=new Emp();
        emp.setId(UUID.randomUUID().toString().replace("-",""));
        emp.setName("陆游");
        emp.setGender("男");
        emp.setDepart(true);
        emp.setSal(3465.5f);
        emp.setHireDate(Date.valueOf("2021-01-03"));
        EmpDAO empDAO=new EmpDaoImp1();
        empDAO.save(emp);
    }
}
