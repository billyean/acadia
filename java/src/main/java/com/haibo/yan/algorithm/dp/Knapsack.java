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

import java.util.HashMap;

public class Knapsack {
    public static int mostValue(HashMap<Integer, Integer> map, int total) {
        int[] weights = map.keySet().stream().mapToInt(Integer::intValue).toArray();

        int[][] dp = new int[weights.length][total + 1];

        for (int i = 0; i < weights.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= total; i++) {
            if (i < weights[0]) {
                dp[0][i] = 0;
            } else {
                dp[0][i] = map.get(weights[0]);
            }
        }

        for (int i = 1; i < weights.length; i++) {
            for (int j = 1; j <= total; j++) {
                if (j < weights[i]) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    int v = map.get(weights[i]);
                    dp[i][j] = Integer.max(dp[i - 1][j - weights[i]] + v, dp[i - 1][j]);
                }
            }
        }
        return dp[weights.length - 1][total];
    }
}
