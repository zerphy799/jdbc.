package HomeWork;

import java.sql.SQLException;

public interface UserDAO {
    void register(String username, String password) throws SQLException;
    void login(String username, String password) throws SQLException;
}
