package com.haibo.yan.algorithm.linkedlist;

interface ImmutableListNode {
    public void printValue(); // print the value of this node.
    public ImmutableListNode getNext(); // return the next node.
};

/**
 * https://leetcode.com/problems/print-immutable-linked-list-in-reverse/
 */
public class PrintImmutableLinkedList {
    public void printLinkedListInReverse(ImmutableListNode head) {
        if (head == null) {
            return;
        }
        printLinkedListInReverse(head.getNext());
        head.printValue();
    }
}
