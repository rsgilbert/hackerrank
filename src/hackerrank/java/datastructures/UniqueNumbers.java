package hackerrank.java.datastructures;

import java.util.*;

public class UniqueNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        int arraySize = in.nextInt();
        int subArraySize = in.nextInt();
        int maxSize = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int position = 0; position < arraySize; position++) {
            int num = in.nextInt();
            deque.offerFirst(num);
            map.merge(num, 1, Integer::sum);
            if (deque.size() == subArraySize) {
                Integer removedNumber = deque.pollLast();
                maxSize = Math.max(map.size(), maxSize);
                if (position != arraySize - 1) {
                    map.merge(removedNumber, 0, (oldV, newV) -> {
                        // remove item if oldV == 0 else decrement value
                        if(oldV == 0) return null;
                        else return oldV - 1;
                    });
                }
            }
        }

        System.out.println(maxSize);
    }
}

/**
 * test values
  6 3
 5 3 5 2 3 2
 * <p>
 6 3
 1 1 1 2 2 2 2
 */
