package com.haibo.yan.algorithm.array;

public class ArrayQueue<T> {
    private T[] array;

    private int head;

    private int tail;

    private boolean empty = true;

    public ArrayQueue(int capacity) {
        array = (T[])new Object[capacity];
    }

    public void pushBack(T element) {
        if (length() == array.length) {
            throw new IndexOutOfBoundsException("Stack is full");
        }

        array[tail++] = element;
        if (tail == array.length) {
            tail = 0;
        }
        empty = false;
    }

    public T head() {
        if (length() == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }

        return array[head];
    }

    public T popFront() {
        if (length() == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }

        T e = array[head++];
        if (head == array.length) {
            head = 0;
        }
        if (head == tail) {
            empty = true;
        }
        return e;
    }

    public int length() {
        if (empty) {
            return 0;
        }
        int m = tail - head;
        if (m <= 0) {
            return m + array.length;
        } else {
            return m;
        }
    }
}
