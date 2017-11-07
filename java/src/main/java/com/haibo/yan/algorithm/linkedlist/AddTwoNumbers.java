/*
 * Copyright (c) [2017] [Haibo(Tristan) Yan]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.haibo.yan.algorithm.linkedlist;


public class AddTwoNumbers {
    /**
     * see https://leetcode.com/problems/add-two-numbers
     * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
     * order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
     *
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     *
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbersI(ListNode<Integer> l1, ListNode<Integer> l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode sum =  null;
        ListNode prev = null;

        int adder = 0;

        while(l1 != null && l2 != null) {
            int v = l1.val + l2.val + adder;
            ListNode<Integer> current = new ListNode(v >= 10 ? v - 10 : v);
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
            ListNode<Integer> current = new ListNode(v >= 10 ? v - 10 : v);

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

    /**
     * https://leetcode.com/problems/add-two-numbers-ii
     * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes
     * first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
     *
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     * Follow up:
     * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
     * Example:
     * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 8 -> 0 -> 7
     *
     */
    public ListNode addTwoNumbersII(ListNode<Integer> l1, ListNode<Integer> l2) {
        int len1 = length(l1), len2 = length(l2);
        int max = Math.max(len1, len2);
        int min = Math.min(len1, len2);

        ListNode<Integer> lln = (len1 > len2) ? l1 : l2;
        ListNode<Integer> sln = (l1 == lln) ?  l2 : l1;

        ListNode<Integer> sum = add(lln, sln, max, min);
        normalize(sum);
        if (sum.val == 0) {
            return sum.next;
        } else {
            return sum;
        }
    }

    private int length(ListNode<Integer> l) {
        int len = 0;
        while (l != null) {
            len++;
            l = l.next;
        }
        return len;
    }

    private ListNode add(ListNode<Integer> lln, ListNode<Integer> sln, int l, int s) {
        ListNode<Integer> head = new ListNode(0), current = head;

        int i = 0;
        while (i < l - s) {
            current.next = new ListNode(lln.val);
            lln = lln.next;
            current = current.next;
            i++;
        }

        while(i < l) {
            current.next = new ListNode(lln.val + sln.val);
            lln = lln.next;
            sln = sln.next;
            current = current.next;
            i++;
        }

        return head;
    }

    private void normalize(ListNode<Integer> head) {
        ListNode<Integer> current = head, next = current.next;

        while (next != null) {
            while (next != null && next.val == 9) {
                next = next.next;
            }

            if (next != null && next.val > 9) {
                ListNode<Integer> addOne = current;
                while (addOne != next) {
                    addOne.val = (addOne.val + 1) % 10;
                    addOne = addOne.next;
                }
                addOne.val = addOne.val % 10;
            }

            if (next != null) {
                current = next;
                next = next.next;
            }
        }
    }
}
