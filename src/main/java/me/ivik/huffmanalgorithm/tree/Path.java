package me.ivik.huffmanalgorithm.tree;

public class Path {
    private Byte[] path;
    private Branch<Branch> branch = null;
    private Branch<Character> characterBranch = null;

    public Path(Branch<Character> characterBranch, Byte[] path) {
        this.path = path;
        this.characterBranch = characterBranch;
    }

    public Path(Byte[] path, Branch<Branch> branch) {
        this.path = path;
        this.branch = branch;
    }

    private boolean isCharacterBranch() {
        return characterBranch == null;
    }

    private boolean isBranchBranch() { // :D
        return branch == null;
    }

    public Byte[] getPath() {
        return path;
    }

    public void setPath(Byte[] path) {
        this.path = path;
    }

    public Branch<Branch> getBranch() {
        return branch;
    }

    public void setBranch(Branch<Branch> branch) {
        this.branch = branch;
    }

    public Branch<Character> getCharacterBranch() {
        return characterBranch;
    }

    public void setCharacterBranch(Branch<Character> characterBranch) {
        this.characterBranch = characterBranch;
    }
}

