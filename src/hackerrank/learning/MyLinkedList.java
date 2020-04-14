package hackerrank.learning;

import java.util.LinkedList;

public class MyLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(3);
        linkedList.add(2);
        linkedList.addFirst(21);
        linkedList.addLast(62);
        System.out.println(linkedList);
    }
}
