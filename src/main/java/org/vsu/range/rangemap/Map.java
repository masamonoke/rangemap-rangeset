package org.vsu.range.rangemap;

public interface Map <K extends Comparable<K>, V> {
    V get(K key);
    V put(K key, V value);
    void update(K key, V value);
    V remove(K key);
    boolean isContainsKey(K key);
}
