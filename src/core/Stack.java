package core;

/**
 * Professional Stack implementation using our custom DLL.
 */
public class Stack<T> {
    private DLL<T> list = new DLL<>();

    public void push(T data) { list.addFirst(data); }
    public T pop() { return list.removeFirst(); }
    public T peek() { 
        T data = list.removeFirst();
        list.addFirst(data);
        return data;
    }
    public boolean isEmpty() { return list.isEmpty(); }
    public int size() { return list.size(); }

    @Override
    public String toString() { return list.toString(); }
}
