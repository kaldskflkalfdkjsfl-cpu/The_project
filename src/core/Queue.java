package core;

import java.util.NoSuchElementException;

/**
 * Professional Queue implementation using our Generic DLL.
 */
public class Queue<T> {
    private DLL<T> list = new DLL<>();

    public void enqueue(T data) {
        list.addLast(data);
    }

    public T dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        return list.removeFirst();
    }

    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        // DLL doesn't have peekFirst, but we can remove and add back or add peek to DLL
        // For simplicity since we have DLL code, let's just use it.
        T data = list.removeFirst();
        list.addFirst(data);
        return data;
    }

    public boolean isEmpty() { return list.isEmpty(); }
    public int size() { return list.size(); }

    @Override
    public String toString() { return list.toString(); }
}
