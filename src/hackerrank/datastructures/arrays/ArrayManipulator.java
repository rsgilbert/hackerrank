package hackerrank.datastructures.arrays;

import kotlin.reflect.jvm.internal.impl.types.DisjointKeysUnionTypeSubstitution;

import java.util.*;

public class ArrayManipulator {
    /**
     * We construct a new array by replacing each element by the difference between itself and the previous element
     *
     * @param array
     * @return int[]
     */
    public static long[] computeDifferenceArray(long[] array) {
        long[] diffArray = new long[array.length - 1];
        for (int i = 0; i < diffArray.length; i++) {
            diffArray[i] = array[i + 1] - array[i];
        }

        return diffArray;
    }

    /**
     * we first append c onto the front of the array, and then replace each element with the sum of itself and all the elements preceding it.
     */
    public static long[] computePrefixSumArray(int c, long[] array) {
        long[] prefixArray = new long[array.length + 1];
        prefixArray[0] = c;
        for (int i = 1; i < prefixArray.length; i++) {
            prefixArray[i] = prefixArray[i - 1] + array[i - 1];
        }
        return prefixArray;
    }

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[]... queries) {
        // We use n + 2 when creating itemsArray so as to convert to 1-based-indexing
        long[] itemsArray = new long[n + 1];
        long[] diffArray = computeDifferenceArray(itemsArray);

        for (int[] query : queries) {
            int startIdx = query[0];
            int endIdx = query[1];

//            if(startIdx >= diffArray.length) startIdx = diffArray.length - 1;
//            if(endIdx >= diffArray.length) endIdx = diffArray.length - 1;
            int update = query[2];

            // We subtract 1 to compensate for the decrease in itemsArray length when creating diffArray
            startIdx--;
//        starting difference goes up because the range values are gaining an increase.

            if(startIdx < diffArray.length) {
                diffArray[startIdx] += update;
            }

            // we do not subtract 1 from endIdx because we are interested in the difference between the
            // last value in the range and the next value after the range.
            // end difference goes down because the difference decreases at the end of the range.
            if (endIdx < diffArray.length) {
                diffArray[endIdx] -= update;
            }
        }
        itemsArray = computePrefixSumArray(0, diffArray);

        printArray(diffArray);
        printArray(itemsArray);
        long max = Long.MIN_VALUE;
        for (long i : itemsArray) {
            max = Math.max(max, i);
        }
        return max;
    }

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        int[][] queries = new int[][]{
//                new int[]{1, 10, 100},
//                new int[]{1, 2, 300},
//                new int[]{10, 10, 700},
//        };

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }


        System.out.println(arrayManipulation(n, queries));

    }

    /**
     * Print the items in the array on a line
     *
     * @param array
     */
    public static void printArray(long[] array) {
        for (long i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
