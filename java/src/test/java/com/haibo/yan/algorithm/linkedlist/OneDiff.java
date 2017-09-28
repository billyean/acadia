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
 *  compare two LinkedLists, return true if there is only one difference or no difference, false if more than two
 *  differences.
 */
public class OneDiff {
    public <T extends Comparable> boolean isOneDiff(ListNode<T> l1, ListNode<T> l2) {
        int diff = 0;

        while (l1 != null && l2 != null) {
            if (l1.value.compareTo(l2.value) != 0) {
                diff++;
                if (diff > 1) {
                    return false;
                }
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        return l1 == null && l2 == null && diff != 0;
    }
}
