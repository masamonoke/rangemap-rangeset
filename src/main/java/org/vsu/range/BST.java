package org.vsu.range;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Stack;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class BST <T extends Comparable<T>> {
    BSTNode<T> root;
    int size = 0;

    public BST(T value) {
        root = new BSTNode<>(value);
        root.parent = null;
    }

    public T get(T value) {
        if (root == null) {
            return null;
        }
        return getNode(root, value).value;
    }
    private BSTNode<T> getNode(BSTNode<T> node, T value) {
        if (node == null) {
            return null;
        }
        int cmp = node.value.compareTo(value);
        if (cmp == 0) {
            return node;
        } else if (cmp > 0) {
            return getNode(node.left, value);
        } else {
            return getNode(node.right, value);
        }
    }

    public T add(T value) {
        if (root == null) {
            root = new BSTNode<>(value);
            return value;
        }
        root = addRecursive(root, root.parent, value);
        size++;
        return value;
    }
    private BSTNode<T> addRecursive(BSTNode<T> current, BSTNode<T> parent, T value) {
        if (current == null) {
            BSTNode<T> node = new BSTNode<>(value);
            node.parent = parent;
            return node;
        }

        if (value.compareTo(current.value) < 0) {
            current.left = addRecursive(current.left, current, value);
        } else if (value.compareTo(current.value) > 0) {
            current.right = addRecursive(current.right, current, value);
        } else {
            return current;
        }
        return current;
    }

    public T deleteNode(T value) {
        root = deleteNodeRecursive(root, value);
        size--;
        return value;
    }
    private BSTNode<T> deleteNodeRecursive(BSTNode<T> current, T value) {
        if (current == null) {
            return null;
        }

        if (value.equals(current.value)) {
            if (current.left == null && current.right == null) {
                return null;
            }

            if (current.right == null) {
                return current.left;
            }
            if (current.left == null) {
                return current.right;
            }

            T smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteNodeRecursive(current.right, smallestValue);
            return current;
        }

        if (value.compareTo(current.value) < 0) {
            current.left = deleteNodeRecursive(current.left, value);
            return current;
        }

        current.right = deleteNodeRecursive(current.right, value);
        return current;
    }
    private T findSmallestValue(BSTNode<T> root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    public boolean isContainsNode(T value) {
        return isContainsNodeRecursive(root, value);
    }
    private boolean isContainsNodeRecursive(BSTNode<T> current, T value) {
        if (current == null) {
            return false;
        }

        if (value.equals(current.value)) {
            return true;
        }

        return value.compareTo(current.value) < 0 ?
                isContainsNodeRecursive(current.left, value) : isContainsNodeRecursive(current.right, value);
    }

    @Override
    public String toString() {
        return bfsToString(root);
    }
    private String bfsToString(BSTNode<T> current) {
        Stack<BSTNode<T>> nodeStack = new Stack<>();
        nodeStack.push(current);
        StringBuilder s = new StringBuilder("{ ");
        while (!nodeStack.isEmpty()) {
            BSTNode<T> node = nodeStack.pop();
            s.append(node.value).append(" ");

            if (node.right != null) {
                nodeStack.push(node.right);
            }
            if (node.left != null) {
                nodeStack.push(node.left);
            }
        }
        s.append("}");
        return s.toString();
    }
}
