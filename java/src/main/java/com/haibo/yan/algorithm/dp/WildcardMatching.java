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

import java.util.Arrays;

/**
 * Implement wildcard pattern matching with support for '?' and '*'.
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 */
public class WildcardMatching {
    public static boolean isMatch(String s, String p) {

        char[] cs = s.toCharArray();
        char[] cp = p.toCharArray();

        boolean[][] matches = new boolean[cp.length + 1][cs.length + 1];

        matches[0][0] = true;
        for (int i = 1; i <= cp.length; i++) {
            if (cp[i - 1] == '*') {
                matches[i][0] = matches[i - 1][0];
            }
        }


        for (int i = 1; i <= cp.length; i++) {
            for (int j = 1; j <= cs.length; j++) {
                if (cp[i - 1] == '*') {
                    matches[i][j] = matches[i - 1][j - 1] || matches[i][j - 1] || matches[i - 1][j];
                } else if (cp[i - 1] == '?' || cp[i - 1] == cs[j - 1]) {
                    matches[i][j] = matches[i - 1][j - 1];
                }
            }
        }

        return matches[cp.length][cs.length];
    }
}
