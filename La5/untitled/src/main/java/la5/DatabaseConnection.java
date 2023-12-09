package la5;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://WIN-PKOUDIAUN56:3306/Bbbank";
        String username = "hikapo";
        String password = "22324";

        return DriverManager.getConnection(url, username, password);
    }
}
