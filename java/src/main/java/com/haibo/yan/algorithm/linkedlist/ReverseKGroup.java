/*
 *
 *  * Copyright [2017] [Haibo(Tristan) Yan]
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *     http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.haibo.yan.algorithm.linkedlist;

/**
 * see https://leetcode.com/problems/reverse-nodes-in-k-group
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a
 * multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * For example,
 * Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return: 2->1->4->3->5
 *
 * For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode<Integer> head, int k) {
        if (k == 1 || head == null || head.next == null) {
            return head;
        }

        ListNode<Integer> newHead = new ListNode(0, head);

        ListNode<Integer> insertBefore = newHead;
        ListNode<Integer> current = head;

        while (current != null) {
            int i = 0;
            while (current != null && i < k) {
                current = current.next;
                i++;
            }

            // Reverse current range
            if (i == k) {
                ListNode<Integer> last = insertBefore.next;
                ListNode<Integer> r = insertBefore.next.next;
                insertBefore.next.next = current;
                while (r != current) {
                    ListNode<Integer> rn = r.next;
                    r.next = insertBefore.next;
                    insertBefore.next = r;
                    r = rn;
                }
                insertBefore = last;
            }
        }

        return newHead.next;
    }
}
