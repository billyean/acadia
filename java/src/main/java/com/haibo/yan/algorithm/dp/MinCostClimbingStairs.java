package com.haibo.yan.algorithm.dp;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int a = cost[0];
        int b = cost[1];
        if (cost.length == 2) return Integer.min(a, b);

        for (int i = 2; i < cost.length; i++) {
            int c = cost[i] + Integer.min(a, b);
            a = b;
            b = c;
        }

        return Integer.min(a, b);
    }
}
