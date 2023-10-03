package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	
    public static Connection getConnection() {
        Connection conn = null;
        try {
            String dbURL = "jdbc:mysql://localhost:3306/bbs";
            String dbID = "root";
            String dbPassword = "mysql1234";
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
