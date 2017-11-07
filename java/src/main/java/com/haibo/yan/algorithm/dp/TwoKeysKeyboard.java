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

import java.util.HashMap;

/**
 * see https://leetcode.com/problems/2-keys-keyboard
 * Initially on a notepad only one character 'A' is present. You can perform two operations on this notepad for each
 * step:
 *
 * Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
 * Paste: You can paste the characters which are copied last time.
 * Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum number of steps permitted. Output the minimum number of steps to get n 'A'.
 *
 * Example 1:
 * Input: 3
 * Output: 3
 * Explanation:
 * Intitally, we have one character 'A'.
 * In step 1, we use Copy All operation.
 * In step 2, we use Paste operation to get 'AA'.
 * In step 3, we use Paste operation to get 'AAA'.
 * Note: The n will be in the range [1, 1000].
 */
public class TwoKeysKeyboard {
    public int minSteps(int n) {
        if (n == 1)
            return 0;
        if (n == 2)
            return 2;
        HashMap<Integer, Integer> pairs = new HashMap<>();

        pairs.put(1, 1);
        pairs.put(2, 2);

        return minSteps(n, pairs);
    }

    /**
     * Use a map as cache remember all traveled val min steps(Kind of DP).
     * Every val n if it dividable as i * j, it should be min val of minSteps(i) + j, minSteps(j) + i
     *
     * @param n
     * @param pairs
     * @return
     */
    public int minSteps(int n, HashMap<Integer, Integer> pairs) {
        int boundary = Math.min(n >> 1, 32);
        int steps = n;
        for (int i = 2; i <= boundary; i++) {
            if (n % i == 0) {
                int d = n / i;
                int dsteps = pairs.containsKey(d) ? pairs.get(d) : minSteps(d, pairs);
                if (i + dsteps < steps) {
                    steps = i + dsteps;
                    pairs.put(n, steps);
                }
                int isteps = pairs.containsKey(i) ? pairs.get(i) : minSteps(i, pairs);
                if (d  + isteps < steps) {
                    steps = d  + isteps;
                    pairs.put(n, steps);
                }
            }
        }
        return steps;
    }
}
