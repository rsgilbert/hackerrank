package hackerrank.datastructures.stack;

import java.util.*;
import java.util.stream.Collectors;

public class TwoStacksGame {

    static void reverseFillStack(Stack<Integer> stack, int[] items) {
        for (int idx = items.length - 1; idx >= 0; idx--) {
            stack.push(items[idx]);
        }
    }

    static int twoStacks(int limit, int[] array1, int[] array2) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        int sum1 = 0;
        int sum2 = 0;

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        reverseFillStack(stack1, array1);
        reverseFillStack(stack2, array2);

        while(!stack1.isEmpty() && sum1 <= limit) {
            System.out.println("Ran 1");
            int stackItem = stack1.pop();
            sum1 += stackItem;
            if(sum1 <= limit) {
                max1 = Math.max(stackItem, max1);
            }
        }

        while(!stack2.isEmpty() && sum2 <= limit) {
            System.out.println("Ran 2");
            int stackItem = stack2.pop();
            sum2 += stackItem;
            if(sum2 <= limit) {
                max2 = Math.max(stackItem, max2);
            }
        }

        return Math.max(max1, max2);
    }


    public static void main(String[] args) {
        int max = twoStacks(10, new int[]{2, 1, 10, 1 , 1 , 8}, new int[]{4, 2, 4, 6, 1});
        System.out.println(max);

    }
}

