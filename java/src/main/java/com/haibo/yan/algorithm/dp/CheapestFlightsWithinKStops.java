package com.haibo.yan.algorithm.dp;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/
 */
public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] weights = new int[n][n];
        for (int[] flight : flights) {
            weights[flight[0]][flight[1]] = flight[2];
        }

        int[][] dp = new int[n][K + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= K; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[src][0] = 0;
        HashSet<Integer> n1 = new HashSet<>();
        n1.add(src);

        for (int i = 0; i <= K; i++) {
            if (i != 0) {
                for (int j = 0; j < n; j++) {
                    dp[j][i] = dp[j][i - 1];
                }
            }
            HashSet<Integer> n2 = new HashSet<>();
            for (int j : n1) {
                for (int k = 0; k < n; k++) {
                    if(weights[j][k] != 0) {
                        if (i == 0) {
                            dp[k][i] = weights[j][k];
                        } else {
                            dp[k][i] = Integer.min(dp[k][i], dp[j][i - 1] + weights[j][k]);
                        }
                        n2.add(k);
                    }
                }
            }
            n1 = n2;
        }
        if (dp[dst][K] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dp[dst][K];
        }
    }
}
