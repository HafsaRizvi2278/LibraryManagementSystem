package Controller;

import Model.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberController {

    private List<Member> memberList;
    private Connection connection;

    public MemberController(Connection connection) {
        this.connection = connection;
    }

    // Add a member
    public void addMember(Member member) {
        MemberDAO.save(connection, member);
    }

    // Update a member
    public void updateMember(Member member) throws Exception {
        if (member == null) {
            throw new IllegalArgumentException("Member object cannot be null.");
        }
        MemberDAO.update(connection, member); // Call the DAO update method
    }

    // Delete a member (Inactivate instead of deleting)
    public boolean inactivate(String memberId) {
        String query = "UPDATE members SET active = FALSE WHERE memberId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, memberId);
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;  // Return true if rows were affected, false otherwise
        } catch (SQLException e) {
            e.printStackTrace();  // Log the error
            return false;  // Return false if an error occurred
        }

    }

    // Get a member by ID
    public Member getMemberById(String memberId) {
        return MemberDAO.findById(connection, memberId);
    }

    // Get all members
    public List<Member> getAllMembers() {
        return MemberDAO.findAll(connection);
    }

    public List<Member> searchMembers(String keyword) {
        List<Member> members = new ArrayList<>();
        String query = "SELECT * FROM members WHERE (name LIKE ? OR membershipCardNo LIKE ?) AND active = TRUE";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydatabase", "root", "");
             PreparedStatement stmt = conn.prepareStatement(query)) {

            
            stmt.setString(1, "%" + keyword + "%");
            stmt.setString(2, "%" + keyword + "%");
            
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String memberid = rs.getString("memberid");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String contactNo = rs.getString("contactNo");
                String cardNumber = rs.getString("membershipCardNo");
                Date expiryDate = rs.getDate("expiryDate");
                boolean active = rs.getBoolean("active"); 

              
                members.add(new Member(memberid,name, email, contactNo, cardNumber, expiryDate, active));
            }
        } catch (SQLException e) {
          
            System.err.println("SQL error occurred: " + e.getMessage());
            e.printStackTrace();
        }
        return members;
    }
}
