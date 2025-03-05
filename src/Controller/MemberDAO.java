
package Controller;

import Model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

    // Save a Member
    public static void save(Connection connection, Member member) {
        try {
           
            String query = "INSERT INTO members (memberId, name, email, contactNo, membershipCardNo, expiryDate, active) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);

            stmt.setString(1, member.getUserId()); // Member ID
            stmt.setString(2, member.getName());  // Member name
            stmt.setString(3, member.getEmail()); // Email address
            stmt.setString(4, member.getContactNo()); // Contact number
            stmt.setString(5, member.getMembershipCard().getCardNumber()); // Membership card number

            // Handle expiry date (convert from java.util.Date to java.sql.Date)
            java.util.Date expiryDate = member.getMembershipCard().getExpiryDate();
            if (expiryDate != null) {
                stmt.setDate(6, new java.sql.Date(expiryDate.getTime())); // Expiry date
            } else {
                stmt.setNull(6, java.sql.Types.DATE); // Null expiry dates
            }

            // Set active status (assuming new members are active by default)
            stmt.setBoolean(7, true); // Replace `true` with a variable if needed

            // Execute the query
            stmt.executeUpdate();
            System.out.println("Member saved successfully.");
        } catch (SQLException e) {
            // Log or print the SQL exception
            e.printStackTrace();
            System.err.println("Error saving member: " + e.getMessage());
        }
    }

    // Update a Member
    public static void update(Connection connection, Member member) throws SQLException {
    String query = "UPDATE members SET name = ?, email = ?, contactNo = ?, membershipCardNo = ?, expiryDate = ? WHERE memberId = ?";

    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setString(1, member.getName());
        stmt.setString(2, member.getEmail());
        stmt.setString(3, member.getContactNo());
        stmt.setString(4, member.getMembershipCard().getCardNumber());  // Assuming membership card is part of the member object
        stmt.setDate(5, new java.sql.Date(member.getMembershipCard().getExpiryDate().getTime()));
        
        stmt.setString(6, member.getUserId());  // UserId to identify the row

        // Execute the update query
        stmt.executeUpdate();
    }
}


    // Find a Member by ID
   public static Member findById(Connection connection, String memberId) {
    String query = "SELECT * FROM members WHERE memberId = ?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setString(1, memberId);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String contactNo = rs.getString("contactNo");
                String cardNumber = rs.getString("membershipCardNo");
                Date expiryDate = rs.getDate("expiryDate");
                boolean active = rs.getBoolean("isActive"); // Retrieve active status
                MembershipCard membershipCard = new MembershipCard(cardNumber, expiryDate);
                return new Member(memberId, name, email, contactNo, membershipCard, active); // Pass active status
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}


    // Find All Members
public static List<Member> findAll(Connection connection) {
    List<Member> members = new ArrayList<>();
    String query = "SELECT * FROM members"; // Make sure the table name is correct

    try (PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            // Extract member information from the ResultSet
            String memberId = rs.getString("memberId");
            String name = rs.getString("name");
            String email = rs.getString("email");
            String contactNo = rs.getString("contactNo");
            String cardNumber = rs.getString("membershipCardNo"); // Ensure column name matches the database
            Date expiryDate = rs.getDate("expiryDate");
            boolean active = rs.getBoolean("isActive"); // Ensure the column name is correct

            // Create a MembershipCard object
            MembershipCard membershipCard = new MembershipCard(cardNumber, expiryDate);

            // Add the Member to the list
            members.add(new Member(memberId, name, email, contactNo, membershipCard, active));
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Handle SQL exception (log it appropriately in production code)
    }

    return members; // Return the list of all members
}



    public static List<Member> searchMembers(Connection connection, String searchQuery) {
    List<Member> members = new ArrayList<>();
    String query = "SELECT * FROM members WHERE name LIKE ? OR userId LIKE ? OR contactNo LIKE ?"; // Modify as needed

    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        // Search by name, userId, or contactNo (use '%' for partial matching)
        String likeSearchQuery = "%" + searchQuery + "%";  // Add '%' for wildcard search
        stmt.setString(1, likeSearchQuery);
        stmt.setString(2, likeSearchQuery);
        stmt.setString(3, likeSearchQuery);

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String userId = rs.getString("userId");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String contactNo = rs.getString("contactNo");
                boolean isActive = rs.getBoolean("active");

                // Create the Member object and add it to the list
                MembershipCard membershipCard = new MembershipCard(rs.getString("membershipCardNo"), rs.getDate("expiryDate"));
                members.add(new Member(userId, name, email, contactNo, membershipCard, isActive));
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return members;  // Return the list of matching members
}


    // Delete a Member
    public static void delete(Connection connection, String memberId) {
        String query = "DELETE FROM members WHERE memberId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, memberId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}