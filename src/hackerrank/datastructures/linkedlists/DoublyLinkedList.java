package hackerrank.datastructures.linkedlists;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class DoublyLinkedList {
    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class MyDoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public MyDoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }
            this.tail = node;
        }
    }

    public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    // Complete the sortedInsert function below.

    /*
     * For your reference:
     *
     * DoublyLinkedListNode {
     *     int data;
     *     DoublyLinkedListNode next;
     *     DoublyLinkedListNode prev;
     * }
     *
     */
    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
        if (head == null) return newNode;
        if (head.next == null) {
            if (head.data < data) {
                head.next = newNode;
                return head;
            } else {
                newNode.next = head;
                head.prev = newNode;
                return newNode;
            }
        }
        DoublyLinkedListNode navigator = head;
        DoublyLinkedListNode previous = null;
        while (navigator != null) {
            if (navigator.data >= data) {
                if (navigator.prev == null) {
                    newNode.next = navigator;
                    navigator.prev = newNode;
                    return newNode;
                }
                navigator.prev.next = newNode;
                navigator.prev = newNode;
                newNode.next = navigator;
                newNode.prev = navigator.prev;
                return head;
            }
            previous = navigator;
            navigator = navigator.next;
        }
        previous.next = newNode;
        newNode.prev = previous;
        return head;
    }

    private static final Scanner scanner = new Scanner(System.in);

}