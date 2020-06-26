package me.ivik.huffmanalgorithm;


import me.ivik.huffmanalgorithm.bitoperations.BitFileReader;
import me.ivik.huffmanalgorithm.bitoperations.BitFileWriter;
import me.ivik.huffmanalgorithm.tree.Node;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        HuffmanCoding huffmanCoding = new HuffmanCoding("hello");
        System.out.println(huffmanCoding.getTree());
        BitFileWriter writer = new BitFileWriter(new File("/home/ivicek/test.bin"));
        huffmanCoding.writeTree(huffmanCoding.getTree(), writer);
        BitFileReader reader = new BitFileReader(new File("/home/ivicek/test.bin"));
        Node node = huffmanCoding.readTree(reader);
        System.out.println(node);
    }
}
