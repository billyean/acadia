package com.haibo.yan.algorithm.hashtable;

/**
 * https://leetcode.com/problems/sparse-matrix-multiplication/
 */
public class SparseMatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {
        int r = A.length;
        int k = A[0].length;
        int c = B[0].length;
        int[][] BT = new int[c][k];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < c; j++) {
                BT[j][i] = B[i][j];
            }
        }

        int[][] res = new int[r][c];
        for (int i = 0; i < r; i++) {
            int[] x1 = A[i];
            for (int j = 0; j < c; j++) {
                int[] x2 = BT[j];
                for (int y = 0; y < x2.length; y++) {
                    res[i][j] += x1[y] * x2[y];
                }
            }
        }

        return res;
    }
}
