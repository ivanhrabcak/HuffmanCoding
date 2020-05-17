package me.ivik.huffmanalgorithm;

import me.ivik.huffmanalgorithm.tree.Branch;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        HuffmanCoding huffmanCoding = new HuffmanCoding("aaababbzzccaaazzbbbz");
        PriorityQueue<Branch> priorityQueue = huffmanCoding.getTree();
        System.out.println(priorityQueue);

    }
}
