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
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
 * Example:
 * Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding
 * [11,22,33,44,55,66,77,88,99])
 */
public class CountNumbersWithUniqueDigits {
    /**
     * A combination problem, first digit should be [1-9], all other digits can be [0-9]
     * @param n
     * @return
     */
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
            return 1;
        int numbers = 0;
        for (int i = 0; i < n; i++) {
            numbers += uniqueAtN(i + 1);
        }

        return numbers;
    }

    private int uniqueAtN(int n){

        if (n == 1) {
            return 10;
        }

        int total = 1;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                total *= 9;
            } else {
                total *= 10 - i;
            }
        }

        return total;
    }
}
