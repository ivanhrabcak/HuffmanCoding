package me.ivik.huffmanalgorithm;

import me.ivik.huffmanalgorithm.tree.CharacterOrBranch;
import me.ivik.huffmanalgorithm.tree.MyNumber;

public class Main {
    public static void main(String[] args) {
        HuffmanCoding huffmanCoding = new HuffmanCoding("aaababbzzccaaazzbbbz");
        DoubleEndedPriorityQueue<CharacterOrBranch> doubleEndedPriorityQueue = huffmanCoding.getTree();

    }
}
