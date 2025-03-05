package View;

import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.JOptionPane;
import Model.*;
import Controller.*;
import java.sql.*;

public class BookManagement extends javax.swing.JFrame {

    private BookController bookController;

    public BookManagement() {
        this.bookController = new BookController(DBConnection.getConnection()); // Initialize the controller
        initComponents();
        loadBooksIntoTable();  // Load books when the GUI is initialized
    }

    // Method to refresh the table with data from the database
    private void loadBooksIntoTable() {
        String query = "SELECT bookID, title, author, yearPublished, genre, isActive FROM books";

        try (Statement stmt = DBConnection.getConnection().createStatement(); ResultSet rs = stmt.executeQuery(query)) {

            DefaultTableModel model = (DefaultTableModel) tblBooks.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                String bookID = rs.getString("bookID");
                String title = rs.getString("title");
                String author = rs.getString("author");
                int yearPublished = rs.getInt("yearPublished");
                String genre = rs.getString("genre");
                boolean isActive = rs.getBoolean("isActive");

                // Add the row to the table model
                model.addRow(new Object[]{bookID, title, author, yearPublished, genre, isActive});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading books: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtBookID = new javax.swing.JTextField();
        txtBookName = new javax.swing.JTextField();
        txtBookAuthor = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnUPDATE = new javax.swing.JButton();
        btnDELETE = new javax.swing.JButton();
        lblQuantity = new javax.swing.JLabel();
        lblQuantity1 = new javax.swing.JLabel();
        yearChooser = new com.toedter.calendar.JYearChooser();
        jLabel7 = new javax.swing.JLabel();
        genereComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBooks = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(225, 86, 7));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPanel1.setPreferredSize(new java.awt.Dimension(1090, 550));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

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

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons8-user-50.png"))); // NOI18N
        jLabel1.setText("Welcome  Admin");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 0, 210, 60));

        jLabel2.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Book Management ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 260, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons8-return-64.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        jPanel2.setBackground(new java.awt.Color(10, 10, 45));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBookID.setBackground(new java.awt.Color(10, 10, 45));
        txtBookID.setForeground(new java.awt.Color(204, 204, 255));
        txtBookID.setText("Book_ID"); // NOI18N
        txtBookID.setActionCommand("<Not Set>");
        txtBookID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 255)));
        txtBookID.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(txtBookID, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 250, 30));

        txtBookName.setBackground(new java.awt.Color(10, 10, 45));
        txtBookName.setForeground(new java.awt.Color(204, 204, 255));
        txtBookName.setText("Book_Name");
        txtBookName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 255)));
        jPanel2.add(txtBookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 250, 30));

        txtBookAuthor.setBackground(new java.awt.Color(10, 10, 45));
        txtBookAuthor.setForeground(new java.awt.Color(204, 204, 255));
        txtBookAuthor.setText("Book_Author");
        txtBookAuthor.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 255)));
        txtBookAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookAuthorActionPerformed(evt);
            }
        });
        jPanel2.add(txtBookAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 250, 30));

        btnAdd.setBackground(new java.awt.Color(54, 235, 54));
        btnAdd.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("ADD");
        btnAdd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel2.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 80, 30));

        btnUPDATE.setBackground(new java.awt.Color(255, 153, 51));
        btnUPDATE.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnUPDATE.setForeground(new java.awt.Color(255, 255, 255));
        btnUPDATE.setText("UPDATE");
        btnUPDATE.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnUPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUPDATEActionPerformed(evt);
            }
        });
        jPanel2.add(btnUPDATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, 80, 30));

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
        jPanel2.add(btnDELETE, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 410, 80, 30));

        lblQuantity.setBackground(new java.awt.Color(0, 0, 0));
        lblQuantity.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblQuantity.setForeground(new java.awt.Color(204, 204, 255));
        lblQuantity.setText("Genere :");
        jPanel2.add(lblQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));

        lblQuantity1.setBackground(new java.awt.Color(0, 0, 0));
        lblQuantity1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblQuantity1.setForeground(new java.awt.Color(204, 204, 255));
        lblQuantity1.setText("Published Year:");
        jPanel2.add(lblQuantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        yearChooser.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.add(yearChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 130, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons8-books-50.png"))); // NOI18N
        jLabel7.setText("Add Books");
        jLabel7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 180, 50));

        genereComboBox.setBackground(new java.awt.Color(10, 10, 45));
        genereComboBox.setForeground(new java.awt.Color(204, 204, 255));
        genereComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fiction", "Non-Fiction", "Young Adult", "Children's Literature", "Classics", "Adventurous", "Encyclopedia", "FairyTales", "Other Genres", " " }));
        jPanel2.add(genereComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 150, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 490));

        tblBooks.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tblBooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book_ID", "Book_Name", "Book_Author", "Published Year", "Genere", "isActive"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Boolean.class
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
        tblBooks.setRowHeight(30);
        tblBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBooksMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBooks);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 148, 690, 370));

        txtSearch.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtSearch.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(10, 10, 45)));
        getContentPane().add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 90, 180, 30));

        btnSearch.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(225, 86, 7)));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 90, 90, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtBookAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookAuthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookAuthorActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        String bookID = txtBookID.getText();
        String title = txtBookName.getText();
        String author = txtBookAuthor.getText();
        int yearPublished = yearChooser.getYear();
        String genre = (String) genereComboBox.getSelectedItem();

        // Validate input
        if (bookID.isEmpty() || title.isEmpty() || author.isEmpty() || genre == null || genre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all required fields!");
        } else {
            // Check if bookID already exists in the database
            String query = "SELECT COUNT(*) FROM books WHERE bookID = ?";
            try (PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query)) {
                stmt.setString(1, bookID);
                ResultSet rs = stmt.executeQuery();
                if (rs.next() && rs.getInt(1) > 0) {
                    JOptionPane.showMessageDialog(this, "Book ID already exists. Please choose a different ID.");
                    return; // Stop execution if ID already exists
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error checking book ID: " + e.getMessage());
            }

            // Create the Book object
            Book book = new Book(bookID, title, author, yearPublished, genre);

            try {
                // Call controller to add the book to the database
                BookController controller = new BookController(DBConnection.getConnection());
                controller.addBook(book); // Add the book

                // Refresh the table to show the new book
                loadBooksIntoTable(); // Refresh the table with updated data

                JOptionPane.showMessageDialog(null, "Book added successfully!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error adding book: " + e.getMessage());
            }
        } //     //<editor-fold defaultstate="collapsed" desc="comment">
        //try{
        //            Class.forName("com.mysql.cj.jdbc.Driver");
        //            Connection con = DriverManager.getConnection("","root","");
        //            String sql="insert into books";
        //        }catch(Exception e){
        //            e.printStackTrace();
        //
        //</editor-fold>

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUPDATEActionPerformed

        String userId = txtBookID.getText().trim();
        String title = txtBookName.getText().trim();
        String author = txtBookAuthor.getText().trim();
        String genre = (String) genereComboBox.getSelectedItem();
        int year = yearChooser.getYear();

        // Validate input fields
        if (userId.isEmpty() || title.isEmpty() || author.isEmpty() || genre.isEmpty() || year <= 0) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields with valid data.");
            return;
        }

        try {
            // Ensure that the book is marked as active
            boolean isActive = true;

            // Log the updated values
            System.out.println("Updating book with values: ");
            System.out.println("Book ID: " + userId);
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("Year: " + year);
            System.out.println("Genre: " + genre);
            System.out.println("isActive: " + isActive);

            // Create an updated book object with isActive set to true
            Book updatedBook = new Book(userId, title, author, year, genre, isActive);

            // Update the book in the database
            BookDAO.update(DBConnection.getConnection(), updatedBook);

            // Refresh the table
            updateTable();

            JOptionPane.showMessageDialog(this, "Book updated and activated successfully!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }

    }//GEN-LAST:event_btnUPDATEActionPerformed

    private void btnDELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDELETEActionPerformed

        int selectedRow = tblBooks.getSelectedRow(); // Get selected row index
        if (selectedRow >= 0) {
            String bookID = (String) tblBooks.getValueAt(selectedRow, 0);  // Get bookID from the selected row

            // Confirm the deletion action
            int confirmDelete = JOptionPane.showConfirmDialog(this, "Are you sure you want to inactivate this book?",
                    "Confirm Deletion", JOptionPane.YES_NO_OPTION);
            if (confirmDelete == JOptionPane.YES_OPTION) {
                try {
                    // Call the controller to mark the book as inactive (not deleted)
                    BookController controller = new BookController(DBConnection.getConnection());
                    controller.inactivateBook(bookID); // Inactivate the book

                    loadBooksIntoTable();

                    JOptionPane.showMessageDialog(this, "Book inactivated successfully!");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error inactivating book: " + e.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a book to inactivate.");
        }
    }//GEN-LAST:event_btnDELETEActionPerformed

    private void updateTable() {
        try (Connection connection = DBConnection.getConnection()) {
            List<Book> books = BookDAO.getAllBooks(connection);
            DefaultTableModel model = (DefaultTableModel) tblBooks.getModel();
            model.setRowCount(0); // Clear the table

            for (Book book : books) {
                model.addRow(new Object[]{
                    book.getBookID(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getYearPublished(),
                    book.getGenre(),
                    book.isActive() // Reflects the current state of isActive
                });
            }
            System.out.println("Table updated successfully."); // Log table update
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error fetching books: " + e.getMessage());
        }
    }


    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        new MenuAdmin().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String searchKeyword = txtSearch.getText().trim();
        List<Book> books = bookController.searchBooks(searchKeyword);  // Fetch books based on search
        updateTable(books);
    }//GEN-LAST:event_btnSearchActionPerformed

    

    private void updateTable(List<Book> books) {
        DefaultTableModel model = (DefaultTableModel) tblBooks.getModel();
        model.setRowCount(0); // Clear existing rows
        for (Book book : books) {
            if (book.isActive()) { // Display only active books
                model.addRow(new Object[]{
                    book.getBookID(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getYearPublished(),
                    book.getGenre()
                });
            }
        }
    }
    private void tblBooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBooksMouseClicked
        int selectedRow = tblBooks.getSelectedRow();
        if (selectedRow >= 0) {
            // Get the selected row data and fill the input fields
            String bookID = (String) tblBooks.getValueAt(selectedRow, 0);
            String title = (String) tblBooks.getValueAt(selectedRow, 1);
            String author = (String) tblBooks.getValueAt(selectedRow, 2);
            int yearPublished = (Integer) tblBooks.getValueAt(selectedRow, 3);
            String genre = (String) tblBooks.getValueAt(selectedRow, 4);

            // Populate the input fields
            txtBookID.setText(bookID);
            txtBookName.setText(title);
            txtBookAuthor.setText(author);
            yearChooser.setYear(yearPublished);
            genereComboBox.setSelectedItem(genre);
        }
    }//GEN-LAST:event_tblBooksMouseClicked

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
            java.util.logging.Logger.getLogger(BookManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDELETE;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUPDATE;
    private javax.swing.JComboBox<String> genereComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblQuantity1;
    private javax.swing.JTable tblBooks;
    private javax.swing.JTextField txtBookAuthor;
    private javax.swing.JTextField txtBookID;
    private javax.swing.JTextField txtBookName;
    private javax.swing.JTextField txtSearch;
    private com.toedter.calendar.JYearChooser yearChooser;
    // End of variables declaration//GEN-END:variables

}
