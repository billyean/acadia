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

import java.util.StringJoiner;

/**
 * Given a singly linked list L: L0→L1→ ... →Ln-1→Ln,
 *
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→...
 * For example, given {1,2,3,4}, reorder it to {1,4,2,3}. You must do this in-place
 * without altering the nodes' values.
 */
public class ReorderList {
    public static <T> void reorder(ListNode<T> head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode one = head;
        ListNode two = head.next;

        while(two != null && two.next !=  null) {
            one = one.next;
            two = two.next.next;
        }

        ListNode l2 = one.next;
        one.next = null;
        l2 = reverse(l2);
        ListNode l1 = head;

        while (l2 != null) {
            ListNode i = l2;
            l2 = l2.next;
            i.next = l1.next;
            l1.next = i;
            l1 = l1.next.next;
        }
    }

    private static <T> ListNode<T> reverse(ListNode<T> head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode<T> currentHead = head;
        ListNode<T> insertListNode = head.next;
        currentHead.next = null;

        while (insertListNode != null) {
            ListNode<T> newHead = insertListNode;
            insertListNode = insertListNode.next;
            newHead.next = currentHead;
            currentHead = newHead;
        }

        return currentHead;
    }

    private static <T> void print(ListNode<T> head) {
        StringJoiner sj = new StringJoiner(" -> ");
        while (head != null) {
            sj.add(head.val.toString());
            head = head.next;
        }

        System.out.println(sj.toString());
    }
}
