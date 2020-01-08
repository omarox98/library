package controllers;

import models.beans.Book;
import models.beans.Borrow;
import models.beans.Student;
import models.dao.BookDao;
import models.dao.BorrowDao;
import models.dao.StudentDao;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CSV {
    private CSV() {
    }

    public static void dbToCSV() {
        Runnable st = () -> {
            File file = new File("files/students.csv");
            try {
                file.createNewFile();
                PrintWriter out = new PrintWriter(file);
                ArrayList<Student> students = StudentDao.list();
                out.println("student_id,first_name,last_name,study_path,cin");
                for (Student student : students) {
                    out.println(student.getStudentId() + "," + student.getFname() + "," + student.getLname() + "," + student.getStudyPath() + "," + student.getCin());
                }
                out.close();
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        };
        Runnable bk = () -> {
            File file = new File("files/books.csv");
            try {
                file.createNewFile();
                PrintWriter out = new PrintWriter(file);
                ArrayList<Book> books = BookDao.list();
                out.println("book_id,title,edition_number,date_of_appearance,stock");
                for (Book book : books) {
                    out.println(book.getBookId() + "," + book.getTitle() + "," + book.getEditionNumber() + "," + book.getYear() + "," + book.getStock());
                }
                out.close();
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        };
        Runnable br = () -> {
            File file = new File("files/borrow.csv");
            try {
                file.createNewFile();
                PrintWriter out = new PrintWriter(file);
                ArrayList<Borrow> borrows = BorrowDao.list();
                out.println("book_id,student_id");
                for (Borrow borrow : borrows) {
                    out.println(borrow.getBookId() + "," + borrow.getStudentId());
                }
                out.close();
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        };

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(st);
        executor.execute(bk);
        executor.execute(br);
        executor.shutdown();
    }

    public static void csvToDB() {
        Runnable st = () -> {
            File file = new File("files/students.csv");
            try {
                if (file.exists()) {
                    Scanner in = new Scanner(file);
                    in.nextLine();
                    String[] str = in.nextLine().split(",");
                    while (in.hasNextLine()) {

                        Student student = new Student(str[1], str[2], str[3], str[4]);
                        StudentDao.create(student);
                        str = in.nextLine().split(",");
                    }
                    in.close();
                }
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        };
        Runnable bk = () -> {
            File file = new File("files/books.csv");
            try {
                if (file.exists()) {
                    Scanner in = new Scanner(file);
                    in.nextLine();
                    String[] str = in.nextLine().split(",");
                    while (in.hasNextLine()) {

                        Book book = new Book(str[1], Integer.parseInt(str[2].trim()), Integer.parseInt(str[3].trim()));
                        book.setStock(Integer.parseInt(str[4].trim()));
                        BookDao.create(book);
                        BookDao.update(book);
                        str = in.nextLine().split(",");
                    }
                    in.close();
                }
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        };
        Runnable br = () -> {
            File file = new File("files/borrow.csv");
            try {
                if (file.exists()) {
                    PrintWriter out = new PrintWriter(file);
                    ArrayList<Borrow> borrows = BorrowDao.list();
                    out.println("book_id,student_id");
                    for (Borrow borrow : borrows) {
                        out.println(borrow.getBookId() + "," + borrow.getStudentId());
                    }
                    out.close();
                }
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        };

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(st);
        executor.execute(bk);
        //executor.execute(br);
        executor.shutdown();
    }
}
