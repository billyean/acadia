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

package com.haibo.yan.algorithm.array;

/**
 *
 * see https://leetcode.com/problems/reverse-vowels-of-a-string
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * Example 1:
 * Given s = "hello", return "holle".
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 */
public class ReverseVowels {
    public  String reverseVowels(String s) {
        if (null == s) {
            return s;
        }

        char[] cs = s.toCharArray();

        int left = 0, right = cs.length - 1;

        while (left < right) {
            while (left < cs.length && !isVowel(cs[left])) {
                left++;
            }

            while (right >= 0 && !isVowel(cs[right])) {
                right--;
            }

            if (left < right) {
                char t = cs[left];
                cs[left] = cs[right];
                cs[right] = t;
            }
            left++;
            right--;
        }

        return new String(cs);
    }

    private  boolean isVowel(char c) {
        char c1 = (c < 91) ? (char)(c + 32) : c;
        return c1 == 'a' || c1 == 'e' || c1 == 'i' || c1 == 'o' || c1 == 'u';
    }
}
