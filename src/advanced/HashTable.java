package advanced;

import java.util.LinkedList;

/**
 * Professional Hash Table with Separate Chaining.
 */
public class HashTable<K, V> {
    private static class Entry<K, V> {
        K key;
        V value;
        Entry(K key, V value) { this.key = key; this.value = value; }
    }

    private LinkedList<Entry<K, V>>[] buckets;
    private int capacity = 10;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public HashTable() {
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) buckets[i] = new LinkedList<>();
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        buckets[index].add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = getIndex(key);
        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) return entry.value;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < capacity; i++) {
            for (Entry<K, V> entry : buckets[i]) {
                sb.append(entry.key).append("=").append(entry.value).append(", ");
            }
        }
        if (size > 0) sb.setLength(sb.length() - 2);
        return sb.append("}").toString();
    }
}
