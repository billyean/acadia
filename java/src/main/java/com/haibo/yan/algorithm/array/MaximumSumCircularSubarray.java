package com.haibo.yan.algorithm.array;

/**
 * https://leetcode.com/problems/maximum-sum-circular-subarray/
 */
public class MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] A) {
        int n = A.length;
        int max = A[0], cur = A[0];
        for (int i = 1; i < A.length; i++) {
            cur = A[i] + Integer.max(cur, 0);
            max = Integer.max(max, cur);
        }
        System.out.println(" max = " + max);
        int[] rightsum = new int[n];
        rightsum[n - 1] = A[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightsum[i] = rightsum[i + 1] + A[i];
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = A[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Integer.max(rightMax[i + 1], rightsum[i]);
        }

        int leftsum = 0;
        for (int i = 0 ; i < n -2; i++) {
            leftsum += A[i];
            max = Integer.max(rightMax[i + 2] + leftsum, max);
        }

        return max;

    }
}
