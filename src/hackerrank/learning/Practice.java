package hackerrank.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

enum Color {
    RED, GREEN
}

public class Practice {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
//        int nodeCount = Integer.parseInt(sc.nextLine().trim());
//        int[] x = Arrays.stream(sc.nextLine().split("\\s"))
//                .mapToInt(Integer::parseInt)
//                .toArray();
//
//        String bits = "1 0 1 0 0 1 0 1";
//
//        Color[] colors =   Arrays.stream(sc.nextLine().split("\\s"))
//                .map(i -> i.equals("0") ? Color.RED : Color.GREEN)
//                .toArray(Color[]::new);


//        int[] a = new int[] { 11, 2, 3};
//        int b = a[0];
//        a[0] = 20;
//        System.out.println(b);

//        int number = 10;
//        List<List<Integer>> seqList = Stream.<List<Integer>>generate(ArrayList::new)
//                .limit(number)
//                .collect(Collectors.toList());

        int[] a = new int[] { 11, 2, 3};
        int[] b = a.clone();
        a[1] = 32;
//        System.out.println(b[1]);

        System.out.println(-1 % 4);
    }
}