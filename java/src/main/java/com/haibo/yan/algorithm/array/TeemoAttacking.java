package com.haibo.yan.algorithm.array;

/**
 * https://leetcode.com/problems/teemo-attacking/
 */
public class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int x = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            x += Integer.min(duration, timeSeries[i + 1] - timeSeries[i]);
        }
        if (timeSeries.length > 0)
            x += duration;
        return x;
    }
}
