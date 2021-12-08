package org.vsu.range.rangemap;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.vsu.range.BST;
import org.vsu.range.Range;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class RangeMap <K extends Comparable<K>, V> implements Map<Range<K>, V> {
    final BST<Entry<Range<K>, V>> tree = new BST<>();


    @Override
    public V get(Range<K> key) {
        Entry<Range<K>, V> entry = tree.get(new Entry<>(key, null));
        return entry == null ? null : entry.value;
    }

    @Override
    public V put(Range<K> key, V value) {
        Entry<Range<K>, V> entry = tree.add(new Entry<>(key, value));
        return entry == null ? null : entry.value;
    }

    @Override
    public void update(Range<K> key, V value) {
        Entry<Range<K>, V> entry = tree.get(new Entry<>(key, null));
        if (entry != null) {
            entry.value = value;
        }
    }

    @Override
    public V remove(Range<K> key) {
        Entry<Range<K>, V> entry = tree.deleteNode(new Entry<>(key, null));
        return entry == null ? null : entry.value;
    }

    @Override
    public boolean isContainsKey(Range<K> key) {
        return tree.isContainsNode(new Entry<>(key, null));
    }
}
