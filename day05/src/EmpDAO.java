import java.sql.SQLException;

public interface EmpDAO {
    int save(Emp emp);
    int delete(String id);
    int update(Emp emp);
    Emp selectId(String id) throws SQLException;

}
