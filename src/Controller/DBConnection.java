
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DBConnection {


    // Database connection parameters
    private static final String URL = "jdbc:mysql://localhost:3306/librarydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    
    public static Connection getConnection() {
        Connection conn = null;
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connection established successfully!");
        } catch (ClassNotFoundException e) {
            
            JOptionPane.showMessageDialog(null, "JDBC Driver not found: " + e.getMessage(),
                                          "Driver Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Database connection failed: " + e.getMessage(),
                                          "Database Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Unexpected error: " + e.getMessage(),
                                          "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return conn;
    }


}


