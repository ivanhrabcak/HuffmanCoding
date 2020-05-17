package me.ivik.huffmanalgorithm;

import com.sun.source.tree.Tree;
import me.ivik.huffmanalgorithm.tree.Branch;
import me.ivik.huffmanalgorithm.tree.Character;

import java.util.*;

public class HuffmanCoding {
    public final String s;
    private final int[] charFrequency = new int[28]; // 0-25 letters; 26 - space; 27 - ,
    private PriorityQueue<Character> characters = new PriorityQueue<>();
    private PriorityQueue<Branch> branches = new PriorityQueue<>();

    private Map<java.lang.Character, List<Byte>> characterCodes = new HashMap<>();

    public HuffmanCoding(String s) {
        this.s = s;
        createCharFrequencyArray();
    }

    private int countDifferentCharacters() {
        int counter = 0;
        for (int characterFrequency : charFrequency) {
            if (characterFrequency != 0) {
                counter++;
            }
        }
        return counter;
    }

    private void createCharacterCodes(Branch tree) {

    }

    public byte[] encode() {
        Branch tree = getTree();
        createCharacterCodes(tree);
        return null;
    }

//    private <E> E removeLastElement(PriorityQueue<E> priorityQueue) { // FIXME
//        PriorityQueue<E> storage = new PriorityQueue<>();
//        E removedElement = null;
//        int originalSize = priorityQueue.size();
//        for (int i = 0; i < originalSize; i++) {
//            if (i != originalSize - 1) {
//                storage.add(priorityQueue.poll());
//            }
//            else {
//                removedElement = priorityQueue.poll();
//            }
//        }
//        for (int i = 0; i < storage.size(); i++) {
//            priorityQueue.add(storage.poll());
//        }
//
//        return removedElement;
//    }

    public Branch getTree() {
        for (int i = 0; i < charFrequency.length; i++) {
            if (charFrequency[i] == 0) {
                continue;
            }
            char currentChar = (char) ('a' + i);
            if (i == 26) {
                currentChar = ' ';
            }
            else if (i == 27) {
                currentChar = ',';
            }
            Character character = new Character(currentChar, charFrequency[i]);
            characters.add(character);
        }
        if (characters.size() == 1 || characters.size() == 2) {
            Character left = characters.poll();
            Character right = characters.poll();
            if (right != null) {
                branches.add(new Branch<Character>(left, right, left.getFrequency() + right.getFrequency()));
            }
            else {
                branches.add(new Branch<Character>(left, null, left.getFrequency()));
            }
        }
        while (!characters.isEmpty()) {
            Character leastFrequent = characters.poll();
            if (characters.isEmpty()) {
                Branch allBranches = branches.poll();
                int value = allBranches.getValue() + leastFrequent.getFrequency();

                Branch<Comparable> branch = new Branch<>(allBranches, leastFrequent, value);
                return branch;
            }
            Character secondLeastFrequent =  characters.poll();
            int value = leastFrequent.getFrequency() + secondLeastFrequent.getFrequency();
            Branch<Character> branch = new Branch<>(leastFrequent, secondLeastFrequent, value);
            branches.add(branch);

            if (branches.isEmpty() || branches.size() == 1) {
                continue;
            }

            Branch smallestBranch = branches.poll();
            Branch secondSmallestBranch = branches.poll();
            value = smallestBranch.getValue() + secondSmallestBranch.getValue();
            Branch<Branch> joinedBranch = new Branch<>(smallestBranch, secondSmallestBranch, value);
            branches.add(joinedBranch);
        }
        return branches.poll();
    }

    private void createCharFrequencyArray() {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                charFrequency[26]++;
                continue;
            }
            else if (s.charAt(i) == ',') {
                charFrequency[27]++;
                continue;
            }
            charFrequency[s.charAt(i) - 'a']++;
        }

    }
}

