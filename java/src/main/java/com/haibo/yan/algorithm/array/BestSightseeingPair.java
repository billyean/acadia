package com.haibo.yan.algorithm.array;

/**
 * https://leetcode.com/problems/best-sightseeing-pair/
 */
public class BestSightseeingPair {
    public int maxScoreSightseeingPair(int[] A) {
        int m = A[0] + 0;
        int score = Integer.MIN_VALUE;

        for (int i = 1; i < A.length; i++) {
            score = Integer.max(score, m + A[i] - i);
            m = Integer.max(m, A[i] + i);
        }

        return score;
    }
}
