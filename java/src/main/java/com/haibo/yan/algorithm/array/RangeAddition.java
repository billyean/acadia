package com.haibo.yan.algorithm.array;

/**
 * https://leetcode.com/problems/range-addition/
 */
public class RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] x = new int[length];

        for (int[] update : updates) {
            int s = update[0];
            int e = update[1];
            int v = update[2];
            x[s] += v;
            if (e < length - 1)
                x[e + 1] -= v;
        }

        for (int i = 1; i < length; i++) {
            x[i] += x[i - 1];
        }

        return x;
    }
}
