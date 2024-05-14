package org.example.utils.interfaces;

public interface MyHashTableInterface<K, V> {
    void put(K key, V value);
    V get(K key);
    V remove(K key);
    boolean contains(V value);
    K getKey(V value);
}
