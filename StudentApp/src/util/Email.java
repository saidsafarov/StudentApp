package util;

import java.util.Scanner;

class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int defaultPasswordLength = 10;
    private String facultySufix = ".com";
    private String setDepartment() {
        System.out.println("Please choose in which faculty you study.Here is the codes for each faculties..");
        String strDep =
                "1:Historical\n" +
                        "2:Geography\n" +
                        "3:Engineering\n" +
                        "4:Economics\n" +
                        "5:Classics";

        System.out.println(strDep);
        Scanner sc = new Scanner(System.in);
        int intDep = sc.nextInt();
        if (intDep == 1) {
            return "historical";
        } else if (intDep == 2) {
            return "geography";
        } else if (intDep == 3) {
            return "engineering";
        } else if (intDep == 4) {
            return "economics";
        } else if (intDep == 5) {
            return "classics";
        } else {
            return "";
        }
    }

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = setDepartment();
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your Password: " + this.password);

        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + this.department + facultySufix;
        System.out.println("Your Email: " + email);
    }




    public String randomPassword(int num) {
        String passwordSet = "PA246842826AP";
        char password[] = new char[10];
        for (int i = 0; i < num; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }
}
