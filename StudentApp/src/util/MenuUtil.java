package util;

import StudentManagmentApp.Config;
import StudentManagmentApp.Student;

import java.util.Scanner;

public class MenuUtil {

    public static void printAllStudents() {
        System.out.print("Students that you have registered:");
        if (Config.student == null) {
            System.out.println("No Student to print");
            return;
        }
        for (int i = 0; i < Config.student.length; i++) {
            System.out.println((1 + i) + ".Student");
            Student st = Config.student[i];
            System.out.println(st.getInfo());
        }
    }

    public static void Registration() {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many Student will you register");
        int number = sc.nextInt();
        Config.student = new Student[number];
        for (int i = 0; i < number; i++) {
            System.out.println((1 + i) + ". Registration");
            Student st = InputUtil.fill();
            Config.student[i] = st;
        }
        System.out.println("Registration completed successfully...");
        MenuUtil.printAllStudents();
    }

    public static void Update() {
        MenuUtil.printAllStudents();
        int d = InputUtil.requireNumber("In which Student you want to update ");
        Student st = InputUtil.fill();
        Config.student[d - 1] = st;
        System.out.println(st.getInfo());
    }

    public static void StudentUtil() {

        System.out.println("Please enter your information");
        Student st = InputUtil.fill();
        System.out.println("Welcome " + st.getName() + " " + st.getSurname() + "\nWhat do you want to do");
        while (true) {
            int input = InputUtil.requireNumber("1:Buy course" +
                    "\n2:Create e-mail " +
                    "\n0:Quit");
            if (input == 1) {
                st.setBalance(1000);
                System.out.println("Your balance to buy course:" + st.getBalance());
                int select = InputUtil.requireNumber("Here are the codes and prices for courses:" +
                        "\n1:Development-400" +
                        "\n2:History-200 " +
                        "\n3:Economics-200" +
                        "\n4:Language-200");
                int a = st.getBalance();
                if (select == 1) {
                    System.out.println("You have bought Development course! " +
                            "Your current balance is: " + (a - 400));
                    break;
                } else if (select == 2) {
                    System.out.println("You have bought History course! " +
                            "Your current balance is: " + (a - 200));
                    break;
                } else if (select == 3) {
                    System.out.println("You have bought Economics course! " +
                            "Your current balance is: " + (a - 200));
                    break;
                } else if (select == 4) {
                    System.out.println("You have bought Language course! " +
                            "Your current balance is: " + (a - 200));
                } else {
                    System.out.println("you chose wrong operation ");
                    continue;
                }
            } else if (input == 2) {
                Email email = new Email(st.getName(), st.getSurname());
            } else if (input == 0) {
                System.out.println("Quitting from system...");
                break;
            }
        }
    }

    public static void TeacherUtil() {
        while (true) {
            int menu = InputUtil.requireNumber("What do you want to do" +
                    "\n1:Register student" +
                    "\n2:Show all students" +
                    "\n3:Find student" +
                    "\n4:Update student" +
                    "\n0:To Quit");
            if (menu == 1) {
                MenuUtil.Registration();
            } else if (menu == 2) {
                MenuUtil.printAllStudents();
            } else if (menu == 3) {
                String text = InputUtil.requireText("Enter name or surname that you want to find");
                for (int i = 0; i < Config.student.length; i++) {
                    Student st = Config.student[i];
                    if (st.getName().equalsIgnoreCase(text) || st.getSurname().equalsIgnoreCase(text)) {
                        System.out.println(st.getInfo());
                    }
                }
            } else if (menu == 4) {
                MenuUtil.Update();
            } else if (menu == 0) {
                System.out.println("Quitting from system...");
                return;
            }
        }
    }



}
