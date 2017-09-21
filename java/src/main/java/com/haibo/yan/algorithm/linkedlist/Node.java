package com.haibo.yan.algorithm.linkedlist;

import java.util.Arrays;

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

    public static Node<Integer> deserialize(String string) {
        String[] values = string.split("#");
        if (values.length == 0) {
            return null;
        } else {
            Node<Integer> head = new Node(Integer.parseInt(values[0]));

            Node<Integer> current = head;

            for (String value: Arrays.copyOfRange(values, 1, values.length)) {
                Node<Integer> newNode = new Node(Integer.parseInt(value));
                current.next = newNode;
                current = newNode;
            }

            return head;
        }
    }
}
