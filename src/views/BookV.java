package views;

import models.beans.Book;

import java.util.ArrayList;
import java.util.Scanner;

public class BookV {
    private static Scanner sc = new Scanner(System.in);

    private BookV() {
    }

    public static void list(ArrayList<Book> books) {
        System.out.println("Books");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public static void fill(Book book) {
        System.out.println("How many books will you add?");
        int amount = sc.nextInt();
        book.setStock(book.getStock() + amount);
    }

    public static Book add() {
        Book book = new Book();
        System.out.println("Enter title");
        book.setTitle(sc.nextLine());
        System.out.println("Enter the edition number");
        book.setEditionNumber(sc.nextInt());
        System.out.println("Enter the date of appearance");
        book.setYear(sc.nextInt());
        return book;
    }

    public static void update(Book book) {
        System.out.println("1- Enter title, or 0 in order not to change");
        String title = sc.nextLine();
        System.out.println("2- Enter the edition number, or 0 in order not to change");
        int ed = sc.nextInt();
        System.out.println("3- Enter the date of apearance, or 0 in order not to change");
        int yr = sc.nextInt();
        if (!title.equals("0"))
            book.setTitle(title);
        if (ed != 0)
            book.setEditionNumber(ed);
        if (yr != 0)
            book.setYear(yr);
    }
}
