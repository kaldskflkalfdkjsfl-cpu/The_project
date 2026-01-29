package advanced;

import java.util.ArrayList;

/**
 * Professional Min-Heap Implementation.
 */
public class MinHeap<T extends Comparable<T>> {
    private ArrayList<T> heap = new ArrayList<>();

    public void insert(T data) {
        heap.add(data);
        int current = heap.size() - 1;
        while (current > 0) {
            int parent = (current - 1) / 2;
            if (heap.get(current).compareTo(heap.get(parent)) < 0) {
                swap(current, parent);
                current = parent;
            } else break;
        }
    }

    public T removeMin() {
        if (heap.isEmpty()) return null;
        T min = heap.get(0);
        T last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapify(0);
        }
        return min;
    }

    private void heapify(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int smallest = index;

        if (left < heap.size() && heap.get(left).compareTo(heap.get(smallest)) < 0)
            smallest = left;
        if (right < heap.size() && heap.get(right).compareTo(heap.get(smallest)) < 0)
            smallest = right;

        if (smallest != index) {
            swap(index, smallest);
            heapify(smallest);
        }
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    @Override
    public String toString() { return heap.toString(); }
}
