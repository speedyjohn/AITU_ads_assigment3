package org.example.utils.interfaces;

public interface MyBSTInterface<K extends Comparable<K>, V> extends Iterable<K> {
    void put(K key, V value);
    V get(K key);
    void delete(K key);
    void inOrder();
    int getSize();
}