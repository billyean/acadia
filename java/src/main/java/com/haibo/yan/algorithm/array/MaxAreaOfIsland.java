package com.haibo.yan.algorithm.array;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/max-area-of-island/
 */
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {

        int r = grid.length;
        int c = grid[0].length;

        int[][] moves = new int[][]{
                {0, -1},
                {0, 1},
                {-1, 0},
                {1, 0}
        };

        int max = 0;
        for (int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    Stack<List<Integer>> stack = new Stack<>();
                    stack.push(Arrays.asList(i, j));
                    grid[i][j] = -1;
                    int island = 1;
                    while (!stack.isEmpty()) {
                        List<Integer> cord = stack.pop();
                        for (int[] move : moves) {
                            int ni = cord.get(0) + move[0];
                            int nj = cord.get(1) + move[1];
                            if (ni >= 0 && ni < r && nj >= 0 && nj < c) {
                                if (grid[ni][nj] == 1) {
                                    stack.add(Arrays.asList(ni, nj));
                                    grid[ni][nj] = -1;
                                    island++;
                                }
                            }
                        }
                    }
                    max = Integer.max(island, max);
                }
            }
        }

        return max;
    }
}
