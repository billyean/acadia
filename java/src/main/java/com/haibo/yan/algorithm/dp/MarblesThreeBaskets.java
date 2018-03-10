package com.haibo.yan.algorithm.dp;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MarblesThreeBaskets {
    /**
     * Each of three baskets contains a certain number of marbles. You may move
     * from one basket into another basket as many marbles as are already there,
     * thus doubling the quantity in the basket that received the marbles. You
     * must find a sequence of moves that will yield the same number of marbles
     * in the three baskets. Moreover, you must achieve the goal in the smallest
     * possible number of moves. Your program must also recognize the case in
     * which there is no such sequence of moves.
     * @return
     */
    public int minStep(int[] marbles) {
        Arrays.sort(marbles);
        int sum = IntStream.of(marbles).sum();
        int[][][] dp = new int[sum][sum][sum];

        if (sum % 3 != 0) {
            return -1;
        }

        for(int i = 0; i < sum; i++) {
            for(int j = 0; j < sum; j++) {
                for(int k = 0; k < sum; k++) {
                    if (i == j && j == k) {
                        dp[i][j][k] = 0;
                    } else {
                        dp[i][j][k] = -1;
                    }
                }
            }
        }
        return minStep(marbles, dp);
    }

    public int minStep(int[] marbles, int[][][] dp) {
        int c = dp[marbles[0]][marbles[1]][marbles[2]];
        if (c != -1 || c == Integer.MAX_VALUE) {
            return c;
        } else {
            int min = Integer.MAX_VALUE;
            int m0 = marbles[0], m1 = marbles[1], m2 = marbles[2];
            dp[m0][m1][m2] = Integer.MAX_VALUE;

            if (m0 * 2 != m1 && m0 != m1) {
                marbles[0] = m0 * 2;
                marbles[1] = m1 - m0;
                marbles[2] = m2;
                Arrays.sort(marbles);
                min = Math.min(min, minStep(marbles, dp));
            }

            if (m0 * 2 != m2) {
                marbles[0] = m0 * 2;
                marbles[1] = m1;
                marbles[2] = m2 - m0;

                Arrays.sort(marbles);
                min = Math.min(min, minStep(marbles, dp));
            }

            if (m1 * 2 != m2 && m1 != m2) {
                marbles[0] = m0;
                marbles[1] = m1 * 2;
                marbles[2] = m2 - m1;
                Arrays.sort(marbles);
                min = Math.min(min, minStep(marbles, dp));
            }

            dp[m0][m1][m2] = min != Integer.MAX_VALUE ? min + 1 : Integer.MAX_VALUE;
            return dp[m0][m1][m2];
        }
    }
}
