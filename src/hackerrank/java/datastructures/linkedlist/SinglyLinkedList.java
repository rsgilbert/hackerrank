package hackerrank.java.datastructures.linkedlist;

public class SinglyLinkedList<T> {
    public Node<T> head;
    public Node<T> tail;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insert(T data) {
        Node<T> node = new Node<>(data);
        if(this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }

    }
}

class Node<T> {
    public T data;
    public Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}