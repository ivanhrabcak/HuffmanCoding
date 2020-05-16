package me.ivik.huffmanalgorithm.tree;

public class CharacterOrBranch implements Comparable<CharacterOrBranch> {
    private Branch branch = null;
    private Character character = null;
    private int priority;

    public CharacterOrBranch(Branch branch, int priority) {
        this.branch = branch;
        this.priority = priority;
    }

    public CharacterOrBranch(char character, int priority) {
        this.character = character;
        this.priority = priority;
    }

    public boolean isBranch() {
        return branch == null;
    }

    public boolean isCharacter() {
        return character == null;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public int compareTo(CharacterOrBranch o) {
        return o.getPriority() - priority;
    }

    @Override
    public String toString() {
        return "CharacterOrBranch{" +
                "character=" + character +
                ", priority=" + priority +
                '}';
    }


}
