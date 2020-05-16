package me.ivik.huffmanalgorithm.tree;

import java.util.Comparator;

public class MyNumber implements Comparable<MyNumber> {
    public final int value;

    public MyNumber(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(MyNumber o) {
        return value - o.value;
    }

    @Override
    public String toString() {
        return "MyNumber{" +
                "value=" + value +
                '}';
    }
}
