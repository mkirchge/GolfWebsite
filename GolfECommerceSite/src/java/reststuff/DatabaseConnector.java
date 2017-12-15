package reststuff;
import java.sql.*;

import static com.uci.rest.db.DatabaseConfig.*;

public class DatabaseConnector {

    private DatabaseConnector() {}

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/mydb", "mkirchge", "mk132Qwe");
//            return DriverManager.getConnection("jdbc:mysql://sylvester-mccoy-v3.ics.uci.edu/inf124-db-058", "maxkirchgesner", "password");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
