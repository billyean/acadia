package com.haibo.yan.algorithm.datastructure;

public class DoubleLinkedListNode<K, V> {
    K key;

    V value;

    DoubleLinkedListNode<K, V> prev;

    DoubleLinkedListNode<K, V> next;

    public DoubleLinkedListNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
