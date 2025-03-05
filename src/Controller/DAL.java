package Controller;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DAL {

    public Connection con;
    public Statement st;
    public ResultSet res;
    

    // DBConnection
    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydatabase", "root", "");
            st = con.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error connecting to database: " + e.getMessage(), "Database Connection Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    // Generic method for executing insert, update, and delete queries
    public boolean executeUpdate(String query) {
        try (Statement stmt = con.createStatement()) {
            stmt.executeUpdate(query);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error executing query: " + e.getMessage(), "Query Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        }
    }

    // Select Data and display in JTable
    public void select(String query, JTable table, String[] columnNames) {
        try (Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); ResultSet res = stmt.executeQuery(query)) {

            // Get row count
            res.last();
            int rows = res.getRow();
            res.beforeFirst();  // Reset the cursor

            // Get column count
            int cols = res.getMetaData().getColumnCount();
            String[][] data = new String[rows][cols];
            int r = 0;

            // Populate data array with ResultSet
            while (res.next()) {
                for (int i = 0; i < cols; i++) {
                    data[r][i] = res.getString(i + 1);
                }
                r++;
            }

            // Set data into JTable
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setDataVector(data, columnNames);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error retrieving data: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    // Convert password from char[] to String
    public String convertPassword(char[] pass) {
        return new String(pass);  // Using String constructor for efficient conversion
    }

    public boolean update(String query) {
        try {
            return st.executeUpdate(query) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } 
    }

    public boolean delete(String query) {
        try {
            return st.executeUpdate(query) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            return st.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

     public boolean insert(String query) {
        try {
            return st.executeUpdate(query) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void select(String query, JTable table, String[] columnNames, String searchKeyword) {
    try {
        // Prepare the statement with the query
        PreparedStatement pst = con.prepareStatement(query);
        
        // If searchKeyword is provided, set it as a parameter for the query
        if (searchKeyword != null) {
            for (int i = 1; i <= 4; i++) {
                pst.setString(i, "%" + searchKeyword + "%");  // Set the LIKE search for each field
            }
        }
        
        // Execute the query
        ResultSet rs = pst.executeQuery();

        // Create a table model to hold the result set data
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);

        // Populate the model with data from the ResultSet
        while (rs.next()) {
            Object[] row = new Object[columnNames.length];
            for (int i = 0; i < columnNames.length; i++) {
                row[i] = rs.getObject(i + 1); // Get values from the ResultSet
            }
            model.addRow(row);  // Add the row to the model
        }

        // Set the model for the JTable
        table.setModel(model);
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    
    
}
