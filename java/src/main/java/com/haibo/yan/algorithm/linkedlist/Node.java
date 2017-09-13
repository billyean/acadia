package com.haibo.yan.algorithm.linkedlist;

public class Node<T> {
    public T value;

    public Node<T> next;

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    public Node(T value) {
        this(value, null);
    }

    public Node append(int value) {
        Node node = new Node(value);
        this.next = node;
        return node;
    }
}
