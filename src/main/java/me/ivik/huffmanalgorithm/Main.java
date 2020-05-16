package me.ivik.huffmanalgorithm;

import me.ivik.huffmanalgorithm.tree.CharacterOrBranch;
import me.ivik.huffmanalgorithm.tree.MyNumber;
import me.ivik.huffmanalgorithm.tree.Tree;

public class Main {
    public static void main(String[] args) {
        HuffmanCoding huffmanCoding = new HuffmanCoding("aaababbzzccaaazzbbbz");
        Tree doubleEndedPriorityQueue = huffmanCoding.getTree();

    }
}
