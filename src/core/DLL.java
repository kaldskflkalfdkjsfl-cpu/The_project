package core;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Highly professional Generic Doubly Linked List with full features.
 */
public class DLL<T> implements Iterable<T> {
    private class Node {
        T data;
        Node next, prev;
        Node(T data) { this.data = data; }
    }

    private Node head, tail;
    private int size = 0;

    public void addLast(T data) {
        Node newNode = new Node(data);
        if (head == null) head = tail = newNode;
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void addFirst(T data) {
        Node newNode = new Node(data);
        if (head == null) head = tail = newNode;
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public T removeFirst() {
        if (head == null) throw new NoSuchElementException();
        T data = head.data;
        head = head.next;
        if (head == null) tail = null;
        else head.prev = null;
        size--;
        return data;
    }

    public T removeLast() {
        if (tail == null) throw new NoSuchElementException();
        T data = tail.data;
        tail = tail.prev;
        if (tail == null) head = null;
        else tail.next = null;
        size--;
        return data;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node curr = head;
            public boolean hasNext() { return curr != null; }
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T data = curr.data;
                curr = curr.next;
                return data;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node curr = head;
        while(curr != null) {
            sb.append(curr.data).append(curr.next != null ? " <-> " : "");
            curr = curr.next;
        }
        return sb.append("]").toString();
    }
}
