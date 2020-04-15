package hackerrank.datastructures.disjointsets;

import hackerrank.util.DisjointSet;
import hackerrank.util.IntegerDisjointSet;

import java.util.Scanner;

public class GraphComponents {
    static int[] componentsInGraph(int[][] gb) {
        int componentsCount = gb.length * 2;
        IntegerDisjointSet components = new IntegerDisjointSet(componentsCount);
        for(int[] node : gb)  {
            System.out.println(node[0] + " X " + node[1]);
            components.union(node[0] - 1, node[1] - 1);
        }
        int MAX = Integer.MIN_VALUE;
        int MIN = Integer.MAX_VALUE;
        for(int i = 0; i < componentsCount; i++) {
            int size = components.getSize(i);
            MAX = Math.max(MAX, size);
            if(size >= 2) {
                MIN = Math.min(MIN, size);
            }
        }
        return new int[] { MIN, MAX };

    }

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] gb = new int[n][2];

        for (int gbRowItr = 0; gbRowItr < n; gbRowItr++) {
            String[] gbRowItems = scanner.nextLine().split(" ");

            for (int gbColumnItr = 0; gbColumnItr < 2; gbColumnItr++) {
                int gbItem = Integer.parseInt(gbRowItems[gbColumnItr].trim());
                gb[gbRowItr][gbColumnItr] = gbItem;
            }
        }

        int[] result = componentsInGraph(gb);

        for (int SPACEItr = 0; SPACEItr < result.length; SPACEItr++) {
            System.out.print(String.valueOf(result[SPACEItr]));

            if (SPACEItr != result.length - 1) {
                System.out.print(" ");
            }
        }
    }


}
/*
5
1 6
2 7
3 8
4 9
2 9

 */