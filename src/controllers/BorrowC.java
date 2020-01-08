package controllers;

import models.beans.Book;
import models.beans.Student;
import models.dao.BookDao;
import models.dao.BorrowDao;
import models.dao.StudentDao;
import views.BookV;

import java.sql.SQLException;
import java.util.Scanner;

public class BorrowC {
    private static Scanner sc = new Scanner(System.in);

    private BorrowC() {
    }

    public static void borrow() {
        System.out.println("Choose the book id to borrow");
        BookC.list();
        int bookId = sc.nextInt();
        System.out.println("Choose student");
        StudentC.list();
        int studentId = sc.nextInt();
        try {
            Student student = StudentDao.get(studentId);
            Book book = BookDao.get(bookId);
            student.setBooks(BorrowDao.get(student));
            if (student.getBooks().size() < 3) {
                if (book.getStock() > 0) {

                    for (Book b :student.getBooks()) {
                        if (b.getBookId() == bookId){
                            System.out.println("You can't borrow same book 2 times");
                            return;
                        }
                    }
                    if (BorrowDao.borrow(student, bookId)) {
                        book.setStock(book.getStock() - 1);
                        BookDao.update(book);
                    }


                } else {
                    System.out.println("Stock out");
                }
            } else {
                System.out.println("Sufficient books have been borrowed");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void submit() {
        System.out.println("Choose student");
        StudentC.list();
        int studentId = sc.nextInt();
        try {
            Student student = StudentDao.get(studentId);
            student.setBooks(BorrowDao.get(student));
            System.out.println("Choose the book id to submit");
            BookV.list(student.getBooks());
            int bookId = sc.nextInt();
            BorrowDao.submit(student, bookId);
            Book book = BookDao.get(bookId);
            book.setStock(book.getStock() + 1);
            BookDao.update(book);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
