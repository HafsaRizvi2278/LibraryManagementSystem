
package Controller;


import Model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UserDAO {


    private static final Logger LOGGER = Logger.getLogger(UserDAO.class.getName());

    public static User findUserById(Connection connection, String userId) {
    String query = "SELECT * FROM users WHERE userId = ?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setString(1, userId);

        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                String name = rs.getString("name");
                String password = rs.getString("password");
                String role = rs.getString("role");
                String email = rs.getString("email");
                String contactNo = rs.getString("contactNo");
                String cardNumber = rs.getString("cardNumber"); 
                Date expiryDate = rs.getDate("expiryDate");
                boolean active = rs.getBoolean("isActive"); // Retrieve active status

                // Check if the retrieved values are not null
                if (cardNumber == null || expiryDate == null) {
                    LOGGER.warning("MembershipCard information is missing for user: " + userId);
                    cardNumber = ""; 
                    expiryDate = null; 
                }

                LOGGER.info("Retrieved user: " + userId + ", name: " + name + ", email: " + email + ", contactNo: " + contactNo);
                LOGGER.info("MembershipCard info: cardNumber=" + cardNumber + ", expiryDate=" + expiryDate);

                if ("admin".equalsIgnoreCase(role)) {
                    return new Admin(userId, name, password);
                } else if ("member".equalsIgnoreCase(role)) {
                    MembershipCard membershipCard = new MembershipCard(cardNumber, (java.sql.Date) expiryDate);
                    return new Member(userId, name, email, contactNo, membershipCard, active); // Use the new constructor
                }
            } else {
                LOGGER.warning("No user found with ID: " + userId);
            }
        }
    } catch (Exception e) {
        LOGGER.log(Level.SEVERE, "Error finding user by ID: " + userId, e);
    }
    return null; // Return null if no user found
}

}













