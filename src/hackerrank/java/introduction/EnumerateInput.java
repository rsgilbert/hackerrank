package hackerrank.java.introduction;

import java.util.Scanner;

public class EnumerateInput {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int count = 1;
        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            System.out.printf("%d %s\n", count, line);
            count++;
        }
    }
}
