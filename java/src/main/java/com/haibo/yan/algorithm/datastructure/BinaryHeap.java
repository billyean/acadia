package com.haibo.yan.algorithm.datastructure;

import java.util.Comparator;
import java.util.HashMap;
import java.util.function.Function;

public class BinaryHeap<K, V extends Comparable<V>> {
    /**
     * Either it's minimum binary heap or maximum binary heap
     */
    private boolean min;

    private int size;

    private K[] elements = (K[])new Object[64];

    private HashMap<K, Integer> indexMap = new HashMap<>();

    private Comparator<K> comparator;

    public BinaryHeap(boolean min, Function<K, V> function) {
        this.min = min;
        this.comparator = Comparator.comparing(function);
    }

    public void addElement(K element) {
        if (size == elements.length) {
            K[] newElements = (K[])new Object[size * 2];
            System.arraycopy(elements, 0, newElements, 0, size * 2);
            elements = newElements;

        }
        elements[size++] = element;
        indexMap.put(element, size - 1);
        fixUp(size - 1);
    }

    public void fixUp(int i) {
        if (i != 0) {
            int p = (i - 1) >> 1;

            if (comparator.compare(elements[i], elements[p]) < 0 && min ||
                    comparator.compare(elements[i], elements[p]) > 0 && !min) {
                K temp = elements[i];
                elements[i] = elements[p];
                elements[p] = temp;
                indexMap.put(elements[i], i);
                indexMap.put(elements[p], p);
                fixUp(p);
            }
        }
    }

    public void fixDown(int i) {
        if (i < size) {
            int left = (i << 1) + 1, right = (i << 1) + 2;

            if (right < size) {
                if ((comparator.compare(elements[i], elements[left]) > 0
                            || comparator.compare(elements[i], elements[right]) > 0) && min
                        || (comparator.compare(elements[i], elements[left]) < 0
                            || comparator.compare(elements[i], elements[right]) < 0) && !min) {
                    int p = comparator.compare(elements[left], elements[right]) < 0 && min ? left : right;
                    K temp = elements[i];
                    elements[i] = elements[p];
                    elements[p] = temp;
                    indexMap.put(elements[i], i);
                    indexMap.put(elements[p], p);
                    fixDown(p);
                }
            } else if (left < size) {
                if (comparator.compare(elements[i], elements[left]) > 0 && min
                        || comparator.compare(elements[i], elements[left]) < 0 && !min) {
                    K temp = elements[i];
                    elements[i] = elements[left];
                    elements[left] = temp;
                    indexMap.put(elements[i], i);
                    indexMap.put(elements[left], left);
                }
            }
        }
    }

    public boolean contains(K k) {
        return indexMap.containsKey(k);
    }

    public K extract() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }

        K k = elements[0];
        elements[0] = elements[--size];
        elements[size] = null;
        indexMap.remove(k);
        fixDown(0);

        return k;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void increase(K k) {
        int index = indexMap.get(k);

        if (index < size) {
            fixDown(index);
        }
    }

    public void decrease(K k) {
        int index = indexMap.get(k);

        if (index > 0) {
            fixUp(index);
        }
    }
}
