package servlets;
import java.sql.*;

public class DatabaseConnect {

    private static Connection connection;

    private DatabaseConnect() {}

    public static Connection getInstance() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "mkirchge", "mk132Qwe");
//                connection = DriverManager.getConnection("jdbc:mysql://sylvester-mccoy-v3.ics.uci.edu/inf124-db-058", "inf124-db-058", "mk132Qwe");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return connection;
    }

}
