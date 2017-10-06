package com.haibo.yan.algorithm.datastructure;

public class BinaryHeap<T extends Comparable> {
    /**
     * Either it's minimum binary heap or maximum binary heap
     */
    private boolean min;

    private int size;


    private T[] elements = (T[])new Object[64];

    public void addElement(T element) {
        if (size < elements.length) {
            elements[size++] = element;
        }
    }

    public void fix(int i) {
        if (i != 0) {
            int p = (i - 1) >> 1;

            if (elements[i].compareTo(elements[p]) < 0 && min) {

            }

            if (elements[i].compareTo(elements[p]) > 0 && !min) {

            }
        }

    }

}
