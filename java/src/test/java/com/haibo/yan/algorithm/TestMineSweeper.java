package com.haibo.yan.algorithm;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class TestMineSweeper {
    @DataProvider
    public Object[][] mine1() {
        return new Object[][]{
            {new int[][]{
                {0,0,0,0,0},
                {0,1,1,1,0},
                {0,1,9,1,0},
                {0,1,1,1,0},
                {0,0,0,0,0}
            }, true}
        };
    }

    @Test(dataProvider = "mine1")
    public void testSweeper1(int[][] matrix, boolean expected) {
        assertEquals(new MineSweeper().minesweeper1(matrix), expected);
    }


    @DataProvider
    public Object[][] mine2() {
        return new Object[][]{
            {new int[][]{
                {0,1,9,1},
                {0,1,2,2},
                {0,0,1,9},
                {0,0,1,1}
            }, new boolean[][]{
                {false, false, false, false},
                {false, false, false, false},
                {false, false, false, false},
                {false, false, false, false}
            }, new int[][]{
                {3, 0}
            }, new boolean[][]{
                {true, true, false, false},
                {true, true, true, false},
                {true, true, true, false},
                {true, true, true, false}
            }}
        };
    }

    @Test(dataProvider = "mine2")
    public void testSweeper2(int[][] gameboard, boolean[][] opening, int[][] moves, boolean[][] expected) {
        boolean[][] actual = new MineSweeper().minesweeper2(gameboard, opening, moves);
        assertEquals(actual.length, expected.length);
        if (actual.length > 0) {
            assertEquals(actual[0].length, expected[0].length);
            if (actual[0].length > 0) {
                for (int i = 0; i < actual.length; i++) {
                    for (int j = 0; j < actual[i].length; j++) {
                        assertEquals(String .format("actual[%d][%d] = %b, expected[%d][%d] = %b",
                            i, j, actual[i][j], i, j, expected[i][j]), actual[i][j], expected[i][j]);
                    }
                }
            }
        }
    }
}
