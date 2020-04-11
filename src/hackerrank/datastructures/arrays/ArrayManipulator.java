package hackerrank.datastructures.arrays;

import java.util.*;

public class ArrayManipulator {
    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[]... queries) {
        long max = 0;

        List<Integer> itemsArray = new ArrayList<>();
        for (int[] query : queries) {
            int startIdx = query[0] - 1;
            int endIdx = query[1] - 1;
            itemsArray.add(startIdx);
            itemsArray.add(endIdx);
        }

        Integer[] originalItems = itemsArray.stream()
                .distinct()
                .sorted()
                .toArray(Integer[]::new);

        Map<Integer, Integer> originalMap = new HashMap<>();
        for (int i = 0; i < originalItems.length; i++) {
            originalMap.put(originalItems[i], i);
        }

        List<int[]> newQueries = new ArrayList<>();
        for (int[] query : queries) {
            int startIdx = query[0] - 1;
            int endIdx = query[1] - 1;
            int k = query[2];

            int newStartIdx = originalMap.get(startIdx);
            int newEndIdx = originalMap.get(endIdx);

            int[] newQuery = new int[]{newStartIdx, newEndIdx, k};
            newQueries.add(newQuery);
        }

        long[] accumulator = new long[originalItems.length];
        for (int[] query : newQueries) {
            int startIdx = query[0];
            int endIdx = query[1];
            long k = query[2];

            for (int i = startIdx; i <= endIdx; i++) {
                accumulator[i] += k;
            }

//            for (long j : accumulator) System.out.print(j + " ");
//            System.out.println();
        }

        max = Arrays.stream(accumulator).reduce(max, Math::max);
        return max;
    }

    public static void main(String[] args) {
        int[][] queries = new int[][]{
                new int[]{1, 5, 3},
                new int[]{4, 8, 7},
                new int[]{6, 9, 1}
        };

        System.out.println(arrayManipulation(10, queries));
    }


}
