package HomeWork;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        UserDAO userDAO =new User();
       // userDAO.register("123456","154525");
        userDAO.login("123456","154525");
    }
}
