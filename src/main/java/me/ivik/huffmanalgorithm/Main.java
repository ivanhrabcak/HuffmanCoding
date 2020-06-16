package me.ivik.huffmanalgorithm;

import me.ivik.huffmanalgorithm.bitstreams.BitFileReader;
import me.ivik.huffmanalgorithm.bitstreams.BitFileWriter;
import me.ivik.huffmanalgorithm.tree.Node;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        HuffmanCoding huffmanCoding = new HuffmanCoding("this is a test");
        BitFileWriter writer = new BitFileWriter(new File("/home/ivicek/test.bin"));
        huffmanCoding.writeTree(huffmanCoding.getTree(), writer);
        BitFileReader reader = new BitFileReader(new File("/home/ivicek/test.bin"));
        Node node = huffmanCoding.readTree(reader);
        System.out.println(node);
    }
}
