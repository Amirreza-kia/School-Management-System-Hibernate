package ir.maktabsharif.util;

import ir.maktabsharif.model.model.Student;

import java.util.ArrayList;
import java.util.List;

public class Printer {
    public static void printItem(String[] menuItem) {
        System.out.println("\u001B[34m" + "🔥--------------------🔥");
        for (int i = 0; i < menuItem.length; i++) {
            System.out.printf("\u001B[34m" + "%d )☠️ %s \n", (i + 1), menuItem[i]);
        }
        System.out.println("\u001B[34m" + "🔥--------------------🔥");
    }
    public static void printStudentItem() {
        List<Student> studentList = new ArrayList<>();

        String leftAlignFormat = "| %-15s | %-4d |%n";
        System.out.format("+-----------------+------+%n");
        System.out.format("| Column name     | ID   |%n");
        System.out.format("+-----------------+------+%n");
        for (Student student : studentList) {
            System.out.println(student);
        }
        for (int i = 0; i < 5; i++) {
            System.out.format(leftAlignFormat, "some data" + i, i * i);
        }
        System.out.format("+-----------------+------+%n");
    }
}
