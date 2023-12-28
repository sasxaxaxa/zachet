package ex9.cepochki;

import java.util.LinkedList;

public class HashTable<K, V> {
    private static final int SIZE = 10;
    private LinkedList<Entry<K, V>>[] table;

    public HashTable() {
        table = new LinkedList[SIZE];
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = getOrCreateBucket(index);

        Entry<K, V> entry = getEntry(key, bucket);
        if (entry != null) {
            entry.setValue(value);
        } else {
            bucket.add(new Entry<>(key, value));
        }
    }

    public V get(K key) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = getBucket(index);

        Entry<K, V> entry = getEntry(key, bucket);
        return (entry != null) ? entry.getValue() : null;
    }

    public void remove(K key) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = getBucket(index);

        Entry<K, V> entry = getEntry(key, bucket);
        if (entry != null) {
            bucket.remove(entry);
        }
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode() % SIZE);
    }

    private LinkedList<Entry<K, V>> getBucket(int index) {
        return table[index];
    }

    private LinkedList<Entry<K, V>> getOrCreateBucket(int index) {
        LinkedList<Entry<K, V>> bucket = table[index];
        if (bucket == null) {
            bucket = new LinkedList<>();
            table[index] = bucket;
        }
        return bucket;
    }

    private Entry<K, V> getEntry(K key, LinkedList<Entry<K, V>> bucket) {
        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                return entry;
            }
        }
        return null;
    }

    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}