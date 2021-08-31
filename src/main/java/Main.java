import entity.User;
import work_jdbc_service.CrudDAOImpl;
import work_jdbc_service.HelperGetFields;

import java.sql.SQLException;
import java.util.Date;

/*
Create schema for users events that users are doing in system (its any application) -
for example he opened project he created record in table and etc.
*/
public class Main {
    static CrudDAOImpl<User> c = new CrudDAOImpl<>();
    static HelperGetFields h = new HelperGetFields();

    public static void main(String[] args) {
        try {
            exampleUpdateOperation();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    static void exampleInsertOperation() {
        User user = new User("Tramp", 12, new java.sql.Date(new Date().getTime()), new java.sql.Date(12), new java.sql.Date(5), "1231d", "vsds");

        c.insert("INSERT INTO users VALUES (?,?,?,?,?,?,?)",user);
    }

    static void exampleSelectOperation() throws SQLException {
        System.out.println(c.select(User.class, "select * from users where id = 12"));
    }

    static void exampleUpdateOperation() throws SQLException {
        c.update("UPDATE users SET login=? where id=3",new String[]{"newNina"});

    }
}
