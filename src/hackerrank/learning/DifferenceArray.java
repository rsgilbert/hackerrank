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
        endIdx ++;

        return prefixSumArray[endIdx] - prefixSumArray[startIdx];
    }


    public static void main(String[] args) {
        int[] A = new int[]{9, 2, 6, 3, 7, 5, 0, 7};
        int[] diffArray = computeDifferenceArray(A);
        int[] prefixSumArray = computePrefixSumArray(0, A);

        for (int k : diffArray) System.out.print(k + " ");
        System.out.println();

        for (int k : prefixSumArray) System.out.print(k + " ");
        System.out.println();

        int[] cancelOut1 = computeDifferenceArray(computePrefixSumArray(3, A));
        for (int k : cancelOut1) System.out.print(k + " ");
        System.out.println();

        int sumBetweenPositions = computeSumBetweenPositions(A, 1, 3);
        System.out.println(sumBetweenPositions);

    }
}
