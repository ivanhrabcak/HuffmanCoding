package me.ivik.huffmanalgorithm.tree;

public class Node implements Comparable<Node> {
    public Node left;
    public Node right;

    public int frequency;
    public Character character;

    public Node(Node left, Node right, int frequency) {
        this.left = left;
        this.right = right;
        this.frequency = frequency;
    }

    public Node(int frequency, Character character) {
        this.left = left;
        this.right = right;
        this.frequency = frequency;
        this.character = character;
    }

    public boolean isChar() {
        return character != null;
    }

    @Override
    public int compareTo(Node o) {
        return frequency - o.frequency;
    }

    @Override
    public String toString() {
        return "Node{" +
                "left=" + left +
                ", right=" + right +
                ", frequency=" + frequency +
                ", character=" + character +
                '}';
    }
}
