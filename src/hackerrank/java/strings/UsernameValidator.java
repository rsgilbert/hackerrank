package hackerrank.java.strings;

import java.util.Scanner;
class Validation {
    /*
     * Write regular expression here.
     */
    public static final String regularExpression = "[a-zA-Z][\\w_]{7,30}";
}


public class UsernameValidator {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(scan.nextLine());
        while (n-- != 0) {
            String userName = scan.nextLine();

            if (userName.matches(Validation.regularExpression)) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }
        }
    }
}