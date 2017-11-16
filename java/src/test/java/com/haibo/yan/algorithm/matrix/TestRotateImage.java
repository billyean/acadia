package com.haibo.yan.algorithm.matrix;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestRotateImage {
    @DataProvider
    public Object[][] images() {
        return new Object[][]{
                {new int[][]{
                        {1,2,3}, {4,5,6}, {7,8,9}
                },new int[][]{
                        {7,4,1}, {8,5,2}, {9,6,3}
                }},
                {new int[][]{
                        {5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}
                },new int[][]{
                        {15, 13, 2, 5}, {14, 3, 4, 1}, {12, 6, 8, 9}, {16, 7, 10, 11}
                }}
        };
    }

    @Test(dataProvider = "images")
    public void testRotate(int[][] matrix, int[][] afterRotated) {
        new RotateImage().rotate(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                assertEquals(matrix[i][j], afterRotated[i][j]);
            }
        }
    }
}
