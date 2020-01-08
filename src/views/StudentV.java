package views;

import models.beans.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentV {
    private static Scanner sc = new Scanner(System.in);

    private StudentV() {
    }

    public static void list(ArrayList<Student> students) {
        System.out.println("Books");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static Student add() {
        sc.nextLine();
        Student student = new Student();
        System.out.println("Enter first name");
        student.setFname(sc.nextLine());
        System.out.println("Enter last name");
        student.setLname(sc.nextLine());
        System.out.println("Enter study path");
        student.setStudyPath(sc.nextLine());
        System.out.println("Enter CIN");
        student.setCin(sc.nextLine());
        return student;
    }

    public static void update(Student student) {
        sc.nextLine();
        System.out.println("Enter first name, or 0 in order not to change");
        String fname = sc.nextLine();
        System.out.println("Enter last name, or 0 in order not to change");
        String lname = sc.nextLine();
        System.out.println("Enter study path, or 0 in order not to change");
        String path = sc.nextLine();
        System.out.println("Enter CIN, or 0 in order not to change");
        String  cin = sc.nextLine();
        if (!fname.equals("0"))
            student.setFname(fname);
        if (!lname.equals("0"))
            student.setLname(lname);
        if (!cin.equals("0"))
            student.setCin(cin);
        if (!path.equals("0"))
            student.setStudyPath(path);
    }
}
