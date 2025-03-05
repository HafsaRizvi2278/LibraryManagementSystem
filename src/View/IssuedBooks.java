package View;

import Controller.*;
import java.sql.*;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;

public class IssuedBooks extends javax.swing.JFrame {

    public static String sid;
    public static String bid;
    public static int lid;

    public IssuedBooks() {
        initComponents();

    }

    DAL d = new DAL();

    public void comStudent() {
        try {
            d.connect();
            ResultSet res = d.executeQuery("SELECT name FROM members");
            while (res.next()) {
                comboStudent.addItem(res.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void comBook() {
        try {
            d.connect();
            ResultSet res = d.executeQuery("SELECT title FROM books");
            while (res.next()) {
                comboBooks.addItem(res.getString("title"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Load issued books into table
    private void loadIssuedBooksIntoTable() {
        d.connect();
        String query = "SELECT issuedbooks.issueid, members.name, books.title, issuedbooks.quantity, issuedbooks.getdate, issuedbooks.returndate "
                + "FROM issuedbooks "
                + "INNER JOIN members ON members.memberId = issuedbooks.memberId "
                + "INNER JOIN books ON books.bookID = issuedbooks.bookID";
        String columnNames[] = {"ID", "Name", "Book", "Quantity", "Get Date", "Return Date"};
        d.select(query, tblIssuedBooks, columnNames);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnADD = new javax.swing.JButton();
        btnEDIT = new javax.swing.JButton();
        btnDELETE = new javax.swing.JButton();
        txtQuantity = new javax.swing.JTextField();
        lblReturnDate = new javax.swing.JLabel();
        lblStudent1 = new javax.swing.JLabel();
        lblBook = new javax.swing.JLabel();
        lblQuantity = new javax.swing.JLabel();
        lblGetDate = new javax.swing.JLabel();
        returndate = new com.toedter.calendar.JDateChooser();
        getdate = new com.toedter.calendar.JDateChooser();
        comboStudent = new javax.swing.JComboBox<>();
        comboBooks = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblIssuedBooks = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(225, 86, 7));
        jPanel1.setPreferredSize(new java.awt.Dimension(1090, 550));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(10, 10, 45));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 3, 60));

        jLabel2.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Books Management ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 260, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons8-return-64.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons8-user-50.png"))); // NOI18N
        jLabel1.setText("Welcome  Admin");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 0, 210, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        jPanel2.setBackground(new java.awt.Color(10, 10, 45));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnADD.setBackground(new java.awt.Color(54, 235, 54));
        btnADD.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnADD.setForeground(new java.awt.Color(255, 255, 255));
        btnADD.setText("ADD");
        btnADD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnADDActionPerformed(evt);
            }
        });
        jPanel2.add(btnADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 80, 30));

        btnEDIT.setBackground(new java.awt.Color(255, 153, 51));
        btnEDIT.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnEDIT.setForeground(new java.awt.Color(255, 255, 255));
        btnEDIT.setText("UPDATE");
        btnEDIT.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEDIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEDITActionPerformed(evt);
            }
        });
        jPanel2.add(btnEDIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 80, 30));

        btnDELETE.setBackground(new java.awt.Color(255, 0, 51));
        btnDELETE.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnDELETE.setForeground(new java.awt.Color(255, 255, 255));
        btnDELETE.setText("DELETE");
        btnDELETE.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDELETEActionPerformed(evt);
            }
        });
        jPanel2.add(btnDELETE, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, 80, 30));

        txtQuantity.setBackground(new java.awt.Color(10, 10, 45));
        txtQuantity.setForeground(new java.awt.Color(204, 204, 255));
        txtQuantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 255)));
        jPanel2.add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 200, 30));

        lblReturnDate.setBackground(new java.awt.Color(0, 0, 0));
        lblReturnDate.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblReturnDate.setForeground(new java.awt.Color(204, 204, 255));
        lblReturnDate.setText("Return Date :");
        jPanel2.add(lblReturnDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        lblStudent1.setBackground(new java.awt.Color(0, 0, 0));
        lblStudent1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblStudent1.setForeground(new java.awt.Color(204, 204, 255));
        lblStudent1.setText("Student :");
        jPanel2.add(lblStudent1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        lblBook.setBackground(new java.awt.Color(0, 0, 0));
        lblBook.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblBook.setForeground(new java.awt.Color(204, 204, 255));
        lblBook.setText("Book :");
        jPanel2.add(lblBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        lblQuantity.setBackground(new java.awt.Color(0, 0, 0));
        lblQuantity.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblQuantity.setForeground(new java.awt.Color(204, 204, 255));
        lblQuantity.setText("Quantity :");
        jPanel2.add(lblQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        lblGetDate.setBackground(new java.awt.Color(0, 0, 0));
        lblGetDate.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblGetDate.setForeground(new java.awt.Color(204, 204, 255));
        lblGetDate.setText("Get Date :");
        jPanel2.add(lblGetDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));
        jPanel2.add(returndate, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 310, 170, 30));
        jPanel2.add(getdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 262, 180, 30));

        comboStudent.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboStudentItemStateChanged(evt);
            }
        });
        jPanel2.add(comboStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 102, 200, 30));

        comboBooks.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBooksItemStateChanged(evt);
            }
        });
        jPanel2.add(comboBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 200, 30));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons8-course-assign-48.png"))); // NOI18N
        jLabel5.setText("Issued Books");
        jLabel5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 200, 60));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 490));

        tblIssuedBooks.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tblIssuedBooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Student", "Book", "Quantity", "Get Date", "Return Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblIssuedBooks.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblIssuedBooks.setGridColor(new java.awt.Color(242, 242, 242));
        tblIssuedBooks.setRowHeight(30);
        tblIssuedBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblIssuedBooksMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblIssuedBooks);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 720, 350));

        txtSearch.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtSearch.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(10, 10, 45)));
        getContentPane().add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 100, 180, 30));

        btnSearch.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(225, 86, 7)));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 100, 100, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        comStudent();
        comBook();

        d.connect();
        String query = "SELECT issuedbooks.issueid, members.name, books.title, issuedbooks.quantity, issuedbooks.getdate, issuedbooks.returndate "
                + "FROM issuedbooks "
                + "INNER JOIN members ON members.memberId = issuedbooks.memberId "
                + "INNER JOIN books ON books.bookID = issuedbooks.bookID";
        String columnName[] = {"id", "name", "book", "quantity", "get date", "return date"};
        d.select(query, tblIssuedBooks, columnName);
    }//GEN-LAST:event_formWindowOpened

    private void comboStudentItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboStudentItemStateChanged

        try {
            d.connect();
            String query = "SELECT memberId FROM members WHERE name = ?";
            PreparedStatement pst = d.con.prepareStatement(query);
            pst.setString(1, comboStudent.getSelectedItem().toString());
            d.res = pst.executeQuery();
            if (d.res.next()) {
                sid = d.res.getString("memberId"); // Get memberId as a String
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }

    }//GEN-LAST:event_comboStudentItemStateChanged

    private void comboBooksItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBooksItemStateChanged

        try {
            d.connect();
            String query = "SELECT bookID FROM books WHERE title = ?";
            PreparedStatement pst = d.con.prepareStatement(query);
            pst.setString(1, comboBooks.getSelectedItem().toString());
            d.res = pst.executeQuery();
            if (d.res.next()) {
                bid = d.res.getString("bookID"); // Get bookID as a String
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }

    }//GEN-LAST:event_comboBooksItemStateChanged

    private void btnADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnADDActionPerformed

        if (comboStudent.getSelectedIndex() == -1 || comboBooks.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Please select a student and a book.");
            return;
        }

        if (txtQuantity.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Quantity cannot be empty.");
            return;
        }

        try {
            int quantity = Integer.parseInt(txtQuantity.getText().trim());
            if (quantity <= 0) {
                JOptionPane.showMessageDialog(this, "Quantity must be greater than 0.");
                return;
            }

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String getDate = dateFormat.format(getdate.getDate());
            String returnDate = dateFormat.format(returndate.getDate());

            String insertQuery = "INSERT INTO issuedbooks (memberId, bookID, quantity, getdate, returndate) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement pst = d.con.prepareStatement(insertQuery)) {
                pst.setString(1, sid);
                pst.setString(2, bid);
                pst.setInt(3, quantity);
                pst.setDate(4, java.sql.Date.valueOf(getDate));
                pst.setDate(5, java.sql.Date.valueOf(returnDate));

                int result = pst.executeUpdate();
                if (result > 0) {
                    JOptionPane.showMessageDialog(this, "Book issued successfully!");
                    loadIssuedBooksIntoTable();
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to issue book.");
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Quantity must be a numeric value.");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }


    }//GEN-LAST:event_btnADDActionPerformed

    private void btnEDITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEDITActionPerformed
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String getDate = date.format(getdate.getDate());
        String returnDate = date.format(returndate.getDate());

        d.connect();

        // Query to update the IssuedBooks table
        String updateQuery = "UPDATE issuedbooks SET "
                + "memberId = ?, "
                + "bookID = ?, "
                + "quantity = ?, "
                + "getdate = ?, "
                + "returndate = ? "
                + "WHERE issueid = ?";

        try (PreparedStatement pst = d.con.prepareStatement(updateQuery)) {
            pst.setString(1, sid);  // Use the memberId retrieved from combo box selection
            pst.setString(2, bid);   // Use the bookID retrieved from combo box selection
            pst.setInt(3, Integer.parseInt(txtQuantity.getText()));  // Convert quantity to integer
            pst.setDate(4, new java.sql.Date(getdate.getDate().getTime()));
            pst.setDate(5, new java.sql.Date(returndate.getDate().getTime()));
            pst.setInt(6, lid);  // Using the issueid to identify the record

            int result = pst.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Record updated successfully");
                loadIssuedBooksIntoTable();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update record");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnEDITActionPerformed

    private void btnDELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDELETEActionPerformed
        d.connect();

        // Query to delete the record
        String deleteQuery = "DELETE FROM issuedbooks WHERE issueid = ?";

        try (PreparedStatement pst = d.con.prepareStatement(deleteQuery)) {
            pst.setInt(1, lid);  // Using the issueid to identify the record
            int result = pst.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Record deleted successfully");
                loadIssuedBooksIntoTable();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete record");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnDELETEActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        new MenuAdmin().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void tblIssuedBooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblIssuedBooksMouseClicked
        lid = Integer.parseInt(tblIssuedBooks.getValueAt(tblIssuedBooks.getSelectedRow(), 0).toString());
        comboStudent.setSelectedItem(tblIssuedBooks.getValueAt(tblIssuedBooks.getSelectedRow(), 1).toString());
        comboBooks.setSelectedItem(tblIssuedBooks.getValueAt(tblIssuedBooks.getSelectedRow(), 2).toString());
        txtQuantity.setText(tblIssuedBooks.getValueAt(tblIssuedBooks.getSelectedRow(), 3).toString());

        try {
            String getDateStr = tblIssuedBooks.getValueAt(tblIssuedBooks.getSelectedRow(), 4).toString();
            String returnDateStr = tblIssuedBooks.getValueAt(tblIssuedBooks.getSelectedRow(), 5).toString();
            getdate.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(getDateStr));
            returndate.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(returnDateStr));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_tblIssuedBooksMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
         
    String searchKeyword = txtSearch.getText().trim();  // Get the search keyword
    String query = "";

    if (searchKeyword.isEmpty()) {
        // If no keyword is entered, fetch all records
        query = """
        SELECT issuedbooks.issueid, members.name, books.title, issuedbooks.quantity, issuedbooks.getdate, issuedbooks.returndate
        FROM issuedbooks
        INNER JOIN members ON members.memberId = issuedbooks.memberId
        INNER JOIN books ON books.bookID = issuedbooks.bookID
        """;
    } else {
        // If there's a keyword, search in relevant columns (Name, Book Title, Date)
        query = """
        SELECT issuedbooks.issueid, members.name, books.title, issuedbooks.quantity, issuedbooks.getdate, issuedbooks.returndate
        FROM issuedbooks
        INNER JOIN members ON members.memberId = issuedbooks.memberId
        INNER JOIN books ON books.bookID = issuedbooks.bookID
        WHERE members.name LIKE ? 
        OR books.title LIKE ? 
        OR issuedbooks.getdate LIKE ? 
        OR issuedbooks.returndate LIKE ?
        """;
    }

    // Define column names
      String columnNames[] = {"ID", "Name", "Book", "Quantity", "Get Date", "Return Date" };

    // Execute the query and update the JTable
      d.select(query, tblIssuedBooks, columnNames, "%" + searchKeyword + "%");
                              
  
    }//GEN-LAST:event_btnSearchActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IssuedBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssuedBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssuedBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssuedBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssuedBooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnADD;
    private javax.swing.JButton btnDELETE;
    private javax.swing.JButton btnEDIT;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> comboBooks;
    private javax.swing.JComboBox<String> comboStudent;
    private com.toedter.calendar.JDateChooser getdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBook;
    private javax.swing.JLabel lblGetDate;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblReturnDate;
    private javax.swing.JLabel lblStudent1;
    private com.toedter.calendar.JDateChooser returndate;
    private javax.swing.JTable tblIssuedBooks;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
