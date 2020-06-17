package com.haibo.yan.algorithm.array;

/**
 * https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/
 */
public class NumberOfSubarraysWithBoundedMaximum {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        return numSubarrayOneBoundedMax(A, R) - numSubarrayOneBoundedMax(A, L - 1);
    }

    private int numSubarrayOneBoundedMax(int[] A, int B) {
        int sum = 0;
        int c = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= B) {
                c += 1;
            } else {
                c = 0;
            }
            sum += c;
        }
        return sum;
    }
}
