package hackerrank.datastructures.stack;

import java.util.*;

public class PoisonousPlants {
    static void reverseFillStack(Stack<Integer> stack, int[] items) {
        for (int idx = items.length - 1; idx >= 0; idx--) {
            stack.push(items[idx]);
        }
    }

    static void fillDequeList(List<Deque<Integer>> dequeList, int[] items) {
        for(int item: items) {
            if(dequeList.isEmpty()) {
                Deque<Integer> deque = new ArrayDeque<>();
                deque.addFirst(item);
                dequeList.add(deque);
            }
            else {
                Deque<Integer> lastDeque = dequeList.get(dequeList.size() - 1);
                if(lastDeque.peekLast() != null && lastDeque.peekLast() >= item) {
                    lastDeque.addLast(item);
                } else {
                    lastDeque = new ArrayDeque<>();
                    lastDeque.addFirst(item);
                    dequeList.add(lastDeque);
                }
            }
        }
    }

    static int poisonousPlants(int[] plants) {
        int days = 0;
        List<Deque<Integer>> dequeList = new ArrayList<>();
        fillDequeList(dequeList, plants);
        System.out.println(dequeList);

        for(int idx = 1; idx <= dequeList.size() - 1; idx ++) {
            dequeList.get(idx).removeFirst();
            days++;
            Deque<Integer> currentDeque = dequeList.get(idx);
            Deque<Integer> leftDeque = dequeList.get(idx - 1);
            System.out.println(currentDeque.peek() + " LEFT " + leftDeque.peek());

        }

        for(int idx = 1; idx <= dequeList.size() - 1; idx ++) {
            Deque<Integer> currentDeque = dequeList.get(idx);
            Deque<Integer> leftDeque = dequeList.get(idx - 1);
            if(currentDeque.isEmpty() ||
                    (leftDeque.peekLast() != null && currentDeque.peekLast() != null && leftDeque.peekLast() >= currentDeque.peekFirst())) {
                leftDeque.addAll(currentDeque);
                dequeList.remove(idx);
            }
            System.out.println(currentDeque.peek() + " LEFT " + leftDeque.peek());

        }


        return days;
    }

    public static void main(String[] args) {
        int[] plants = new int[] { 6, 5, 8, 4, 7, 10, 9 };
        int[] plants2 = new int[] { 3, 6, 2, 7, 5 };
        System.out.println(poisonousPlants(plants));
        System.out.println(poisonousPlants(plants2));
    }
}
