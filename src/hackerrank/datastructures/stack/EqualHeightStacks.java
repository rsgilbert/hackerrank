package hackerrank.datastructures.stack;

import java.util.Arrays;
import java.util.Stack;

public class EqualHeightStacks {
    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();
    static Stack<Integer> stack3 = new Stack<>();



    static void prefixSumFillStack(Stack<Integer> stack, int[] items) {
        for (int idx = items.length - 1; idx >= 0; idx--) {
            if (stack.isEmpty()) {
                stack.push(items[idx]);
            } else {
                stack.push(stack.peek() + items[idx]);
            }
        }
    }


    /*
     * Complete the equalStacks function below.
     */
    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();

        prefixSumFillStack(stack1, h1);
        prefixSumFillStack(stack2, h2);
        prefixSumFillStack(stack3, h3);


        if(stack1.isEmpty() || stack2.isEmpty() || stack3.isEmpty()) return 0;
        int peek1 = stack1.peek();
        int peek2 = stack2.peek();
        int peek3 = stack3.peek();

        while (peek1 != peek2 || peek2 != peek3) {
            while(peek1 < peek2 || peek3 < peek2) {
                stack2.pop();
                if(stack2.isEmpty()) return 0;
                peek2 = stack2.peek();
            }
            while(peek2 < peek1 || peek3 < peek1) {
                stack1.pop();
                if(stack1.isEmpty()) return 0;
                peek1 = stack1.peek();
            }
            while(peek1 < peek3 || peek2 < peek3) {
                stack3.pop();
                if(stack3.isEmpty()) return 0;
                peek3 = stack3.peek();
            }
        }
        return peek1;

    }

    public static void main(String[] args) {
        int[] array1 = new int[]{3, 2, 1, 1, 1};
        int[] array2 = new int[]{3};
        int[] array3 = new int[]{1, 1, 4, 1};


//        prefixSumFillStack(stack1, array1);
//        prefixSumFillStack(stack2, array2);
//        prefixSumFillStack(stack3, array3);
//
//        int peek1 = stack1.peek();
//        int peek2 = stack2.peek();
//        int peek3 = stack3.peek();
//
//        while (peek1 != peek2 && peek2 != peek3) {
//            if(peek1 < peek2) stack2.pop();
//            else if(peek1 < peek3) stack3.pop();
//            else stack1.pop();
//
//            peek1 = stack1.peek();
//            peek2 = stack2.peek();
//            peek3 = stack3.peek();
//        }
        int height = equalStacks(array1, array2, array3);
        System.out.println(height);
    }
}
