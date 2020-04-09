package hackerrank.java.learning;

import java.util.Arrays;
import java.util.Scanner;

enum Color {
    RED, GREEN
}

public class Practice {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
//        int nodeCount = Integer.parseInt(sc.nextLine().trim());
        int[] x = Arrays.stream(sc.nextLine().split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String bits = "1 0 1 0 0 1 0 1";

        Color[] colors =  Arrays.stream(sc.nextLine().split("\\s"))
                .map(i -> i.equals("0") ? Color.RED : Color.GREEN)
                .toArray(Color[]::new);


    }
}