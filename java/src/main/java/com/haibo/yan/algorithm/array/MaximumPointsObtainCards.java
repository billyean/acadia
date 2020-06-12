package com.haibo.yan.algorithm.array;

/**
 * https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
 */
public class MaximumPointsObtainCards {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int nk = 0;
        for (int i = 0; i < cardPoints.length; i++) {
            if(i < cardPoints.length - k)
                nk += cardPoints[i];
            sum += cardPoints[i];
        }

        int max = sum - nk;
        for (int i = 0; i < k; i++) {
            nk -= cardPoints[i];
            nk += cardPoints[cardPoints.length - k + i];
            max = Integer.max(max, sum - nk);
        }

        return max;
    }
}
