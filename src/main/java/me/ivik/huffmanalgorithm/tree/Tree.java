package me.ivik.huffmanalgorithm.tree;

public class Tree {
    private Branch root;

    public Tree(Branch root) {
        this.root = root;
    }

    public Branch getRoot() {
        return root;
    }

    public void setRoot(Branch root) {
        this.root = root;
    }
}
