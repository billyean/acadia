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

package com.haibo.yan.algorithm.string;

public class ReverseWords {
    /**
     * Given an input string, reverse the string word by word.
     * For example,
     * Given s = "the sky is blue",
     * return "blue is sky the".
     */
    public static String reverseWords(String s) {
        char[] cs = s.toCharArray();

        int start = -1;
        for (int i = 0; i < cs.length; i++) {
           if (start == -1 && cs[i] != ' ') {
               start = i;
           }

           if ((i == cs.length - 1 || cs[i+1] == ' ')  && start != -1) {
               reverse(cs, start, i + 1);
               start = -1;
           }

        }
        reverse(cs, 0, cs.length);
        return new String(cs);
    }

    private static void reverse(char[] s, int start, int end) {
        int middle = (end - start) / 2;
        for (int i = 0; i < middle; i++) {
            int l = start + i;
            int r = end - 1 - i;
            char t = s[l];
            s[l] = s[r];
            s[r] = t;
        }
    }
}
