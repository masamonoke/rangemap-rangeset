package org.vsu.range.rangemap;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Entry <K extends Comparable<K>, V> implements Comparable<Entry<K, V>>{
    K key;
    V value;


    @Override
    public int compareTo(Entry<K, V> o) {
        return key.compareTo(o.key);
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Entry)) {
            return false;
        }
        return ((Entry<K, V>)o).key.equals(this.key);
    }
}
