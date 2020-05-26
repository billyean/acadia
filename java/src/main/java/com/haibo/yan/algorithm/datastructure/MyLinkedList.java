package com.haibo.yan.algorithm.datastructure;

import java.util.Random;

public class MyLinkedList {
    private int size;

    private class ListNode {
        int val;

        ListNode next;

        ListNode(int value) {
            this.val = value;
        }

        ListNode() {
            this(-1);
        }
    }

    private ListNode head;
    private ListNode tail;



    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = tail = new ListNode();
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < size) {
            int c = 0;
            ListNode v = head.next;
            while (c < index) {
                v = v.next;
                c++;
            }
            return v.val;
        }
        return -1;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode n = new ListNode(val);
        n.next = head.next;
        head.next = n;
        if (tail == head) {
            tail = n;
        }
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode n = new ListNode(val);
        tail.next = n;
        tail = n;
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index < size) {
            int c = 0;
            ListNode v = head;
            while (c < index) {
                v = v.next;
                c++;
            }
            ListNode n = new ListNode(val);
            n.next = v.next;
            v.next = n;
            size++;
        } else if (index == size) {
            addAtTail(val);
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < size) {
            int c = 0;
            ListNode p = head;
            ListNode v = head.next;
            while (c < index) {
                p = v;
                v = v.next;
                c++;
            }
            p.next = v.next;
            size--;
        }
    }

    public static void main(String[] args) {
         int index = 1;
         MyLinkedList obj = new MyLinkedList();
         int param_1 = obj.get(index);
         obj.addAtHead(20);
         obj.addAtTail(10);
         obj.addAtIndex(index,15);
         obj.deleteAtIndex(index);
    }
}
