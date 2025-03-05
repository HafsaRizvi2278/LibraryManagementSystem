package View;

import Controller.*;
import Model.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class MemberManagement extends javax.swing.JFrame {

    private MemberController memberController;
    
    public MemberManagement() {

        this.memberController = new MemberController(DBConnection.getConnection()); // Initialize the controller
        initComponents();
        loadBookData();
        loadMembersIntoTable();

    }

    private void loadBookData() {
        List<Member> member = memberController.searchMembers("");
        updateTable(member);
    }
    
    private void updateTable(List<Member> members) {
        DefaultTableModel model = (DefaultTableModel) tblMembers.getModel();
        model.setRowCount(0); 
        for (Member member : members) {
            if (member.isActive()) { 
                model.addRow(new Object[]{
                    member.getUserId(),
                    member.getName(),
                    member.getEmail(),
                    member.getContactNo(),
                    member.getMembershipCard().getCardNumber(),
                    member.getExpiryDate()
                });
            }
        }
    }

    
    private void loadMembersIntoTable() {
        
        DefaultTableModel model = (DefaultTableModel) tblMembers.getModel();
        model.setRowCount(0);

        
        String query = "SELECT * FROM members"; 

        try (Connection conn = DBConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                String userId = rs.getString("memberID");
                String name = rs.getString("name");
                String contactno = rs.getString("contactno");
                String email = rs.getString("email");
                String membershipcardno = rs.getString("membershipcardno");
                java.sql.Date expirydate = rs.getDate("expirydate");
                boolean active = rs.getBoolean("active");

                
                model.addRow(new Object[]{userId, name, contactno, email, membershipcardno, expirydate, active});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading members: " + e.getMessage());
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
        txtMemberID = new javax.swing.JTextField();
        txtMemberName = new javax.swing.JTextField();
        btnADD = new javax.swing.JButton();
        btnEDIT = new javax.swing.JButton();
        btnDELETE = new javax.swing.JButton();
        txtContactNo = new javax.swing.JTextField();
        txtEmail1 = new javax.swing.JTextField();
        txtMembershipCardNo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        dateChooser = new com.toedter.calendar.JDateChooser();
        lblQuantity = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMembers = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(225, 86, 7));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
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

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons8-user-50.png"))); // NOI18N
        jLabel1.setText("Welcome  Admin");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 0, 210, 60));

        jLabel2.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Member Management ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 260, 40));

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

        txtMemberID.setBackground(new java.awt.Color(10, 10, 45));
        txtMemberID.setForeground(new java.awt.Color(204, 204, 255));
        txtMemberID.setText("Member_ID"); // NOI18N
        txtMemberID.setActionCommand("<Not Set>");
        txtMemberID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 255)));
        txtMemberID.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(txtMemberID, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 250, 30));

        txtMemberName.setBackground(new java.awt.Color(10, 10, 45));
        txtMemberName.setForeground(new java.awt.Color(204, 204, 255));
        txtMemberName.setText("Member_Name");
        txtMemberName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 255)));
        jPanel2.add(txtMemberName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 250, 30));

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
        jPanel2.add(btnADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 80, 30));

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
        jPanel2.add(btnEDIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 440, 80, 30));

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
        jPanel2.add(btnDELETE, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 440, 80, 30));

        txtContactNo.setBackground(new java.awt.Color(10, 10, 45));
        txtContactNo.setForeground(new java.awt.Color(204, 204, 255));
        txtContactNo.setText("ContactNo");
        txtContactNo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 255)));
        jPanel2.add(txtContactNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 250, 30));

        txtEmail1.setBackground(new java.awt.Color(10, 10, 45));
        txtEmail1.setForeground(new java.awt.Color(204, 204, 255));
        txtEmail1.setText("E-Mail");
        txtEmail1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 255)));
        jPanel2.add(txtEmail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 250, 30));

        txtMembershipCardNo.setBackground(new java.awt.Color(10, 10, 45));
        txtMembershipCardNo.setForeground(new java.awt.Color(204, 204, 255));
        txtMembershipCardNo.setText("MembershipCard_No");
        txtMembershipCardNo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 255)));
        jPanel2.add(txtMembershipCardNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 250, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons8-people-50.png"))); // NOI18N
        jLabel6.setText("Add Member");
        jLabel6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 210, 50));
        jPanel2.add(dateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 150, 30));

        lblQuantity.setBackground(new java.awt.Color(0, 0, 0));
        lblQuantity.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblQuantity.setForeground(new java.awt.Color(204, 204, 255));
        lblQuantity.setText("Expiery Date :");
        jPanel2.add(lblQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 490));

        tblMembers.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tblMembers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Member ID", "Member Name", "Contact No", "E - Mail", "MembershipCard No.", "Expiery Date", "active"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMembers.setRowHeight(30);
        tblMembers.setShowGrid(true);
        tblMembers.setSurrendersFocusOnKeystroke(true);
        tblMembers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMembersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMembers);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 730, 360));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons8-people-50.png"))); // NOI18N
        jLabel5.setText("Add Member");
        jLabel5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 210, 50));

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

    private void btnADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnADDActionPerformed

        String userId = txtMemberID.getText();
        String name = txtMemberName.getText();
        String contactno = txtContactNo.getText();
        String email = txtEmail1.getText();
        String membershipcardno = txtMembershipCardNo.getText();
        java.util.Date expierydate = dateChooser.getDate();//

        // Validate input   
        if (userId.isEmpty() || name.isEmpty() || contactno == null || email.isEmpty() || membershipcardno.isEmpty() || expierydate == null) {
            JOptionPane.showMessageDialog(null, "Please fill in all required fields!");
        } else {
            // Check if bookID already exists in the database
            String query = "SELECT COUNT(*) FROM members WHERE memberID = ?";
            try (PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query)) {
                stmt.setString(1, userId);
                ResultSet rs = stmt.executeQuery();
                if (rs.next() && rs.getInt(1) > 0) {
                    JOptionPane.showMessageDialog(this, "Member ID already exists. Please choose a different ID.");
                    return; // Stop execution if ID already exists
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error checking book ID: " + e.getMessage());
            }

            Member member = new Member(userId, name, contactno, email, membershipcardno);

            try {
                MemberController memberController = new MemberController(DBConnection.getConnection()); // Call controller to add the book to the database
                memberController.addMember(member);

                // Refresh the table to show the new book
                loadMembersIntoTable(); // Refresh the table with updated data

                JOptionPane.showMessageDialog(null, "Member added successfully!");
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

    }//GEN-LAST:event_btnADDActionPerformed

    private void btnEDITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEDITActionPerformed

        String userId = txtMemberID.getText().trim();
        String name = txtMemberName.getText().trim();
        String email = txtEmail1.getText().trim();
        String membershipCardNo = txtMembershipCardNo.getText().trim();
        String contactNo = txtContactNo.getText().trim();
        java.util.Date expiryDate = dateChooser.getDate();

        // Validation
        if (userId.isEmpty() || name.isEmpty() || email.isEmpty() || contactNo.isEmpty() || membershipCardNo.isEmpty() || expiryDate == null) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return;
        }

        try {
            // Create MembershipCard with card number and expiry date
            MembershipCard card = new MembershipCard(membershipCardNo, new java.sql.Date(expiryDate.getTime()));

            // Create updated member object
            Member updatedMember = new Member(userId, name, email, contactNo, card);

            // Update the member in the database
            try (Connection connection = DBConnection.getConnection()) {
                MemberDAO.update(connection, updatedMember); // Call the DAO update method
                JOptionPane.showMessageDialog(this, "Member updated successfully.");

                // Refresh the table to show updated data
                refreshMemberTable();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }

    }//GEN-LAST:event_btnEDITActionPerformed

    private void btnDELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDELETEActionPerformed

        int selectedRow = tblMembers.getSelectedRow();

        if (selectedRow >= 0) {
            {
                String memberId = (String) tblMembers.getValueAt(selectedRow, 0);

                // Show a confirmation dialog to the user
                int confirmation = JOptionPane.showConfirmDialog(
                        this,
                        "Are you sure you want to inactivate this member?",
                        "Confirm Inactivation",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirmation == JOptionPane.YES_OPTION) {
                    try {
                        // Call the controller to mark the book as inactive (not deleted)
                        MemberController controller = new MemberController(DBConnection.getConnection());
                        controller.inactivate(memberId); // Inactivate the book

                        // After inactivating, refresh the table to reflect the updated status
                        loadMembersIntoTable(); // Refresh the table with updated data

                        JOptionPane.showMessageDialog(this, "Member inactivated successfully!");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Error inactivating Member: " + e.getMessage());
                    }

                } else {
                    // Notify the user if no row is selected
                    JOptionPane.showMessageDialog(
                            this,
                            "Please select a member to inactivate.",
                            "No Member Selected",
                            JOptionPane.WARNING_MESSAGE
                    );
                }

            }
        }
    }//GEN-LAST:event_btnDELETEActionPerformed


    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        new MenuAdmin().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String searchKeyword = txtSearch.getText().trim();
        List<Member> member = memberController.searchMembers(searchKeyword);  // Fetch books based on search
        updateTable(member);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void tblMembersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMembersMouseClicked

        int selectedRow = tblMembers.getSelectedRow();  // Get the selected row

        // Check if a row is selected
        if (selectedRow >= 0) {
            String userId = tblMembers.getValueAt(selectedRow, 0).toString();  // Assuming first column is userId
            String name = tblMembers.getValueAt(selectedRow, 1).toString();
            String email = tblMembers.getValueAt(selectedRow, 2).toString();
            String contactNo = tblMembers.getValueAt(selectedRow, 3).toString();

            // Populate the fields with the selected data
            txtMemberID.setText(userId);
            txtMemberName.setText(name);
            txtEmail1.setText(email);
            txtContactNo.setText(contactNo);
        }

    }//GEN-LAST:event_tblMembersMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MemberManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnADD;
    private javax.swing.JButton btnDELETE;
    private javax.swing.JButton btnEDIT;
    private javax.swing.JButton btnSearch;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JTable tblMembers;
    private javax.swing.JTextField txtContactNo;
    private javax.swing.JTextField txtEmail1;
    private javax.swing.JTextField txtMemberID;
    private javax.swing.JTextField txtMemberName;
    private javax.swing.JTextField txtMembershipCardNo;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    private void refreshMemberTable() {
        try (Connection connection = DBConnection.getConnection()) {
            List<Member> members = MemberDAO.findAll(connection);
            DefaultTableModel model = (DefaultTableModel) tblMembers.getModel();
            model.setRowCount(0);

            for (Member member : members) {
                model.addRow(new Object[]{
                    member.getUserId(),
                    member.getName(),
                    member.getEmail(),
                    member.getContactNo(),
                    member.getMembershipCard().getCardNumber(),
                    member.getExpiryDate(),
                    member.isActive()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error refreshing table: " + e.getMessage());
        }
    }

}
