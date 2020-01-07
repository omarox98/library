package models.dao;

import init.DBManager;
import models.beans.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDao {
    private StudentDao() {
    }

    public static boolean create(Student student) throws SQLException {
        PreparedStatement pst = DBManager.getInstance().prepare("INSERT INTO students (first_name, last_name, study_path, cin) VALUE (?,?,?,?)");
        pst.setString(1, student.getFname());
        pst.setString(2, student.getLname());
        pst.setString(3, student.getStudyPath());
        pst.setString(4, student.getCin());
        int num = pst.executeUpdate();
        ResultSet rs = pst.getGeneratedKeys();
        if (rs.next())
            student.setStudentId(rs.getInt(1));
        return num > 0;
    }

    public static Student get(int id) throws SQLException {
        Student student = null;
        PreparedStatement pst = DBManager.getInstance().prepare("SELECT student_id, first_name, last_name, study_path, cin FROM students WHERE student_id=?");
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            student = new Student(rs.getInt("student_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("study_path"), rs.getString("cin"));
        }
        return student;
    }

    public static ArrayList<Student> list() throws SQLException {
        ArrayList<Student> students = new ArrayList<>();

        ResultSet rs = DBManager.getInstance().getStatement().executeQuery("SELECT student_id, first_name, last_name, study_path, cin FROM students");
        while (rs.next()) {
            Student student = new Student(rs.getInt("student_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("study_path"), rs.getString("cin"));
            students.add(student);
        }
        return students;
    }

    public static boolean update(Student student) throws SQLException {
        PreparedStatement pst = DBManager.getInstance().prepare("UPDATE students SET first_name=?, last_name=?, study_path=?, cin=? WHERE student_id=?");
        pst.setString(1, student.getFname());
        pst.setString(2, student.getLname());
        pst.setString(3, student.getStudyPath());
        pst.setString(4, student.getCin());
        pst.setInt(5, student.getStudentId());

        int nbr = pst.executeUpdate();
        return nbr > 0;
    }

    public static boolean delete(Student student) throws SQLException {
        PreparedStatement pst = DBManager.getInstance().prepare("DELETE FROM students WHERE student_id=?");
        pst.setInt(1, student.getStudentId());

        int nbr = pst.executeUpdate();
        return nbr > 0;
    }
}
