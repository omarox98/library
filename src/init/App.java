package init;


import controllers.BookC;
import controllers.BorrowC;
import controllers.CSV;
import controllers.StudentC;
import views.Menu;

public class App {
    public static void main(String[] args) {
        int choice;
        do {
            choice = Menu.main();
            switch (choice) {
                case 1:
                    BookC.run();
                    break;
                case 2:
                    StudentC.run();
                    break;
                case 3:
                    BorrowC.borrow();
                    break;
                case 4:
                    BorrowC.submit();
                    break;
                case 5:
                    CSV.csvToDB();
                    break;
                case 6:
                    CSV.dbToCSV();
                    break;
                case 0:
                    break;
            }
        } while (choice != 0);
    }
}
