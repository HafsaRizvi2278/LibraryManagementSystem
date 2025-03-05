package Controller;

import java.sql.*;
import java.util.List;
import Model.*;
import java.util.ArrayList;


public class BookController {

    private Connection connection;

    // Constructor
    public BookController(Connection connection) {
        this.connection = connection;
    }

    // Add a book
    public void addBook(Book book) {
        BookDAO.save(connection, book);  // Calls the save method from BookDAO
    }

    // Update a book
    public void updateBook(Book book) throws Exception {
        if (book == null) {
            throw new IllegalArgumentException("Book object cannot be null.");
        }
        BookDAO.update(connection, book);
    }

    // Delete a book
    public void deleteBook(String bookId) {
        BookDAO.delete(connection, bookId);  // Calls the delete method from BookDAO
    }

    // Get a book by ID
    public Book getBookById(String bookId) {
        return BookDAO.findById(connection, bookId);  // Calls the findById method from BookDAO
    }

    // Get all books
    public List<Book> getAllBooks() {
        return BookDAO.getAllBooks(connection);  
    }

    public void inactivateBook(String bookID) throws SQLException {
        String query = "UPDATE books SET isActive = false WHERE bookID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, bookID);
            stmt.executeUpdate();
        }
    }

    public List<Book> searchBooks(String keyword) {
        List<Book> books = new ArrayList<>();
        String query = "SELECT * FROM books WHERE (title LIKE ? OR author LIKE ?) AND isActive = TRUE";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydatabase", "root", ""); PreparedStatement stmt = conn.prepareStatement(query)) {

            // Add wildcards for partial matching
            stmt.setString(1, "%" + keyword + "%");
            stmt.setString(2, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String bookID = rs.getString("bookID");
                String title = rs.getString("title");
                String author = rs.getString("author");
                int yearPublished = rs.getInt("yearPublished");
                String genre = rs.getString("genre");
                boolean isActive = rs.getBoolean("isActive");

                books.add(new Book(bookID, title, author, yearPublished, genre, isActive));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
}


