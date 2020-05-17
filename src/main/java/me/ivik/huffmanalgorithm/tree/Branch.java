package me.ivik.huffmanalgorithm.tree;

public class Branch<E> implements Comparable<Branch> {
    private E left;
    private E right;
    private int value;

    public Branch(E left, E right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public E getLeft() {
        return left;
    }

    public void setLeft(E left) {
        this.left = left;
    }

    public E getRight() {
        return right;
    }

    public void setRight(E right) {
        this.right = right;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(Branch o) {
        return value - o.value;
    }
}
