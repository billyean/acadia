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

package com.haibo.yan.algorithm.math;

/**
 * see https://leetcode.com/problems/integer-replacement
 * Given a positive integer n and you can do operations as follow:
 * If n is even, replace n with n/2. If n is odd, you can replace n with either n + 1 or n - 1.
 * What is the minimum number of replacements needed for n to become 1?
 *
 * Example 1:
 * Input: 8
 * Output: 3
 * Explanation:8 -> 4 -> 2 -> 1
 *
 * Example 2:
 * Input: 7
 * Output: 4
 * Explanation: 7 -> 8 -> 4 -> 2 -> 1
 * or 7 -> 6 -> 3 -> 2 -> 1
 */
public class IntegerReplacement {
    public int integerReplacement(int n) {
        // Special treatment since it will be overflow.
        if(n == Integer.MAX_VALUE)
            return 32;
        int steps = 0;
        while (n != 1) {
            if ((n & 0x01) == 0) {
                n >>= 1;
            } else {
                // 3 is special case should be decrement
                if (n == 3 || (n & 0x02) == 0) {
                    n--;
                } else {
                    n++;
                }
            }
            steps++;
        }

        return steps;
    }
}
