import models.beans.Book;
import models.beans.Student;
import models.dao.BorrowDao;

import java.sql.SQLException;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        try {
            List<Book> books = BorrowDao.get(new Student(1,"","","",""));
            for (Book b :books) {
                System.out.println(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
