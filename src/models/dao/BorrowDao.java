package models.dao;

import init.DBManager;
import models.beans.Book;
import models.beans.Borrow;
import models.beans.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BorrowDao {
    private BorrowDao() {
    }

    public static ArrayList<Book> get(Student student) throws SQLException {
        ArrayList<Book> books = new ArrayList<>();
        PreparedStatement pst = DBManager.getInstance().prepare("SELECT book_id FROM borrow WHERE student_id=?");
        pst.setInt(1, student.getStudentId());
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            books.add(BookDao.get(rs.getInt("book_id")));
        }
        return books;
    }

    public static ArrayList<Borrow> list() throws SQLException {
        ArrayList<Borrow> borrows = new ArrayList<>();
        PreparedStatement pst = DBManager.getInstance().prepare("SELECT book_id, student_id FROM borrow");
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            borrows.add(new Borrow(rs.getInt("book_id"), rs.getInt("student_id")));
        }
        return borrows;
    }

    public static boolean borrow(Student student, int book) throws SQLException {
        PreparedStatement pst = DBManager.getInstance().prepare("INSERT INTO borrow (book_id, student_id) VALUE (?,?)");
        pst.setInt(1, book);
        pst.setInt(2, student.getStudentId());
        int num = pst.executeUpdate();
        return num > 0;
    }

    public static boolean submit(Student student, int book) throws SQLException {
        PreparedStatement pst = DBManager.getInstance().prepare("DELETE FROM borrow WHERE book_id=? and student_id=?");
        pst.setInt(1, book);
        pst.setInt(2, student.getStudentId());
        int num = pst.executeUpdate();
        return num > 0;
    }
}
