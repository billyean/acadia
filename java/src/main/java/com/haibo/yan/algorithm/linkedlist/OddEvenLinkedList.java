/*
 * Copyright [2017] [Haibo(Tristan) Yan]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.haibo.yan.algorithm.linkedlist;


/**
 * see https://leetcode.com/problems/odd-even-linked-list
 *
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking
 * about the node number and not the value in the nodes.
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 * Example:
 * Given 1->2->3->4->5->NULL,
 * return 1->3->5->2->4->NULL.
 * Note:
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 */
public class OddEvenLinkedList {
    public static <T> ListNode<T> oddEvenList(ListNode<T> head) {
        if (head == null || head.next == null) return head;


        ListNode<T> odd = head, oddC = odd;
        ListNode<T> even = head.next, evenC = even;

        ListNode<T> current = even.next;

        while (current != null && current.next != null) {
            oddC.next = current;
            evenC.next = current.next;
            oddC = oddC.next;
            evenC = evenC.next;
            current = current.next.next;
        }

        if (current != null) {
            oddC.next = current;
            oddC = oddC.next;
        }
        oddC.next = even;

        return odd;
    }
}
