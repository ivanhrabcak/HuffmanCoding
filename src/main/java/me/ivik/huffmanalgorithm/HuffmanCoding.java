package me.ivik.huffmanalgorithm;

import me.ivik.huffmanalgorithm.bitoperations.BitFileReader;
import me.ivik.huffmanalgorithm.bitoperations.BitFileWriter;
import me.ivik.huffmanalgorithm.tree.Node;

import java.io.IOException;
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

    private <E> Queue<E> asQueue(E[] array) {
        return new LinkedList<>(Arrays.asList(array));
    }

    public String decode(Byte[] input, Node tree) {
        Queue<Byte> encoded = asQueue(input);
        Node currentNode = tree;
        StringBuilder output = new StringBuilder();
        while (encoded.size() != 0) {
            if (encoded.peek() == 0) {
                currentNode = currentNode.left;
                if (currentNode.isChar()) {
                    output.append(currentNode.character);
                    currentNode = tree;
                }
                encoded.poll();
            }
            else {
                currentNode = currentNode.right;
                if (currentNode.isChar()) {
                    output.append(currentNode.character);
                    currentNode = tree;
                }
                encoded.poll();
            }
        }
        return output.toString();
    }

    public Map<Character, String> getCharacterCodes() {
        createCharacterCodes(getTree(), "");
        return characterCodes;
    }

    public void createCharacterCodes(Node tree, String currentPath) {
        if (tree.isChar()) {
            characterCodes.put(tree.character, currentPath);
            return;
        }
        createCharacterCodes(tree.right, currentPath + "1");
        createCharacterCodes(tree.left, currentPath + "0");
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

    private boolean[] byteToBooleanArray(byte b) { // kinda dumb
        boolean[] output = new boolean[8];
        System.out.println(b);
        for (int i = 0; i < 8; i++) {
            output[i] = (b & (1 << i)) != 0;
        }
        return output;
    }

    public Node readTree(BitFileReader reader) {
        try {
            if (reader.readBit()) {
                int characterNumber = reader.readByte();
                char character;
                if (characterNumber == 26) {
                    character = ' ';
                }
                else if (characterNumber == 27) {
                    character = ',';
                }
                else {
                    character = (char) (characterNumber - 'a');
                }
                return new Node(null, null, character);
            }
            else {
                Node left = readTree(reader);
                Node right = readTree(reader);
                return new Node(left, right, -1);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
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

    public void writeTree(Node node, BitFileWriter writer) {
        writeTreeInternal(node, writer);
        writer.close();
    }

    private void writeTreeInternal(Node node, BitFileWriter writer) {
        byte currentByte;
        if (node.isChar()) {
            if (node.character == ' ') {
                currentByte = 26;
            }
            else if (node.character == ',') {
                currentByte = 27;
            }
            else {
                currentByte = (byte) (node.character - 'a');
            }
            writer.write(true);
            writer.write(byteToBooleanArray(currentByte));
        }
        else {
            writer.write(false);
            writeTree(node.left, writer);
            writeTree(node.right, writer);
        }

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

