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

import java.util.Stack;

/**
 * see https://leetcode.com/problems/remove-k-digits
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is
 * the smallest possible.
 *
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * Example 1:
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * Example 2:
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * Example 3:
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 */
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if (k >= num.length()) {
            return "0";
        }

        char[] cn = num.toCharArray();
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        int i = 0;
        while (i < cn.length && k > 0) {
            char c = cn[i];
            if (stack.size() == 0) {
                if (c != '0') {
                    stack.push(c);
                }
                i++;
            } else {
                if (stack.peek() > c) {
                    char pc = stack.pop();
                    k--;
                } else {
                    stack.push(c);
                    i++;
                }

            }
        }


        while (k > 0) {
            stack.pop();
            k--;
        }

        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        if (sb.length() == 0) {
            while (i < cn.length && cn[i] == '0') {
                i++;
            }
        }

        while (i < cn.length) {
            sb.append(cn[i]);
            i++;
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

}
