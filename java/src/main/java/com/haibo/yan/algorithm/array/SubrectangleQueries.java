package com.haibo.yan.algorithm.array;

/**
 * https://leetcode.com/problems/subrectangle-queries/
 */
public class SubrectangleQueries {
    private int[][] r;

    public SubrectangleQueries(int[][] rectangle) {
        this.r = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                this.r[i][j] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return this.r[row][col];
    }
}
