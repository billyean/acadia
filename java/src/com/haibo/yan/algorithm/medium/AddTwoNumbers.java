package com.haibo.yan.algorithm.medium;


/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
 * order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * See https://leetcode.com/problems/add-two-numbers/description/
 */
public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode sum =  null;
        ListNode prev = null;

        int adder = 0;

        while(l1 != null && l2 != null) {
            int v = l1.val + l2.val + adder;
            ListNode current = new ListNode(v >= 10 ? v - 10 : v);
            if (sum == null) {
                sum = current;
            } else {
                prev.next = current;
            }
            adder = v >= 10 ? 1 : 0;
            prev = current;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l2 != null) {
            l1 = l2;
        }

        while (l1 != null) {
            int v = l1.val + adder;
            ListNode current = new ListNode(v >= 10 ? v - 10 : v);

            prev.next = current;
            adder = v >= 10 ? 1 : 0;
            prev = current;
            l1 = l1.next;
        }

        if (adder != 0) {
            ListNode current = new ListNode(adder);
            prev.next = current;
        }

        return sum;
    }
}
