 
package Model;


public class Book {
    private String bookID;
    private String title;
    private String author;
    private int yearPublished;
    private String genre;
    private boolean isActive;

    public Book(String bookID, String title, String author, int yearPublished , String genre,boolean isActive) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.genre = genre;
        this.isActive = isActive;
    }

    public Book(String bookID, String title, String author, int yearPublished , String genre) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.genre = genre;
        
    }
    
    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }
    
    public String getGenre() {
        return genre;
    }

    public void getGenre(String genre) {
        this.genre = genre;
    }

     public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        isActive = isActive;
    }
    
    public void displayDetails() {
        System.out.println("Book ID: " + bookID);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year Published: " + yearPublished);
        System.out.println("Genre : " + genre);
    }

}
