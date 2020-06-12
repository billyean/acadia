package com.haibo.yan.algorithm.array;

public class UniquePaths {
    /**
     * https://leetcode.com/problems/unique-paths-ii/
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int r = obstacleGrid.length;
        int c = obstacleGrid[0].length;

        int[][] paths = new int[r][c];
        if (obstacleGrid[0][0] == 0) {
            paths[0][0] = 1;
            for (int i = 1; i < c && obstacleGrid[0][i] == 0; i++) {
                paths[0][i] = 1;
            }
            for (int i = 1; i < r && obstacleGrid[i][0] == 0; i++) {
                paths[i][0] = 1;
            }

            for (int i = 1; i < r; i++) {
                for (int j = 1; j < c; j++) {
                    if (obstacleGrid[i][j] == 0)
                        paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                }
            }
        }

        return paths[r-1][c-1];
    }
}
