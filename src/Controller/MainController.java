
package Controller;
import Model.*;
import java.sql.Connection;

public class MainController {
    private User currentUser;
    private Connection connection;

    public MainController(Connection connection) {
        this.connection = connection;  // Pass the DB connection here
    }

    // Login logic
    public boolean login(String userId, String password) {
        User user = UserDAO.findUserById(connection, userId);
        
        if (user != null && user.getPassword().equals(password)) {
            this.currentUser = user;
            System.out.println("Login successful. Welcome " + user.getName() + "!");
            return true;
        } else {
            System.out.println("Invalid login credentials.");
            return false;
        }
    }

    public boolean isAdmin() {
        return currentUser instanceof Admin;
    }

    public void logout() {
        this.currentUser = null;
        System.out.println("Logged out successfully.");
}

}
