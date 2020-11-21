package StudentManagmentApp;

import util.InputUtil;
import util.MenuUtil;


public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the School Operation Center");
        String answer = InputUtil.requireText("Please tell us are you Student or Teacher?\nAnswer:");
        if (answer.equalsIgnoreCase("Teacher")) {
            MenuUtil.TeacherUtil();
        } else if (answer.equalsIgnoreCase("Student")) {
            MenuUtil.StudentUtil();
        }
    }
}
