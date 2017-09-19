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
package com.haibo.yan.algorithm;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/valid-anagram
 *
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 *
 */
public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        int[] sc1 = new int[256];
        int[] sc2 = new int[256];

        for (char c : s.toCharArray()) {
            sc1[c]++;
        }

        for (char c : t.toCharArray()) {
            sc2[c]++;
        }

        return Arrays.equals(sc1, sc2);
    }
}
