package hackerrank.java.datastructures;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MyPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(10, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 % 3 - o2 % 3;
            }
        });

        // add
        priorityQueue.add(3);
        priorityQueue.add(8);
        priorityQueue.add(1);
        priorityQueue.add(5);

        System.out.println(priorityQueue.peek());

        System.out.println(priorityQueue.poll());

        System.out.println(priorityQueue.peek());

    }
}
