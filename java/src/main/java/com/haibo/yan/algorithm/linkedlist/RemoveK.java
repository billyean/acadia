package com.haibo.yan.algorithm.linkedlist;

/**
 * Remove reversed kth node in a linkedlist
 */
public class RemoveK {
    public ListNode head;

    public RemoveK(ListNode head) {
        this.head = head;
    }

    public void remove(int k) {
        if (k < 0 || head == null)
            return;

        if (k == 0) {
            head = head.next;
        } else {

            ListNode kth = head;

            while (kth != null && k > 0) {
                kth = kth.next;
                k--;
            }

            if (kth != null) {
                ListNode prev = null;
                ListNode curr = head;

                while (kth != null) {
                    prev = curr;
                    curr = curr.next;
                    kth = kth.next;
                }

                prev.next = curr.next;
            }
        }
    }
}
