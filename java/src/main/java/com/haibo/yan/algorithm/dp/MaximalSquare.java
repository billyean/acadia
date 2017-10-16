/*
 * Copyright [2017] [Haibo(Tristan) Yan]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.haibo.yan.algorithm.dp;

/**
 * See https://leetcode.com/problems/maximal-square
 *
 * Given a 2D binary matrix filled with 0's and 1's, findInTwo the largest square containing only 1's and return its area.
 *
 * For example, given the following matrix:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Return 4.
 */
public class MaximalSquare {
    /**
     * Typical DP problem, when calculate current square, look left, above and left-above, minimum of three plus 1 is
     * the max square it can reach.
     *
     * @param matrix a 2D binary matrix filled with 0's and 1's
     * @return the area of the largest square containing only 1.
     */
    public static int maxSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int row = matrix.length, col = matrix[0].length;

        int[][] dp = new int[row][col];

        int maxSquare = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                        if (maxSquare < 1) {
                            maxSquare = 1;
                        }
                    } else {
                        int max = Integer.min(dp[i - 1][j - 1], Integer.min(dp[i - 1][j], dp[i][j - 1]));
                        dp[i][j] = max + 1;
                        if (maxSquare < dp[i][j]) {
                            maxSquare = dp[i][j];
                        }
                    }
                }
            }
        }

        return maxSquare * maxSquare;
    }
}
