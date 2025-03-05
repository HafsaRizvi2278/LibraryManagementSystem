
package Model;


public class Admin extends User{
  

    public Admin(String userId, String name, String password) {
        super(userId, name, password);
    }
 
    public void displayDetails() {
        System.out.println("Admin ID: " + getUserId());
        System.out.println("Name: " + getName());
    }

    // Additional Admin-specific methods
    public void manageMembers() {
        System.out.println("Managing members...");
    }

    public void manageBooks() {
        System.out.println("Managing books...");
    }


}
