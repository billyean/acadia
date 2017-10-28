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

package com.haibo.yan.algorithm.array;

import java.util.stream.IntStream;

/**
 * Manacher Algorithm to calculate longest Palindrome
 *
 * See https://en.wikipedia.org/wiki/Longest_palindromic_substring, this only works for no $ in the string, we may be
 * add randomize character as the separator.
 *
 */
public class LongestPalindrome {
    public int lenOfLongest(char[] cs) {
        if (cs.length <= 1) {
            return cs.length;
        }

        char[] oddCs = new char[2 * cs.length + 1];
        oddCs[0] = '$';
        for (int i = 0; i < cs.length; i++) {
            oddCs[2 * i + 1] = cs[i];
            oddCs[2 * i + 2] = '$';
        }

        return IntStream.of(plenWithOddArray(oddCs)).max().getAsInt() / 2;
    }

    private int[] plenWithOddArray(char[] cs) {
        int[] pInts = new int[cs.length];
        int i = 0;

        while (i < cs.length) {
            pInts[i] = plen(cs, i);
            int j = 1;
            for (; j <= (pInts[i] >> 1); j++) {
                int leftJ = i - j - (pInts[i - j] >> 1);
                int leftI = i - (pInts[i] >> 1);
                if (leftJ < leftI) {
                    pInts[i + j] = pInts[i - j];
                } else if (leftJ > leftI) {
                    pInts[i + j] = 1 + 2 *((pInts[i] >> 1) - j);
                } else {
                    break;
                }
            }
            i = i + j;
        }
        return pInts;
    }

    private int plen(char[] cs, int position) {
        int len = 1;
        int i = position - 1, j = position + 1;
        while (i >= 0 && j < cs.length && cs[i] == cs[j]) {
            len += 2;
            i--;
            j++;
        }
        return len;
    }
}
