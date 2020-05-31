package me.ivik.huffmanalgorithm;

import me.ivik.huffmanalgorithm.tree.Node;

public class Main {
    public static void main(String[] args) {
        HuffmanCoding huffmanCoding = new HuffmanCoding("this is a test");
        Node tree = huffmanCoding.getTree();
        System.out.println(huffmanCoding.getCharacterCodes());
        Byte[] encoded = huffmanCoding.encode();
        String decoded = huffmanCoding.decode(encoded, tree);
        System.out.println(decoded);
    }
}
