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

package com.haibo.yan.algorithm.dp;

public class EditDistance {
    /**
     * see https://leetcode.com/problems/edit-distance
     * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2.
     * (each operation is counted as 1 step.)
     * You have the following 3 operations permitted on a word:
     * a) Insert a character
     * b) Delete a character
     * c) Replace a character
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        char[] wc1 = word1.toCharArray(), wc2 = word2.toCharArray();

        int[][] distances = new int[wc1.length + 1][wc2.length + 1];

        for (int i = 0; i <= wc1.length; i++) {
            distances[i][0] = i;
        }

        for (int j = 0; j <= wc2.length; j++) {
            distances[0][j] = j;
        }

        for (int i = 1; i <= wc1.length; i++) {
            for (int j = 1; j <= wc2.length; j++) {
                char x = wc1[i - 1], y = wc2[j - 1];
                if (x == y) {
                    distances[i][j] = distances[i - 1][j - 1];
                } else {
                    distances[i][j] = Math.min(distances[i - 1][j], distances[i][j - 1]) + 1;
                    distances[i][j] = Math.min(distances[i - 1][j - 1] + 1, distances[i][j]);
                }
            }
        }

        return distances[wc1.length][wc2.length];
    }

    /**
     * Given two strings S and T, determine if they are both one edit distance apart.
     */
    public boolean isOneEditDistance(String s, String t) {
        char[] sc = s.toCharArray(), tc = t.toCharArray();

        int i = 0,  len = Math.min(sc.length, tc.length);

        int distance = tc.length - len + sc.length - len;

        while (i < len) {
            if (sc[i] != tc[i]) {
                distance++;
            }
        }

        return distance == 1;
    }
}
