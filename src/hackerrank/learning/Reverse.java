package hackerrank.learning;

import java.util.Arrays;
import java.util.Collections;

public class Reverse {
    public static void main(String[] args) {
        Integer[] r = reverseArrayByStreams(new int[] { 1, 2, 3});
        for(int k : r) System.out.println(k + 10 + " ");
    }

    static int[] reverseArray(int[] a) {
        int[] reversed = new int[a.length];
        for(int i = 0; i < a.length; i++) {
            reversed[i] = a[a.length - 1 - i];
        }
        return reversed;
    }

    static Integer[] reverseArrayByStreams(int[] array) {
        return Arrays.stream(array)
                .boxed()
                .sorted(Collections.reverseOrder())
                .toArray(Integer[]::new);
    }
}
