package com.haibo.yan.algorithm.stack;

/**
 *
 */

class Element<T extends Comparable> {
    T value;

    T min;

    Element next;

    public Element(T value, Element next) {
        this.value = value;

        if (next != null) {
            T nextMin = (T)next.min;
            this.min = nextMin.compareTo(value) < 0 ? nextMin : value;
        } else {
            this.min = value;
        }
        this.next = next;
    }
}

public class MinStack<T extends Comparable>{
    Element<T> top;

    public void push(T value) {
        top = new Element(value, top);
    }

    public T pop() {
        if (top != null) {
            T result = top.value;
            top = top.next;
            return result;
        } else {
            return null;
        }
    }

    public T top() {
        if (top != null) {
            return top.value;
        } else {
            return null;
        }
    }

    public T getMin() {
        return top.min;
    }
}
