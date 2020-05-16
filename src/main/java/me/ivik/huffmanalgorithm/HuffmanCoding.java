package me.ivik.huffmanalgorithm;

import me.ivik.huffmanalgorithm.tree.Branch;
import me.ivik.huffmanalgorithm.tree.CharacterOrBranch;
import me.ivik.huffmanalgorithm.tree.CharacterOrInteger;
import me.ivik.huffmanalgorithm.tree.Tree;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class HuffmanCoding {
    private String s;
    private int[] charFrequency = new int[26];
    private DoubleEndedPriorityQueue<CharacterOrBranch> queue = new DoubleEndedPriorityQueue<>();


    private int getLetterFrequency(char letter) {
        return charFrequency[letter - 'a'];
    }

    public int[] getCharFrequency() {
        return charFrequency;
    }

    public Tree getTree() {
        for (int i = 0; i < charFrequency.length; i++) {
            if (charFrequency[i] == 0) {
                continue;
            }
            queue.add(new CharacterOrBranch((char)(((char) i) + 'a'), charFrequency[i]));
        }
        Tree tree = new Tree(new Branch(null, null, null));
        while (queue.getLast().isCharacter()) {
            char leastFrequentCharacter = queue.removeLast().getCharacter();
            if (queue.getLast().isBranch()) {
                // panic?
                return null;
            }
            char secondLeastFrequentCharacter = queue.removeLast().getCharacter();
            // what now?
        }
        return tree;
    }

    private void createCharFrequencyArray() {
        for (int i = 0; i < s.length(); i++) {
            charFrequency[s.charAt(i) - 'a']++;
        }
    }

    public HuffmanCoding(String s) {
        this.s = s;
        createCharFrequencyArray();
    }
}

