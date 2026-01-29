package core;

/**
 * Professional Circular Linked List (CLL).
 */
public class CircularLL<T> {
    private class Node {
        T data;
        Node next;
        Node(T data) { this.data = data; }
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public void add(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        size++;
    }

    public void display() {
        if (head == null) return;
        Node curr = head;
        do {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        } while (curr != head);
        System.out.println("(Head)");
    }

    public int size() { return size; }

    @Override
    public String toString() {
        if (head == null) return "[]";
        StringBuilder sb = new StringBuilder("[");
        Node curr = head;
        do {
            sb.append(curr.data).append(" -> ");
            curr = curr.next;
        } while (curr != head);
        return sb.append("(Head)]").toString();
    }
}
