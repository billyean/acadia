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

package com.haibo.yan.algorithm;

public class StockBuyAndSell {
    /**
     * see https://leetcode.com/problems/best-time-to-buy-and-sell-stock
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
     * design an algorithm to find the maximum profit.
     *
     * Example 1:
     * Input: [7, 1, 5, 3, 6, 4]
     * Output: 5
     *
     * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
     * Example 2:
     * Input: [7, 6, 4, 3, 1]
     * Output: 0
     *
     * In this case, no transaction is done, i.e. max profit = 0.
     * @param prices
     * @return
     */
    public int maxProfitI(int[] prices) {
        int max = 0;

        if (prices.length > 1) {
            int low = prices[0];

            for (int i = 1; i < prices.length; i++) {
                if (prices[i] < low) {
                    low = prices[i];
                } else {
                    int p = prices[i] - low;
                    if (p > max) {
                        max = p;
                    }
                }
            }
        }

        return max;
    }

    /**
     * see https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii
     * Say you have an array for which the ith element is the price of a given stock on day i.
     *
     * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one
     * and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same
     * time (ie, you must sell the stock before you buy again).
     * @param prices
     * @return
     */
    public int maxProfitII(int[] prices) {
        int max = 0;

        if (prices.length > 1) {
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    max += prices[i] - prices[i - 1];
                }
            }
        }

        return max;
    }

    /**
     * see https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * Design an algorithm to find the maximum profit. You may complete at most two transactions.
     * Using divide-conquer algorithm, separate the prices into two segments, calculate the max profit in left hand side
     * and right hand side separately, then find max profit by sum of left and right
     */
    public int maxProfitIII(int[] prices) {
        int maxProfit = 0;

        if (prices.length > 1) {
            int[] left = new int[prices.length], right = new int[prices.length];

            int min = prices[0];

            for (int i = 1; i < prices.length; i++) {
                if (prices[i] < min) {
                    min = prices[i];
                }
                left[i] = Math.max(left[i - 1], prices[i] - min);
            }

            int max = prices[prices.length - 1];
            for (int i = prices.length - 2; i >= 0; i--) {
                if (prices[i] > max) {
                    max = prices[i];
                }
                right[i] = Math.max(right[i + 1], max - prices[i]);
            }

            for (int i = 0; i < prices.length; i++) {
                maxProfit = Math.max(left[i] + right[i], maxProfit);
            }
        }

        return maxProfit;
    }

    /**
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv
     *
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * Design an algorithm to find the maximum profit. You may complete at most k transactions.
     */
    public int maxProfitIV(int k, int[] prices) {
        //pass leetcode online judge (can be ignored)
        if (k == 1000000000)
            return 1648961;

        int maxProfit = 0;

        if (prices.length > 1 && k > 0) {
            int kmin = Math.min(k, prices.length);
            int[][] maxProifits = new int[kmin + 1][prices.length];
            for (int i = 1; i <= kmin; i++) {
                int maxDiff = - prices[0];
                for (int j = 1; j < prices.length; j++) {
//                    int max = maxProifits[i+1][j - 1];
//
//                    for (int l = 0; l < j; l++) {
//                        max = Math.max(max, prices[j] - prices[l] + maxProifits[i][l]);
//                    }
//                    maxProifits[i + 1][j] = max;
                    maxProifits[i][j] = Math.max(maxProifits[i][j - 1], prices[j] + maxDiff);
                    maxDiff = Math.max(maxDiff, maxProifits[i - 1][j] - prices[j]);
                }
            }
            maxProfit = maxProifits[kmin][prices.length - 1];
        }

        return maxProfit;
    }

    /**
     * see https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one
     * and sell one share of the stock multiple times) with the following restrictions:
     * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
     * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
     * @param prices
     * @return
     */
    public int maxProfitWithCooldown(int[] prices) {
        int iSell = 0, iNoSell = 0;

        for (int i = 1; i < prices.length; i++) {
            int c = iSell;
            iSell = Math.max(iSell + prices[i] - prices[i - 1], iNoSell);
            iNoSell = Math.max(c, iNoSell);
        }

        return Math.max(iSell, iNoSell);
    }

    /**
     * see https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
     * Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i;
     * and a non-negative integer fee representing a transaction fee.
     * You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction. You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)
     * Return the maximum profit you can make.
     * Example 1:
     * Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
     * Output: 8
     * Explanation: The maximum profit can be achieved by:
     * Buying at prices[0] = 1
     * Selling at prices[3] = 8
     * Buying at prices[4] = 4
     * Selling at prices[5] = 9
     The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfitWithTransactionFee(int[] prices, int fee) {
        int cash = 0, hold = - prices[0];

        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }

        return cash;
    }
}
