package org.vsu.range;

public class BSTNode <T> {
    public T value;
    public BSTNode<T> parent;
    public BSTNode<T> left;
    public BSTNode<T> right;

    BSTNode(T value) {
        this.value = value;
        right = null;
        left = null;
    }


    public BSTNode<T> addRight(T value) {
        right = new BSTNode<>(value);
        return right;
    }

    public BSTNode<T> addLeft(T value) {
        left = new BSTNode<>(value);
        return left;
    }
}
