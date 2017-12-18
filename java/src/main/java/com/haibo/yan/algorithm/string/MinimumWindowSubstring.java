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

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


/**
 *
 * see https://leetcode.com/problems/minimum-window-substring
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in
 * complexity O(n).
 *
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (char c: t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int max = s.length() + 1, start = -1;

        HashMap<Character, Integer> windowMap = new HashMap<>();

        Queue<Integer> queue = new LinkedList<>();

        for (int i =0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (tMap.containsKey(c)) {
                queue.offer(i);
                windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
                if (lessThan(tMap, windowMap)) {

                    while (!queue.isEmpty() && lessThan(tMap, windowMap)) {
                        int p = queue.poll();
                        int len = i - p + 1;
                        if (len < max) {
                            max = len;
                            start =  p;
                        }
                        char ctop = s.charAt(p);

                        if (queue.size() > 0) {
                            ctop = s.charAt(p);
                            windowMap.put(ctop, windowMap.get(ctop) - 1);
                        }
                    }
                }
            }
        }

        return start == -1 ? "" : s.substring(start, start + max);
    }

    private boolean lessThan(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2) {
        for (char c : map1.keySet()) {
            if (!map2.containsKey(c) ||  map2.get(c) < map1.get(c)) {
                return false;
            }
        }

        return true;
    }
}
