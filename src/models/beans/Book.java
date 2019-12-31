package models.beans;

public class Book {
    private int bookId;
    private String title;
    private int editionNumber;
    private int year;
    private int stock;

    public Book() {
    }

    public Book(String title, int editionNumber, int year) {
        this.title = title;
        this.editionNumber = editionNumber;
        this.year = year;
    }

    public Book(int bookId, String title, int editionNumber, int year) {
        this.bookId = bookId;
        this.title = title;
        this.editionNumber = editionNumber;
        this.year = year;
    }

    public Book(int bookId, String title, int editionNumber, int year, int stock) {
        this.bookId = bookId;
        this.title = title;
        this.editionNumber = editionNumber;
        this.year = year;
        this.stock = stock;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEditionNumber() {
        return editionNumber;
    }

    public void setEditionNumber(int editionNumber) {
        this.editionNumber = editionNumber;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", editionNumber=" + editionNumber +
                ", year=" + year +
                ", stock=" + stock +
                '}';
    }
}
