package views;

public class Menu {
    public static void main() {
        System.out.println("1- Manage books");
        System.out.println("2- Manage students");
        System.out.println("3- To borrow a book");
        System.out.println("4- Submit a book");
        System.out.println("5- Load data from a file to the database");
        System.out.println("6- Save data from database to CSV file");
    }

    public static void book() {
        System.out.println("1- List books");
        System.out.println("2- Fill the stock of a book");
        System.out.println("3- Add a book");
        System.out.println("4- Edit a book");
        System.out.println("5- Delete a book");
    }

    public static void student() {
        System.out.println("1- List students");
        System.out.println("2- Add a student");
        System.out.println("3- Edit a student");
        System.out.println("4- Delete a student");
    }
}
