package com.haibo.yan.algorithm.array;

public class MaximumSumTwoNonOverlappingSubarrays {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int n = A.length;
        int[] presum = new int[n];
        presum[0] = A[0];
        for (int i = 1; i < n; i++) {
            presum[i] = presum[i - 1] + A[i];
        }

        int max = Integer.MIN_VALUE;
        for (int i = L - 1; i < n - M; i++) {
            int x = i >= L ? presum[i] - presum[i - L] : presum[i];
            for (int j = i + M; j < n; j++) {
                int y = presum[j] - presum[j - M];
                max = Integer.max(x + y, max);
            }
        }
        for (int i = M - 1; i < n - L; i++) {
            int x = i >= M ? presum[i] - presum[i - M] : presum[i];
            for (int j = i + L; j < n; j++) {
                int y = presum[j] - presum[j - L];
                max = Integer.max(x + y, max);
            }
        }
        return max;
    }
}
