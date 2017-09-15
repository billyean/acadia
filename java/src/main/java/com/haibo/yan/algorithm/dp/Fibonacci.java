package com.haibo.yan.algorithm.dp;

public class Fibonacci {
    /**
     * DP for Fibonacci
     */
    public static long fibonacci(int num) {
        if (num < 0) {
            return -1L;
        }

        if (num == 1 || num == 2) {
            return 1L;
        }

        long prev1 = 1, prev2 = 1;

        for (int i = 2; i < num; i++) {
            long sum = prev1 + prev2;
            prev1 = prev2;
            prev2 = sum;
        }

        return prev2;
    }
}
