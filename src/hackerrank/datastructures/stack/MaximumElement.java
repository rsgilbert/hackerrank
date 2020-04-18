package hackerrank.datastructures.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

public class MaximumElement {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numberOfQueries = Integer.parseInt(scanner.nextLine().trim());
        Deque<Integer> stack = new ArrayDeque<>();
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < numberOfQueries; i++) {
            String query = scanner.nextLine().trim();
            switch(query) {
                // pop
                case "2": {
                    int item = stack.pop();
                    if(item == max) {
                        max = Integer.MIN_VALUE;
                        for(int stackItem: stack) {
                            max = Math.max(max, stackItem);
                        }
                    }
                    break;
                }
                // print maximum
                case "3": {
                    System.out.println(max);
                    break;
                }
                default: {
                    // push
                    int item = Integer.parseInt(query.split("\\s")[1]);
                    max = Math.max(item, max);
                    stack.push(item);
                }
            }
        }
    }
}
