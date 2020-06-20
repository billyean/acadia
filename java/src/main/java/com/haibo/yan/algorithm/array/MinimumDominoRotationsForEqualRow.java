package com.haibo.yan.algorithm.array;

/**
 * https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
 */
public class MinimumDominoRotationsForEqualRow {
    public int minDominoRotations(int[] A, int[] B) {
        int[] d = new int[6];

        for (int i = 0; i < A.length; i++) {
            if(A[i] == B[i]) {
                d[A[i] - 1]++;
            } else {
                d[A[i] - 1]++;
                d[B[i] - 1]++;
            }
        }

        int x = 0;
        for (int i = 1; i < 6; i++) {
            if (d[i] > d[x]) {
                x = i;
            }
        }
        int m = d[x];
        if (m < A.length) {
            return -1;
        }

        int y1 = 0, y2=0;
        for (int i = 0; i < A.length; i++) {
            y1 += A[i] == (x + 1) ? 0 : 1;
            y2 += B[i] == (x + 1) ? 0 : 1;
        }

        return Integer.min(y1, y2);
    }
}
