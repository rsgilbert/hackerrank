package hackerrank.datastructures.arrays;

import java.util.*;
import java.util.Scanner;
import java.util.stream.IntStream;

public class HourGlass {
    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {

        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length - 2; i++) {
            for(int j = 0; j < arr[0].length - 2; j++) {
                int sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
                maxSum = Math.max(maxSum, sum);
            }

        }
        return maxSum;

    }

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] matrix = IntStream.rangeClosed(1, 6)
                .mapToObj(i -> Arrays.stream(sc.nextLine().split("\\s"))
                        .mapToInt(Integer::parseInt)
                        .toArray())
                .toArray(int[][]::new);

        System.out.println(hourglassSum(matrix));
    }
}
