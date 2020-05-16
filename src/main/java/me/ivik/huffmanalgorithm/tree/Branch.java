package me.ivik.huffmanalgorithm.tree;

import java.util.Comparator;

public class Branch {
    private Branch left;
    private Branch right;
    private CharacterOrInteger value;

    public Branch(Branch left, Branch right, CharacterOrInteger value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public Branch getLeft() {
        return left;
    }

    public void setLeft(Branch left) {
        this.left = left;
    }

    public Branch getRight() {
        return right;
    }

    public void setRight(Branch right) {
        this.right = right;
    }

    public CharacterOrInteger getValue() {
        return value;
    }

    public void setValue(CharacterOrInteger value) {
        this.value = value;
    }
}
