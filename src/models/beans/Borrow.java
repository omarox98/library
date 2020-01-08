package models.beans;

public class Borrow {
    private int bookId;
    private int studentId;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Borrow(int bookId, int studentId) {
        this.bookId = bookId;
        this.studentId = studentId;
    }
}
