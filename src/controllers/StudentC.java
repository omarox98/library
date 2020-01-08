package controllers;

import models.beans.Student;
import models.dao.StudentDao;
import views.Menu;
import views.StudentV;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentC {
    private static Scanner sc = new Scanner(System.in);

    private StudentC() {
    }

    public static void run() {
        int choice;
        do {
            choice = Menu.students();
            switch (choice) {
                case 1:
                    list();
                    break;
                case 2:
                    add();
                    break;
                case 3:
                    update();
                    break;
                case 4:
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

    public static void list() {
        try {
            ArrayList<Student> students = StudentDao.list();
            System.out.println("---------------------------------");
            StudentV.list(students);
            System.out.println("---------------------------------");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void add() {
        System.out.println("---------------------------------");
        Student student = StudentV.add();
        try {
            if (StudentDao.create(student))
                System.out.println("Added");
            System.out.println("---------------------------------");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void update() {
        System.out.println("---------------------------------");
        System.out.println("Choose a student to modify");
        list();
        int studentId = sc.nextInt();
        try {
            Student student = StudentDao.get(studentId);
            StudentV.update(student);
            if (StudentDao.update(student))
                System.out.println("Modified");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("---------------------------------");
    }

    private static void delete() {
        System.out.println("---------------------------------");
        System.out.println("Choose a Student to delete");
        list();
        int studentId = sc.nextInt();
        try {
            Student student = StudentDao.get(studentId);
            if (StudentDao.delete(student))
                System.out.println("Deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("---------------------------------");
    }
}
