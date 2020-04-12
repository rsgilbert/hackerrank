package hackerrank.learning;

public class DifferenceArray {
    /**
     * We construct a new array by replacing each element by the difference between itself and the previous element
     * @param array
     * @return
     */
    public static int[] computeDifferenceArray(int[] array) {
        int[] diffArray = new int[array.length - 1];
        for(int i = 0; i < diffArray.length; i++) {
            diffArray[i] = array[i + 1] - array[i];
        }

        return diffArray;
    }
    public static void main(String[] args) {
        int[] A = new int[] { 9, 2, 6, 3, 1, 5, 0, 7 };
        for(int k: computeDifferenceArray(A)) System.out.print(k + " ");

    }
}
