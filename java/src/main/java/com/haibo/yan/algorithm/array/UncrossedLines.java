package com.haibo.yan.algorithm.array;

/**
 * https://leetcode.com/problems/uncrossed-lines/
 */
public class UncrossedLines {
    public int maxUncrossedLines(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int[][] dp = new int[m][n];
        dp[0][0] = A[0] == B[0] ? 1 : 0;

        for(int i = 1; i < m; i++) {
            dp[i][0] = Integer.max(dp[i- 1][0], A[i] == B[0] ? 1 : 0);
        }
        for(int i = 1; i < n; i++) {
            dp[0][i] = Integer.max(dp[0][i - 1], A[0] == B[i] ? 1 : 0);
        }
        for(int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (A[i] == B[j]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[m-1][n-1];
    }
}
