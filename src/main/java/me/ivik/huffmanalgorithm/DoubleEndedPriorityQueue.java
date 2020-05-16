package me.ivik.huffmanalgorithm;

import java.util.*;

public class DoubleEndedPriorityQueue<E> {
    private Set<E> set = new HashSet<>();

    public void add(E object) {
        set.add(object);
    }

    public E removeLast() {
        E value = Collections.max(set, null);
        set.remove(value);
        return value;
    }

    public E removeFirst() {
        E value = Collections.min(set, null);
        set.remove(value);
        return value;
    }

    public E getFirst() {
        return Collections.min(set, null);
    }

    public E getLast() {
        return Collections.max(set, null);
    }

    @Override
    public String toString() {
        return set.toString();
    }
}
