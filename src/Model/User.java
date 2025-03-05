
package Model;


public abstract class User {
    
    protected String userId;
    protected String name;
    protected String password;

    // Constructor
    public User(String userId, String name, String password) {
        this.userId = userId;
        this.name = name;
        this.password = password;
    }

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

}
