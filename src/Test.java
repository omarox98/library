import models.beans.Book;
import models.dao.BookDao;

import java.sql.SQLException;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        try {
            List<Book> books = BookDao.list();
            for (Book b :books) {
                System.out.println(b.getBookId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
