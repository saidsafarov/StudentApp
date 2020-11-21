package util;

import StudentManagmentApp.Student;

import java.util.Scanner;

public class InputUtil {

    public static String requireText(String title) {
        Scanner sc = new Scanner(System.in);
        System.out.println(title);
        String answer = sc.nextLine();
        return answer;
    }

    public static int requireNumber(String title) {
        Scanner sc = new Scanner(System.in);
        System.out.println(title);
        int answer = sc.nextInt();
        return answer;

    }
    public static Student fill() {
        String name = InputUtil.requireText("type name");
        String surname = InputUtil.requireText("type surname");
        int age = InputUtil.requireNumber("type age");
        String className = InputUtil.requireText("type classname");
        Student st = new Student(name, surname, age, className);
        return st;
    }



}
