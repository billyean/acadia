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

package com.haibo.yan.algorithm.dp;

/**
 * Typical dynamic programming problem. Trace back if need findInTwo out what's the longest common subsequence of two
 * strings.
 *
 */
public class LongestCommonSubsequence {
    public static int longestCommonSequence(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0) {
            return 0;
        }

        char[] cs1 = str1.toCharArray(), cs2 = str2.toCharArray();

        int[][] longest = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 0; i <= str1.length(); i++) {
            longest[i][0] = 0;
        }

        for (int i = 0; i <= str2.length(); i++) {
            longest[0][i] = 0;
        }

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                int max = Integer.max(longest[i - 1][j], longest[i][j - 1]);

                if (cs1[i - 1] == cs2[j - 1]) {
                    max = Integer.max(longest[i - 1][ j - 1] + 1, max);
                }
                longest[i][j] = max;
            }
        }

        return longest[str1.length()][str2.length()];
    }
}
