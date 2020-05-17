package me.ivik.huffmanalgorithm.tree;

public class Character implements Comparable<Character> {
    private char value;
    private int frequency;

    public Character(char value, int frequency) {
        this.value = value;
        this.frequency = frequency;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public int compareTo(Character o) {
        return frequency - o.getFrequency();
    }

    @Override
    public String toString() {
        return "Character{" +
                "value=" + value +
                ", frequency=" + frequency +
                '}';
    }
}
