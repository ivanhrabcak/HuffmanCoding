package me.ivik.huffmanalgorithm;

import me.ivik.huffmanalgorithm.tree.Node;

import java.util.*;

public class HuffmanCoding {
    public final String s;
    private final int[] charFrequency = new int[28]; // 0-25 letters; 26 - space; 27 - ,
    private PriorityQueue<Character> characters = new PriorityQueue<>();
    private PriorityQueue<Node> priorityQueue = new PriorityQueue<>();

    private Map<Character, String> characterCodes = new HashMap<>();

    private Node tree;

    public HuffmanCoding(String s) {
        this.s = s;
        createCharFrequencyArray();
    }

    private <E> Stack<E> asStack(E[] array) {
        Stack<E> output = new Stack<>();
        for (E element : array) {
            output.push(element);
        }
        return output;
    }

    public String decode(Byte[] input, Node tree) {
        Stack<Byte> encoded = asStack(input);
        Node currentNode = tree;
        String output = "";
        while (encoded.size() != 0) {
            if (encoded.peek() == 1) {
                currentNode = currentNode.left;
                if (currentNode.isChar()) {
                    output = output + currentNode.character;
                    currentNode = tree;
                }
                encoded.pop();
            }
            else {
                currentNode = currentNode.right;
                if (currentNode.isChar()) {
                    output = output + currentNode.character;
                    currentNode = tree;
                }
                encoded.pop();
            }
        }
        return output;
    }

    public Map<Character, String> getCharacterCodes() {
        createCharacterCodes(getTree(), "");
        return characterCodes;
    }

    public void createCharacterCodes(Node tree, String currentPath) {
        if (tree.isChar()) {
            characterCodes.put(tree.character, currentPath);
            System.out.println(currentPath);
            return;
        }
        System.out.println(currentPath);
        createCharacterCodes(tree.right, currentPath + "1");
        System.out.println(currentPath);
        createCharacterCodes(tree.left, currentPath + "0");
        System.out.println(currentPath);
    }

    public void appendByteStringToList(String byteString, List<Byte> arrayList) {
        for (int i = 0; i < byteString.length(); i++) {
            byte currentByte = Byte.parseByte(String.valueOf(byteString.charAt(i))); // :/
            arrayList.add(currentByte);
        }
    }

    public Byte[] encode() {
        List<Byte> encodedString = new ArrayList<>();
        createCharacterCodes(getTree(), "");
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            appendByteStringToList(characterCodes.get(currentChar), encodedString);
        }
        Byte[] output = new Byte[encodedString.size()];
        encodedString.toArray(output);
        return output;
    }

    public Node getTree() {
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
            priorityQueue.add(new Node(charFrequency[i], currentChar));
        }

        while (priorityQueue.size() != 1) {
            Node leastFrequent = priorityQueue.poll();
            Node secondLeastFrequent = priorityQueue.poll();

            // if (leastFrequent.isChar() && secondLeastFrequent.isChar()) {
            Node joinedNode = new Node(leastFrequent, secondLeastFrequent, leastFrequent.frequency + secondLeastFrequent.frequency);
            priorityQueue.add(joinedNode);

            // }
        }

        return priorityQueue.poll();
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

