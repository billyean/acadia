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

public class CoinChange {
    /**
     * See https://leetcode.com/problems/coin-change
     * <p>
     * You are given coins of different denominations and a total amount of money amount. Write a function to compute the
     * fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any
     * combination of the coins, return -1.
     * <p>
     * Example 1:
     * coins = [1, 2, 5], amount = 11
     * return 3 (11 = 5 + 5 + 1)
     * <p>
     * Example 2:
     * coins = [2], amount = 3
     * return -1.
     *
     * @param coins  changes array you can use
     * @param amount total amount
     * @return minimin coins would be used to make up the amount.
     */
    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);

        int[] dp = new int[amount + 1];

        for (int i = 0; i <= amount; i++) {
            dp[i] = i == 0 ? 0 : Integer.MAX_VALUE;
        }

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Integer.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    /**
     * see https://leetcode.com/problems/coin-change-2
     * <p>
     * You are given coins of different denominations and a total amount of money. Write a function to compute the
     * number of combinations that make up that amount. You may assume that you have infinite number of each kind of
     * coin.
     * Note: You can assume that
     * <p>
     * 0 <= amount <= 5000
     * 1 <= coin <= 5000
     * the number of coins is less than 500
     * the answer is guaranteed to fit into signed 32-bit integer
     *
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange2(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];



        for (int j = 0; j < coins.length; j++) {
            for (int i = 0; i < amount; i++) {
                if (i + 1 == coins[j]) {
                    dp[i]++;
                } else if (i + 1 > coins[j]) {
                    dp[i] += dp[i - coins[j]];
                }
            }
        }

        for (int i = 0; i < amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i + 1 == coins[j]) {
                    dp[i]++;
                } else if (i + 1 > coins[j]) {
                    dp[i] += dp[i - coins[j]];
                }
                System.out.printf("i + 1 = %d, coins[%d] = %d, dp[%d] = %d\n", i + 1, j, coins[j], i, dp[i]);
            }
        }

        return dp[amount - 1];
    }
}
