package com.haibo.yan.algorithm.array;

/**
 * https://leetcode.com/problems/rle-iterator/
 */
public class RLEIterator {
    private int[] A;

    private int c;

    private int x;

    public RLEIterator(int[] A) {
        this.A = A;
        c = 0;
        x = 0;
    }

    public int next(int n) {
        if (c >= A.length) {
            return -1;
        }
        if (x != 0) {
            if (A[c] - x >= n) {
                x += n;
                return A[c+1];
            } else {
                n -= A[c] - x;
                c += 2;
                x = 0;
            }
        }
        while(c < A.length && A[c] <= n) {
            n -= A[c];
            c += 2;
        }
        if (c < A.length) {
            x += n;
            return A[c+1];
        } else {
            return -1;
        }
    }
}
