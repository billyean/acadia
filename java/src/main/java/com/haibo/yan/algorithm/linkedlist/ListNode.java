package com.haibo.yan.algorithm.linkedlist;

import java.io.PrintStream;
import java.util.Arrays;

public class ListNode<T> {
    public T val;

    public ListNode<T> next;

    public ListNode(T val, ListNode<T> next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(T val) {
        this(val, null);
    }

    public ListNode append(int value) {
        ListNode listNode = new ListNode(value);
        this.next = listNode;
        return listNode;
    }

    public static ListNode<Integer> deserialize(String string) {
        String[] values = string.split("#");
        if (values.length == 0) {
            return null;
        } else {
            ListNode<Integer> head = new ListNode(Integer.parseInt(values[0]));

            ListNode<Integer> current = head;

            for (String value: Arrays.copyOfRange(values, 1, values.length)) {
                ListNode<Integer> newListNode = new ListNode(Integer.parseInt(value));
                current.next = newListNode;
                current = newListNode;
            }

            return head;
        }
    }

    public static void print(ListNode<Integer> head, PrintStream ps) {
        ListNode<Integer> current = head;

        while (current != null) {
            ps.print(current.val);
            if (current.next != null) {
                ps.printf(" -> ");
            }
            current = current.next;
        }
        ps.println();
    }

    public static <E> ListNode<E> reverse(ListNode<E> head) {
        if (head == null)
            return head;

        ListNode<E> prev = new ListNode(0, head);

        ListNode<E> insert = head.next;

        while (insert != null) {
            ListNode<E> next = insert.next;
            insert.next = prev.next;
            prev.next = insert;
            insert = next;
        }

        return prev.next;
    }
}
