package com.haibo.yan.algorithm.datastructure;


public class DoubleLinkedList<K, V> {
    DoubleLinkedListNode<K, V> head;

    DoubleLinkedListNode<K, V> tail;

    public void append(DoubleLinkedListNode<K, V> node) {
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            node.next = null;
            tail = node;
        }
    }

    public void remove(DoubleLinkedListNode<K, V> node) {

        DoubleLinkedListNode<K, V> prev = node.prev;
        DoubleLinkedListNode<K, V> next = node.next;


        if (null == prev) {
            head = next;
            if (null != head)
                head.prev = null;
        } else {
            prev.next = next;
        }

        if (null == next) {
            tail = prev;
            if (null != tail)
                tail.next = null;
        } else {
            next.prev = prev;
        }
    }
}
