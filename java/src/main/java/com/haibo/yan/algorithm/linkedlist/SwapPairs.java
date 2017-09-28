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
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * For example, given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * Your algorithm should use only constant space. You may not modify the values in the list,
 * only nodes itself can be changed.
 */
public class SwapPairs {
    /**
     * No extra node solution, tedious
     * @param head
     * @param <T>
     * @return
     */
    public static <T> ListNode<T> swap(ListNode<T> head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode<T> current = head;
        ListNode<T> prev = null;
        ListNode<T> newHead = null;

        while (current != null && current.next != null) {
            if (prev == null) {
                newHead = current.next;
                current.next = newHead.next;
                newHead.next = current;
                prev = current;
                current = current.next;
            } else {
                prev.next = current.next;
                current.next = current.next.next;
                prev.next.next = current;
                current = current.next;
                prev = prev.next.next;
            }
        }

        return newHead;
    }

    /**
     * extra node solution, cool one. Think about how to eliminate the new head with adding one extra node.
     * @param head
     * @param <T>
     * @return
     */
    public static <T> ListNode<T> swapWithExtraNode(ListNode<T> head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode<T> extra = new ListNode(0);
        ListNode<T> prev = extra;
        prev.next = head;
        ListNode<T> current = head;

        while (current != null && current.next != null) {
                prev.next = current.next;
                current.next = current.next.next;
                prev.next.next = current;
                current = current.next;
                prev = prev.next.next;
        }

        return extra.next;
    }
}
