package core;

/**
 * Professional Singly Linked List (SLL).
 */
public class SLL<T> {
    private class Node {
        T data;
        Node next;
        Node(T data) { this.data = data; }
    }

    private Node head;
    private int size = 0;

    public void addFirst(T data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null) curr = curr.next;
            curr.next = newNode;
        }
        size++;
    }

    public T removeFirst() {
        if (head == null) return null;
        T data = head.data;
        head = head.next;
        size--;
        return data;
    }

    public boolean contains(T data) {
        Node curr = head;
        while (curr != null) {
            if (curr.data.equals(data)) return true;
            curr = curr.next;
        }
        return false;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node curr = head;
        while (curr != null) {
            sb.append(curr.data).append(curr.next != null ? " -> " : "");
            curr = curr.next;
        }
        return sb.append("]").toString();
    }
}
