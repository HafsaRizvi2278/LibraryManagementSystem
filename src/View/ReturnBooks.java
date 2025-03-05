package View;

import Controller.DAL;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class ReturnBooks extends javax.swing.JFrame {

    DAL d = new DAL();
    public static String Member;
    public static String Book;

    // Store the selected return book ID for update and delete operations
    private int selectedReturnBookId = -1;

    public ReturnBooks() {
        initComponents();

    }

    public void comMember() {
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
                comboBook.addItem(res.getString("title"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnADD = new javax.swing.JButton();
        btnEDIT = new javax.swing.JButton();
        btnDELETE = new javax.swing.JButton();
        lblReturnDate = new javax.swing.JLabel();
        lblStudent1 = new javax.swing.JLabel();
        lblBook = new javax.swing.JLabel();
        lblQuantity = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        returnDate = new com.toedter.calendar.JDateChooser();
        comboStudent = new javax.swing.JComboBox<>();
        comboBook = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
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

        jLabel5.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons8-user-50.png"))); // NOI18N
        jLabel5.setText("Welcome  Admin");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 0, 210, 60));

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
        jPanel2.add(btnADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 80, 30));

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
        jPanel2.add(btnEDIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 80, 30));

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
        jPanel2.add(btnDELETE, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 80, 30));

        lblReturnDate.setBackground(new java.awt.Color(0, 0, 0));
        lblReturnDate.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblReturnDate.setForeground(new java.awt.Color(204, 204, 255));
        lblReturnDate.setText("Return Date :");
        jPanel2.add(lblReturnDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

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

        txtQuantity.setBackground(new java.awt.Color(10, 10, 45));
        txtQuantity.setForeground(new java.awt.Color(204, 204, 255));
        txtQuantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 255)));
        jPanel2.add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 210, 30));
        jPanel2.add(returnDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 270, 190, 30));

        comboStudent.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboStudentItemStateChanged(evt);
            }
        });
        jPanel2.add(comboStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 200, 30));

        comboBook.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBookItemStateChanged(evt);
            }
        });
        jPanel2.add(comboBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 190, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons8-records-64.png"))); // NOI18N
        jLabel6.setText("Return Books");
        jLabel6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 220, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 490));

        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Student", "Book", "Quantity", "Return Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setRowHeight(30);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 167, 660, 350));

        txtSearch.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtSearch.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(10, 10, 45)));
        getContentPane().add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 110, 180, 30));

        btnSearch.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(225, 86, 7)));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 110, 100, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        comMember();
        comBook();

        d.connect();

        // SQL query to fetch return records with member and book details
        String query = """
    SELECT 
        return_book.returnid, 
        members.name, 
        books.title, 
        return_book.quantity, 
        return_book.returndate
    FROM 
        return_book
    INNER JOIN 
        members 
    ON 
        members.memberId = return_book.memberId
    INNER JOIN 
        books 
    ON 
        books.bookID = return_book.bookID
    """;

        // Column names for JTable
        String columnNames[] = {"ID", "Student", "Book", "Quantity", "Return Date"};

        // Execute query and populate the table
        d.select(query, jTable1, columnNames);

    }//GEN-LAST:event_formWindowOpened

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        new MenuAdmin().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void btnADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnADDActionPerformed

        try {
    SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
    String rDate = date.format(returnDate.getDate());

    String quantityText = txtQuantity.getText();

    // Validate if the quantity is a valid number
    if (quantityText.isEmpty() || !quantityText.matches("\\d+")) {
        JOptionPane.showMessageDialog(this, "Please enter a valid quantity!");
        return;
    }

    int quantity = Integer.parseInt(quantityText);

    // Debugging: Check book and member IDs
    System.out.println("Book ID: " + Book);
    System.out.println("Member ID: " + Member);

    d.connect();

    // Insert return record
    String insertQuery = """
         INSERT INTO return_book (memberid, bookid, quantity, returndate) 
         VALUES ('%s', '%s', %d, '%s')
    """.formatted(Member, Book, quantity, rDate);

    if (d.insert(insertQuery)) {
        JOptionPane.showMessageDialog(this, "Book Returned!");
        formWindowOpened(null);  // Refresh the table
    } else {
        JOptionPane.showMessageDialog(this, "Failed to record return.");
    }

} catch (Exception e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
}

    }//GEN-LAST:event_btnADDActionPerformed

    private void comboStudentItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboStudentItemStateChanged
        try {
            d.connect();
            String query = "SELECT memberId FROM members WHERE name = '" + comboStudent.getSelectedItem() + "'";
            ResultSet res = d.executeQuery(query);
            if (res.next()) {
                Member = res.getString("memberId");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_comboStudentItemStateChanged

    private void comboBookItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBookItemStateChanged
        try {
            d.connect();
            String query = "SELECT bookID FROM books WHERE title = '" + comboBook.getSelectedItem() + "'";
            ResultSet res = d.executeQuery(query);
            if (res.next()) {
                Book = res.getString("bookID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_comboBookItemStateChanged
    public static int r_id;

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        r_id = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
        comboStudent.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
        comboBook.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
        txtQuantity.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());

    }//GEN-LAST:event_jTable1MouseClicked

    private void btnDELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDELETEActionPerformed
        try {
            d.connect();
            d.delete("DELETE FROM return_book WHERE returnid = " + r_id);
            formWindowOpened(null);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnDELETEActionPerformed

    private void btnEDITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEDITActionPerformed

        try {
            d.connect();
            SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
            String rDate = date.format(returnDate.getDate());

            String quantityText = txtQuantity.getText();

            // Validate if the quantity is a valid number
            if (quantityText.isEmpty() || !quantityText.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "Please enter a valid quantity!");
                return;
            }

            int quantity = Integer.parseInt(quantityText);

            String updateQuery = """
            UPDATE return_book 
            SET memberid = '%s', bookid = '%s', quantity = %d, returndate = '%s' 
            WHERE returnid = %d
        """.formatted(Member, Book, quantity, rDate, r_id);

            d.update(updateQuery);
            formWindowOpened(null);  // Refresh the table
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }

    }//GEN-LAST:event_btnEDITActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

        String searchText = txtSearch.getText().trim();  // Get the text from the search field

        // Check if the search field is empty, if so show all records
        String query = "";
        if (searchText.isEmpty()) {
            // Default query to fetch all records
            query = """
        SELECT 
            return_book.returnid, 
            members.name, 
            books.title, 
            return_book.quantity, 
            return_book.returndate
        FROM 
            return_book
        INNER JOIN 
            members 
        ON 
            members.memberId = return_book.memberId
        INNER JOIN 
            books 
        ON 
            books.bookID = return_book.bookID
        """;
        } else {
            // Query to search for members or books based on the search text
            query = """
        SELECT 
            return_book.returnid, 
            members.name, 
            books.title, 
            return_book.quantity, 
            return_book.returndate
        FROM 
            return_book
        INNER JOIN 
            members 
        ON 
            members.memberId = return_book.memberId
        INNER JOIN 
            books 
        ON 
            books.bookID = return_book.bookID
        WHERE 
            members.name LIKE '%" + searchText + "%' OR
            books.title LIKE '%" + searchText + "%' OR
            return_book.returndate LIKE '%" + searchText + "%'
        """;
        }

        // Column names for JTable
        String columnNames[] = {"id", "Member", "Book", "Quantity", "Return Date"};

        // Execute the query and update the table with the filtered results
        d.select(query, jTable1, columnNames);


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
            java.util.logging.Logger.getLogger(ReturnBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnBooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnADD;
    private javax.swing.JButton btnDELETE;
    private javax.swing.JButton btnEDIT;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> comboBook;
    private javax.swing.JComboBox<String> comboStudent;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblBook;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblReturnDate;
    private javax.swing.JLabel lblStudent1;
    private com.toedter.calendar.JDateChooser returnDate;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

}
