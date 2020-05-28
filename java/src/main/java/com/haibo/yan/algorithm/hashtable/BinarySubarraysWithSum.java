package com.haibo.yan.algorithm.hashtable;

/**
 * https://leetcode.com/problems/binary-subarrays-with-sum/
 */
public class BinarySubarraysWithSum {
    public int numSubarraysWithSum(int[] A, int S) {
        int[] presum = new int[A.length + 1];
        presum[0] = 1;
        int total = 0;
        int num = 0;
        for (int a : A) {
            total += a;
            if (total >= S) {
                num += presum[total - S];
            }
            presum[total]++;
        }

        return num;

    }
}
