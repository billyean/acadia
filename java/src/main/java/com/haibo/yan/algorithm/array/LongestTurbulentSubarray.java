package com.haibo.yan.algorithm.array;

/**
 * https://leetcode.com/problems/longest-turbulent-subarray/
 */
public class LongestTurbulentSubarray {
    public int maxTurbulenceSize(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int max = 1;
        int i = 0;

        while (i < A.length - 1) {
            while (i < A.length - 1 && A[i] == A[i+1]) {
                i++;
            }
            if (i < A.length - 1) {
                int up = A[i] < A[i + 1] ? 1 : (A[i] > A[i + 1] ? 2 : 3);
                i++;
                int x = 2;

                while (i < A.length - 1 && ((up & (A[i] < A[i + 1] ? 1 : (A[i] > A[i + 1] ? 2 : 3)))== 0)) {
                    i++;
                    x++;
                    if (up == 1) {
                        up = 2;
                    } else {
                        up = 1;
                    }
                }
                max = Integer.max(x, max);
            }
        }
        return max;
    }
}
