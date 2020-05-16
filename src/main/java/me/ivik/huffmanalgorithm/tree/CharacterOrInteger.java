package me.ivik.huffmanalgorithm.tree;

public class CharacterOrInteger {
    private Character character = null;
    private Integer integer = null;

    public CharacterOrInteger(Character character) {
        this.character = character;
    }

    public CharacterOrInteger(Integer integer) {
        this.integer = integer;
    }

    public boolean isCharacter() {
        return character == null;
    }

    public boolean isInteger() {
        return integer == null;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        integer = null;
        this.character = character;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        character = null;
        this.integer = integer;
    }
}
