package com.haibo.yan.algorithm.array;

/**
 * https://leetcode.com/problems/count-servers-that-communicate/
 */
public class CountServersCommunicate {
    public int countServers(int[][] grid) {
        int t = 0, l = 0;
        int r = grid.length;
        int c = grid[0].length;
        int[] rows = new int[r];
        int[] cols = new int[c];

        for (int i = 0 ; i < r; i++) {
            for (int j = 0 ; j < c; j++) {
                if(grid[i][j] == 1) {
                    rows[i]++;
                    cols[j]++;
                    t++;
                }
            }
        }

        for (int i = 0 ; i < r; i++) {
            for (int j = 0 ; j < c; j++) {
                if(grid[i][j] == 1 && rows[i] == 1 && cols[j] == 1) {
                    l++;
                }
            }
        }

        return t - l;
    }
}
