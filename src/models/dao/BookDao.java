package models.dao;

import init.DBManager;
import models.beans.Book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDao {
    private BookDao() {
    }

    public static boolean create(Book book) throws SQLException {
        PreparedStatement pst = DBManager.getInstance().prepare("INSERT INTO books (title, edition_number, date_of_appearance) VALUE (?,?,?)");
        pst.setString(1, book.getTitle());
        pst.setInt(2, book.getEditionNumber());
        pst.setInt(3, book.getYear());
        int num = pst.executeUpdate();
        ResultSet rs = pst.getGeneratedKeys();
        if (rs.next())
            book.setBookId(rs.getInt(1));
        return num > 0;
    }

    public static ArrayList<Book> list() throws SQLException {
        ArrayList<Book> books = new ArrayList<>();

        ResultSet rs = DBManager.getInstance().getStatement().executeQuery("SELECT book_id, title, edition_number, date_of_appearance, stock FROM books");
        while (rs.next()) {
            Book book = new Book(rs.getInt("book_id"), rs.getString("title"), rs.getInt("edition_number"), rs.getInt("date_of_appearance"), rs.getInt("stock"));
            books.add(book);
        }
        return books;
    }

    public static boolean update(Book book) throws SQLException {
        PreparedStatement pst = DBManager.getInstance().prepare("UPDATE books SET title=?, edition_number=?, date_of_appearance=?, stock=? WHERE book_id=?");
        pst.setString(1, book.getTitle());
        pst.setInt(2, book.getEditionNumber());
        pst.setInt(3, book.getYear());
        pst.setInt(4, book.getStock());
        pst.setInt(5, book.getBookId());

        int nbr = pst.executeUpdate();
        return nbr > 0;
    }

    public static boolean delete(Book book) throws SQLException {
        PreparedStatement pst = DBManager.getInstance().prepare("DELETE FROM books WHERE book_id=?");
        pst.setInt(1, book.getBookId());

        int nbr = pst.executeUpdate();
        return nbr > 0;
    }
}
