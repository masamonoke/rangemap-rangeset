package org.vsu.range.rangeset;

public interface Set <T> {
    public T add(T value);
    public T delete(T value);
    public boolean isContains(T value);
    int size();
}
