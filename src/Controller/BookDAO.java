
package Controller;

import Model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Model.Book;  // Assuming Book is a class in the Model package

public class BookDAO {


    // Save a book
public static void save(Connection connection, Book book) {
    try {
        String query = "INSERT INTO books (bookID, title, author, yearPublished, genre, isActive) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, book.getBookID());
        stmt.setString(2, book.getTitle());
        stmt.setString(3, book.getAuthor());
        stmt.setInt(4, book.getYearPublished());
        stmt.setString(5, book.getGenre());
        stmt.setBoolean(6, true); // Active by default
        stmt.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
}


 public static void update(Connection connection, Book book) {
    String query = "UPDATE books SET title = ?, author = ?, yearPublished = ?, genre = ?, isActive = ? WHERE bookID = ?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setString(1, book.getTitle());
        stmt.setString(2, book.getAuthor());
        stmt.setInt(3, book.getYearPublished());
        stmt.setString(4, book.getGenre());
        stmt.setBoolean(5, book.isActive());
        stmt.setString(6, book.getBookID());
        
        int rowsUpdated = stmt.executeUpdate();
        System.out.println("Rows updated: " + rowsUpdated); // Log the number of rows updated
        if (rowsUpdated == 0) {
            throw new Exception("No rows were updated. Check if the Book ID exists.");
        }
    } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("Error updating book: " + e.getMessage());
    }
}




    // Delete a book
    public static void delete(Connection connection, String bookID) {
        try {
            String query = "DELETE FROM books WHERE bookID = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, bookID);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Find a book by ID
   public static Book findById(Connection connection, String bookID) {
    String query = "SELECT * FROM books WHERE bookID = ? AND isActive = TRUE"; // Only fetch active books
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setString(1, bookID);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                String title = rs.getString("title");
                String author = rs.getString("author");
                int yearPublished = rs.getInt("yearPublished");
                String genre = rs.getString("genre");
                boolean isActive = rs.getBoolean("isActive"); // Retrieve active status
                return new Book(bookID, title, author, yearPublished, genre, isActive); // Pass active status
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null; // Return null if no book is found
}


    // Get all books using PreparedStatement
    public static List<Book> getAllBooks(Connection connection) {
    List<Book> books = new ArrayList<>();
    String query = "SELECT * FROM books"; // Only fetch active books
    try (PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            String bookID = rs.getString("bookID");
            String title = rs.getString("title");
            String author = rs.getString("author");
            int yearPublished = rs.getInt("yearPublished");
            String genre = rs.getString("genre");
            boolean isActive = rs.getBoolean("isActive");
            books.add(new Book(bookID, title, author, yearPublished, genre, isActive));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return books;
}

    public static List<Book> searchBooks(Connection connection, String keyword) {
    List<Book> books = new ArrayList<>();
    try {
        String query = "SELECT * FROM books WHERE isActive = TRUE AND (title LIKE ? OR author LIKE ?)";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, "%" + keyword + "%");
        stmt.setString(2, "%" + keyword + "%");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            books.add(new Book(
                rs.getString("bookID"),
                rs.getString("title"),
                rs.getString("author"),
                rs.getInt("yearPublished"),
                rs.getString("genre"),
                rs.getBoolean("isActive")
            ));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return books;
}

}




