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

import java.util.Arrays;

/**
 * By given a sum and a array, try to figure if it's possible to get a subset of array that add up to sum.
 * Example
 * 1. given sum as 11, and array [1, 3, 7, 8, 10]
 * subset [3, 8] add up together equals to 11, should return true.
 * 2. given sum as 14, and array [1, 3, 7, 8, 10]
 * no subset adds up together equals to 14, should return false.
 */
public class SubsetSum {
    /**
     * Typical dynamice programming, using a
     * @param sum
     * @param array
     * @return
     */
    public static boolean existSubset(int sum, int[] array) {
        boolean[][] dp = new boolean[array.length][sum + 1];

        for (int i = 0; i < array.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (i == 0) {
                    if (j == array[i]) {
                        dp[i][j] = true;
                    }
                } else {
                    if (dp[i - 1][j] || j >= array[i] && dp[i - 1][j - array[i]]) {
                        dp[i][j] = true;
                    }
                }
            }
        }

        return dp[array.length - 1][sum];
    }
}
