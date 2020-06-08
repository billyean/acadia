package com.haibo.yan.algorithm.array;

import java.util.Stack;

/**
 * https://leetcode.com/problems/sum-of-subarray-minimums/
 */
public class SumSubarrayMinimums {
    public int sumSubarrayMins(int[] A) {
        int[] min = new int[A.length];
        Stack<int[]> d = new Stack<>();
        d.push(new int[]{A[0], 1, A[0]});
        int c = 1;
        long t = A[0];
        while (c < A.length) {
            int x = 0;
            int[] ne = new int[]{A[c], 1, 0};
            while (!d.isEmpty() && d.peek()[0] >= A[c]) {
                int[] y = d.pop();
                ne[1] += y[1];
            }
            int z = d.isEmpty() ? 0 : d.peek()[2];
            ne[2] = z + ne[0] * ne[1];
            d.push(ne);
            t += ne[2];
            t %= 1000000007;
            c++;
        }

        return (int)t;
    }
}
