package com.haibo.yan.algorithm;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class IterableIterator<E> implements Iterator<E> {
    private Stack<Iterator> iterators = new Stack();

    private E next;

    public IterableIterator(Iterable iterable) {
        iterators.push(iterable.iterator());
        ascend();
    }

    @Override
    public boolean hasNext() {
        return !iterators.isEmpty();
    }

    @Override
    public E next() {
        if (next == null) {
            throw new NoSuchElementException();
        }
        E element = next;
        ascend();
        return element;
    }

    public void ascend() {
        while (!iterators.isEmpty() && !iterators.peek().hasNext()) {
            iterators.pop();
        }

        if (!iterators.isEmpty()) {
            Object n = iterators.peek().next();
            if (n instanceof Iterable) {
                Iterator c = ((Iterable)n).iterator();
                iterators.push(c);
                ascend();
            } else {
                next = (E) n;
            }
        }
    }
}
