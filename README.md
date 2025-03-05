

# *Library Management System (LMS) 📚*  

A *Java-based Library Management System* built using *Swing and MVC architecture*, allowing administrators to manage books and members while providing members with search and view access.  

## *Features* 🚀  

### *1. User Roles & Permissions*  
- *Admin*:  
  ✅ Add, edit, delete books and members.  
  ✅ View all books and members.  
  ✅ Full CRUD operations.  
- *Member*:  
  ✅ Search and view books.  
  ✅ No modification privileges.  

### *2. Core Functionalities*  
✔ *Book Management* (Add, Edit, Delete, View books).  
✔ *Member Management* (Add, Edit, Delete, View members).  
✔ *Login System* (Role-based authentication).  
✔ *Dynamic Data Synchronization* (JTable updates in real-time).  
✔ *Role-Based Access Control* (Admin vs. Member permissions).  

### *3. Tech Stack*  
🔹 *Java Swing* – GUI framework.  
🔹 *JTable* – Displays books and members dynamically.  
🔹 *MVC Pattern* – Separates logic, UI, and data.  
🔹 *MySQL* – Stores book and member records.  
🔹 *JDBC* – Connects Java to the database.  
🔹 *Object-Oriented Programming* – Encapsulation, Inheritance, Polymorphism, etc.  

---

## *Database Setup (MySQL) 🗄*  

### *Step 1: Create Database*  
Open MySQL and run:  
sql
CREATE DATABASE library_db;
USE library_db;


### *Step 2: Create Tables*  

#### *1. Members Table*  
sql
CREATE TABLE members (
    member_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    role ENUM('Admin', 'Member') NOT NULL,
    password VARCHAR(255) NOT NULL
);


#### *2. Books Table*  
sql
CREATE TABLE books (
    book_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(100) NOT NULL,
    isbn VARCHAR(20) UNIQUE NOT NULL,
    available BOOLEAN DEFAULT TRUE
);


#### *3. Sample Data (Optional)*  
sql
INSERT INTO members (name, email, role, password) VALUES
('Admin User', 'admin@example.com', 'Admin', 'admin123'),
('John Doe', 'john@example.com', 'Member', 'password123');

INSERT INTO books (title, author, isbn, available) VALUES
('The Great Gatsby', 'F. Scott Fitzgerald', '9780743273565', TRUE),
('To Kill a Mockingbird', 'Harper Lee', '9780061120084', TRUE);


---

## *Connect Java to MySQL (JDBC) 🖧*  

1. *Download MySQL Connector/J* from: [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/)  
2. Add the *JAR file* to your *NetBeans* project:  
   - Right-click the project → *Properties* → *Libraries* → *Add JAR/Folder* → Select *mysql-connector-java-X.X.X.jar*  
3. *Modify Database Connection Code in Java:*  

java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/library_db";
    private static final String USER = "root";  // Change if needed
    private static final String PASSWORD = "";  // Change if needed

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}


---

## *Screenshots* 📸  

 ![image](https://github.com/user-attachments/assets/b4f64afb-ef9e-43d3-9df3-86b1cc39fa46)
 ![image](https://github.com/user-attachments/assets/c0e1b09c-835f-4003-98d1-b4fffde36954)
 ![image](https://github.com/user-attachments/assets/a76addf1-f754-436f-aad0-39612af9cb1b)
 ![image](https://github.com/user-attachments/assets/1b4e51fd-300b-4634-a0d1-83077f9f638e)
 ![image](https://github.com/user-attachments/assets/e5ca3f74-102a-4087-b5fb-d40e91a6fba1)
 ![image](https://github.com/user-attachments/assets/a1c64c1e-07b3-498d-bc12-5a825daf571b)
 ![image](https://github.com/user-attachments/assets/991277d9-7c39-4ef9-80ec-32d2abf5fa14)
 
 ![image](https://github.com/user-attachments/assets/b4faf7ad-bc9d-49c5-a26c-ce16924c483a)
 ![image](https://github.com/user-attachments/assets/5092ad74-6d92-42a3-9cf4-e04c372c72f8)
 ![image](https://github.com/user-attachments/assets/590f69ba-1305-4fe1-98c1-5ed423668dfe)




## *Installation & Setup* 🛠  

1. Clone the repository:  
   bash
   git clone https://github.com/your-username/Library-Management-System.git
   cd Library-Management-System
     
2. Import into *NetBeans* or any Java IDE.  
3. Set up the *MySQL database* (see above).  
4. Run the application.  

---

## *Project Structure* 📂  


📁 LibraryManagementSystem  
 ┣ 📁 src  
 ┃ ┣ 📂 models  # Data handling (Books, Members)  
 ┃ ┣ 📂 views   # UI components (Swing)  
 ┃ ┣ 📂 controllers  # Logic & event handling  
 ┃ ┣ DatabaseConnection.java  # MySQL connection  
 ┃ ┣ Main.java  # Entry point  
 ┗ README.md  
  

