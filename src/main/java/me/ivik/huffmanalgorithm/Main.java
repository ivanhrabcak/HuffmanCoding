package me.ivik.huffmanalgorithm;

import me.ivik.huffmanalgorithm.tree.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        HuffmanCoding huffmanCoding = new HuffmanCoding("this is a test");
        Node tree = huffmanCoding.getTree();
        Byte[] encoded = huffmanCoding.encode();
        String decoded = huffmanCoding.decode(encoded, tree);
        System.out.println(decoded);
    }
}
