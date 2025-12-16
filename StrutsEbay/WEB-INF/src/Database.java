import java.sql.*;

public class Database {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ebay_db", 
                "root", 
                "root"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}