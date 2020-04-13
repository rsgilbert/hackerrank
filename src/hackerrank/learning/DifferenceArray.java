package hackerrank.learning;

/*
 Guide: https://wcipeg.com/wiki/Prefix_sum_array_and_difference_array
 */
public class DifferenceArray {
    /**
     * We construct a new array by replacing each element by the difference between itself and the previous element
     *
     * @param array
     * @return
     */
    public static int[] computeDifferenceArray(int[] array) {
        int[] diffArray = new int[array.length - 1];
        for (int i = 0; i < diffArray.length; i++) {
            diffArray[i] = array[i + 1] - array[i];
        }

        return diffArray;
    }

    public static void printArray(int[] array) {
        for(int i: array) System.out.print(i + " ");
        System.out.println();
    }

    /**
     * we first append c onto the front of the array, and then replace each element with the sum of itself and all the elements preceding it.
     */
    public static int[] computePrefixSumArray(int c, int[] array) {
        int[] prefixArray = new int[array.length + 1];
        prefixArray[0] = c;
        for (int i = 1; i < prefixArray.length; i++) {
            prefixArray[i] = prefixArray[i - 1] + array[i - 1];
        }

        return prefixArray;
    }

    public static int computeSumBetweenPositions(int[] array, int startIdx, int endIdx) {
        int[] prefixSumArray = computePrefixSumArray(0, array);
        // recall prefixSumArray has one more item so we must increment endIdx
        // We do not increment startIdx as well because we are subtracting sums before startIdx
        endIdx++;

        return prefixSumArray[endIdx] - prefixSumArray[startIdx];
    }

    /**
     * Problem: Counting Subsequences
     * Given an array of integers S, find the number of contiguous subsequences of the array that sum to 47.
     */
    public static int numberOfContiguousSubsequences(int[] array, int sum) {
        int maxCount = 0;
        int[] prefixSumArray = computePrefixSumArray(0, array);

        for (int i = 1; i < prefixSumArray.length; i++) {
            for (int j = 0; j < i; j++) {
                if (prefixSumArray[i] - prefixSumArray[j] == sum) {
                    maxCount++;
                }
            }
        }
        return maxCount;
    }

    /**
     * Use of difference arrays
     * Updating range
     */
    public static int[] computePlateau(int[] array, int startIdx, int endIdx, int update) {
        int[] diffArray = computeDifferenceArray(array);
//        We substract 1 to compensate for the decrease in array length
        int newStartIdx = startIdx - 1;
//        starting difference goes up because the range values are gaining an increase.
        diffArray[newStartIdx] += update;

        // we do not subtract 1 from endIdx because we are interested in the difference between the
        // last value in the range and the next value after the range.
        // end difference goes down because the difference decreases at the end of the range.
        diffArray[endIdx] -= update;

        return computePrefixSumArray(array[0], diffArray);
    }

    public static void main(String[] args) {
//        int[] A = new int[]{9, 2, 6, 3, 7, 5, 0, 7};
//        int[] diffArray = computeDifferenceArray(A);
//        int[] prefixSumArray = computePrefixSumArray(0, A);
//
//        for (int k : diffArray) System.out.print(k + " ");
//        System.out.println();
//
//        for (int k : prefixSumArray) System.out.print(k + " ");
//        System.out.println();

//        int[] cancelOut1 = computeDifferenceArray(computePrefixSumArray(3, A));
//        for (int k : cancelOut1) System.out.print(k + " ");
//        System.out.println();

//        int sumBetweenPositions = computeSumBetweenPositions(A, 1, 3);
//        System.out.println(sumBetweenPositions);

        // Continuous subsequences
         int[] myArray = new int[] { 9, 5, 6, 3, -3, 3 };
         int numberOfContinuousSubseqs = numberOfContiguousSubsequences(myArray, 9);
        System.out.println("Number of continuous subsequences is " + numberOfContinuousSubseqs);

        int[] plateauArray = computePlateau(myArray, 2, 4, 3);
        System.out.println("Plateau");
        printArray(plateauArray);

        // Calculus
        // Fundamental Theorem of Calculus
        // Integral of D(A) ie P(0, D(A))
//        System.out.println("P(0, D(A))");
//        int[] ftc = computePrefixSumArray(0, diffArray);
//        for (int f : ftc) System.out.print(f + " ");
        System.out.println();
    }
}
