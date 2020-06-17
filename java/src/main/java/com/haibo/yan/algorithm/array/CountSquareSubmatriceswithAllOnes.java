package com.haibo.yan.algorithm.array;

/**
 * https://leetcode.com/problems/count-square-submatrices-with-all-ones/
 */
public class CountSquareSubmatriceswithAllOnes {
    public int countSquares(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;

        int[][] total = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(i == 0 && j == 0) {
                    total[i][j] = matrix[i][j];
                } else if (i == 0) {
                    total[i][j] = total[i][j - 1] + matrix[i][j];
                } else if (j == 0) {
                    total[i][j] = total[i - 1][j] + matrix[i][j];
                } else {
                    total[i][j] = total[i][j - 1] + total[i - 1][j] - total[i - 1][j - 1] + matrix[i][j];
                }
            }
        }

        int x = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 1) {
                    int n = Integer.min(i, j) + 1;
                    for (int k = 0; k < n; k++) {
                        int a = total[i][j];
                        if (j - k - 1 >= 0 && i - k - 1 >= 0) {
                            a += total[i - k - 1][j - k - 1];
                        }
                        if (i - k - 1 >= 0) {
                            a -= total[i - k - 1][j];
                        }
                        if (j - k - 1 >= 0) {
                            a -= total[i][j - k - 1];
                        }
                        if (a == (k + 1) * (k + 1)) {
                            x++;
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        return x;
    }
}
