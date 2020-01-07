package controllers;

import models.beans.Book;
import models.dao.BookDao;
import views.BookV;
import views.Menu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class BookC {
    private static Scanner sc = new Scanner(System.in);

    private BookC() {
    }

    public static void run() {
        int choice;
        do {
            choice = Menu.books();
            switch (choice) {
                case 1:
                    list();
                    break;
                case 2:
                    fill();
                    break;
                case 3:
                    add();
                    break;
                case 4:
                    update();
                    break;
                case 5:
                    delete();
                    break;
                case 0:
                    break;
                default:
                    System.out.println();
                    System.out.println("invalid choice");
                    System.out.println();
            }
        } while (choice != 0);
    }

    private static void list() {
        try {
            ArrayList<Book> books = BookDao.list();
            System.out.println("---------------------------------");
            BookV.list(books);
            System.out.println("---------------------------------");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void fill() {
        System.out.println("---------------------------------");
        System.out.println("Choose a book to fill");
        list();
        int bookId = sc.nextInt();
        try {
            Book book = BookDao.get(bookId);
            BookV.fill(book);
            if (BookDao.update(book))
                System.out.println("Filled out");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("---------------------------------");
    }

    private static void add() {
        System.out.println("---------------------------------");
        Book book = BookV.add();
        try {
            if (BookDao.create(book))
                System.out.println("Created");
            System.out.println("---------------------------------");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void update() {
        System.out.println("---------------------------------");
        System.out.println("Choose a book to modify");
        list();
        int bookId = sc.nextInt();
        try {
            Book book = BookDao.get(bookId);
            BookV.update(book);
            if (BookDao.update(book))
                System.out.println("Modified");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("---------------------------------");
    }

    private static void delete() {
        System.out.println("---------------------------------");
        System.out.println("Choose a book to delete");
        list();
        int bookId = sc.nextInt();
        try {
            Book book = BookDao.get(bookId);
            if (BookDao.delete(book))
                System.out.println("Deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("---------------------------------");
    }
}
