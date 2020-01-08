package models.beans;

import java.util.ArrayList;

public class Student {
    private int studentId;
    private String fname;
    private String lname;
    private String studyPath;
    private String cin;
    private ArrayList<Book> books;

    public Student() {
        this.books = new ArrayList<>();
    }

    public Student(String fname, String lname, String studyPath, String cin) {
        this.fname = fname;
        this.lname = lname;
        this.studyPath = studyPath;
        this.cin = cin;
        this.books = new ArrayList<>();
    }

    public Student(int studentId, String fname, String lname, String studyPath, String cin) {
        this.studentId = studentId;
        this.fname = fname;
        this.lname = lname;
        this.studyPath = studyPath;
        this.cin = cin;
        this.books = new ArrayList<>();
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getStudyPath() {
        return studyPath;
    }

    public void setStudyPath(String studyPath) {
        this.studyPath = studyPath;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", studyPath='" + studyPath + '\'' +
                ", cin='" + cin + '\'' +
                '}';
    }
}
