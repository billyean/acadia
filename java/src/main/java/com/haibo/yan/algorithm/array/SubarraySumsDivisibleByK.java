package com.haibo.yan.algorithm.array;

/**
 * https://leetcode.com/problems/subarray-sums-divisible-by-k/
 */
public class SubarraySumsDivisibleByK {
    public int subarraysDivByK(int[] A, int K) {
        int[] x = new int[K];

        int sum = 0;

        for (int a : A) {
            sum += a;
            x[(sum % K + K) % K]++;
        }

        int total = x[0] ;
        for (int i = 0; i < x.length; i++) {
            if (x[i] > 1) total += (x[i] * (x[i]-1))/2;
        }

        return total;

    }
}
