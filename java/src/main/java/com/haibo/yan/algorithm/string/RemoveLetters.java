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

package com.haibo.yan.algorithm.string;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveLetters {

    /**
     * see https://leetcode.com/problems/remove-duplicate-letters
     * Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once
     * and only once. You must make sure your result is the smallest in lexicographical order among all possible results.
     *
     * Example:
     * Given "bcabc"
     * Return "abc"
     *
     * Given "cbacdcbc"
     * Return "acdb"
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        int[] cnum = new int[26];

        for (char c : s.toCharArray()) {
            cnum[c - 'a']++;
        }

        boolean[] visited = new boolean[26];
        Deque<Character> deque = new LinkedList<>();
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            cnum[index]--;

            if (visited[index]) {
                continue;
            }

            while(!deque.isEmpty() && deque.getLast() > c && cnum[deque.getLast() - 'a'] > 0) {
                visited[deque.removeLast() - 'a'] = false;
            }
            deque.addLast(c);
            visited[index] = true;
        }

        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()) {
            sb.append(deque.removeFirst());
        }
        return sb.toString();
    }
}
