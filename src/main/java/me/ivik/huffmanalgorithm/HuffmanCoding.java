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

    private int countDifferentCharacters() {
        int counter = 0;
        for (int characterFrequency : charFrequency) {
            if (characterFrequency != 0) {
                counter++;
            }
        }
        return counter;
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
        return output.toString();
    }

    public void printTree(Node tree) {
        // 19
        // C: 19, Queue = [9, 10]
        // C: 10, Queue = [9]
        // C: 9,  Queue = [4, 5]
        // C: 5,  Queue = [2, 3, 4]
        // C: 4,  Queue = [2, 3]
        // C: 3,  Queue = [1, 2, 2]

        // 19
        // C: 19, Stack = [9, 10]
        // C: 9,  Stack = [4, 5, 10]
        // C: 4,  Stack = [5, 10]
        // C: 5,  Stack = [2, 3, 10]
        // C: 2,  Stack = [3, 10]
        // C: 3,  Stack = [1, 2, 10]
        // C: 1,  Stack = [2, 10]
        // C: 2,  Stack = [10]
        // C:


        Queue<Node> queue = new LinkedList<>();
        queue.add(tree);
        while (queue.size() != 0) {
            Node currentNode = queue.poll();
            System.out.println("At: " + currentNode.frequency);
            if (currentNode.left != null)
                queue.add(currentNode.left);
            if (currentNode.right != null)
                queue.add(currentNode.right);

            // if (currentNode.isChar())
            //     System.out.println(currentNode.character.toString());
        }

        // System.out.println("At: " + tree.frequency);
        // if (tree.isChar())
        //     System.out.printf(tree.character.toString());
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

