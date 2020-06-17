package com.haibo.yan.algorithm.array;

/**
 * https://leetcode.com/problems/longest-line-of-consecutive-one-in-matrix/
 */
public class LongestLineConsecutiveOneInMatrix {
    public int longestLine(int[][] M) {
        int r = M.length;
        if (r == 0) return 0;
        int c = M[0].length;
        if (c == 0) return 0;

        int[][][] max = new int[4][][];
        max[0] = new int[r][2]; // Line max
        max[1] = new int[c][2];
        max[2] = new int[r + c][2];
        max[3] = new int[c + r][2];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(M[i][j] == 1) {
                    if (j == 0 || M[i][j - 1] == 0) {
                        max[0][i][0] = 1;
                        max[0][i][1] = Integer.max(max[0][i][1], 1);
                    } else {
                        max[0][i][0]++;
                        max[0][i][1] = Integer.max(max[0][i][1], max[0][i][0]);
                    }

                    if (i == 0 || M[i - 1][j] == 0) {
                        max[1][j][0] = 1;
                        max[1][j][1] = Integer.max(max[1][j][1], 1);
                    } else {
                        max[1][j][0]++;
                        max[1][j][1] = Integer.max(max[1][j][1], max[1][j][0]);
                    }

                    if (i == 0 || j == c - 1 || M[i - 1][j + 1] == 0) {
                        max[2][i + j][0] = 1;
                        max[2][i + j][1] = Integer.max(max[2][i + j][1], 1);
                    } else {
                        max[2][i + j][0]++;
                        max[2][i + j][1] = Integer.max(max[2][i + j][1], max[2][i + j][0]);
                    }

                    if (i == 0 || j ==  0 || M[i - 1][j - 1] == 0) {
                        max[3][i + c - j - 1][0] = 1;
                        max[3][i + c - j - 1][1] = Integer.max(max[3][i + c - j - 1][1], 1);
                    } else {
                        max[3][i + c - j - 1][0]++;
                        max[3][i + c - j - 1][1] = Integer.max(max[3][i + c - j - 1][1], max[3][i + c - j - 1][0]);
                    }
                }
            }
        }

        int m = 0;
        for (int i = 0; i < 4; i++) {
            for(int[] x : max[i]) {
                m = Integer.max(m, x[1]);
            }
        }

        return m;
    }
}
