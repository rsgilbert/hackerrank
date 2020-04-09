package hackerrank.learning;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Xor {

    public static void main(String[] args) {

        // XOR Swap Algorithm
//        int a = 10;
//        int b = 10;
//        a = a ^ b;
//        b = b ^ a;
//        a = a ^ b;
//
//        System.out.println(a);
//        System.out.println(b);

        int c = 4; // 100
        int d = 4; // 100
        d ^= c;
//        System.out.println(d);
//        System.out.println(3 ^ 5 ^ 3);
        System.out.println("MISSING: " + missingNo(new int[] { 1, 2, 4}, 4));

    }

    static int missingNo(int[] array, int maxNo) {
        int missingNo = IntStream.rangeClosed(1, maxNo)
                .reduce(0, (a, b) -> a ^ b);

        missingNo = Arrays.stream(array)
                .reduce(missingNo, (a, b) -> a ^ b);

        return missingNo;
    }
}
