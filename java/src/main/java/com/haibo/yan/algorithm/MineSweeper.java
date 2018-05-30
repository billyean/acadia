package com.haibo.yan.algorithm;

import java.util.Stack;

public class MineSweeper {
    private static final int[][] NEIGHBORS = new int[][]{
        {-1, -1},
        {-1, 0},
        {-1, 1},
        {0, -1},
        {0, 1},
        {1, -1},
        {1, 0},
        {1, 1}
    };

    // Each cell of Minesweeper gameboard can be:
    //
    //a mine (appears as 9)
    //or a number representing the number of mines in its surrounding cells
    //(a cell is considered as surrounding another cell when this cell meets
    // that cell on at least 1 corner) (appears as 0 - 8)
    //Your task is to check whether a gameboard is a valid gameboard.
    //
    //Example
    //For
    //
    //gameboard = [[0, 1, 9, 1],
    //             [0, 1, 1, 1],
    //             [0, 0, 0, 0]]
    //the output should be
    //minesweeper1(gameboard) = true.
    //
    //Input/Output
    //
    //[execution time limit] 3 seconds (java)
    //
    //[input] array.array.integer gameboard
    //
    //Guaranteed constraints:
    //3 ≤ gameboard.length ≤ 100,
    //3 ≤ gameboard[i].length ≤ 100,
    //gameboard[i].length = gameboard[j].length,
    //0 ≤ gameboard[i][j] ≤ 9.
    //
    //[output] boolean
    boolean minesweeper1(int[][] gameboard) {
        int r = gameboard.length;
        int c = r == 0 ? 0 : gameboard[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int v = gameboard[i][j];

                if (v != 9) {
                    int b = 0;
                    for (int[] neigh: NEIGHBORS) {
                        int ni = i + neigh[0];
                        int nj = j + neigh[1];
                        if (ni >= 0 && ni < r && nj >= 0 && nj < c && gameboard[ni][nj] == 9) {
                            b++;
                        }
                    }

                    if (b != v) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    // The second challenge of the minesweeper series!
    // As you click on a cell of the gameboard, there are 3 cases that thing
    // will happen:
    // You clicked on a cell that contains a non-zero number (from 1 to 8). At
    // that case, only that cell will open.
    // You clicked on a cell that contains a zero. At that case, 8 surrounding
    // cells will also open. And if any of those 8 is a zero, its surrounding
    // cell will continue to be opened.
    // You clicked on a mine (number 9). Boom, you lose immediately.
    // Given a gameboard consisting of either a 9 (a mine) or a number from 0 to
    // 8 (the number of mines surrounding), a boolean opening matrix tells us
    // whether a cell is opened or not, and an array of moves on that gameboard.
    // Your task is to return a boolean matrix of the gameboard's state after
    // these moves. If there is a move that makes the player loses, return an
    // empty matrix.
    //
    //Example For
    // gameboard = [[0,1,9,1],
    //             [0,1,2,2],
    //             [0,0,1,9],
    //             [0,0,1,1]]
    // opening = [[false,false,false,false],
    //           [false,false,false,false],
    //           [false,false,false,false],
    //           [false,false,false,false]]
    // and moves = [[3,0]], the output should be
    //
    // minesweeper2(gameboard, opening, moves) =
    //[[true,true,false,false],
    // [true,true,true,false],
    // [true,true,true,false],
    // [true,true,true,false]]
    boolean[][] minesweeper2(int[][] gameboard, boolean[][] opening, int[][] moves) {
        for (int[] move: moves) {
            int r = move[0], c = move[1];
            if (!opening[r][c]) {
                if (gameboard[r][c] == 9) {
                    return new boolean[0][0];
                }

                if (gameboard[r][c] == 0) {
                    openZeroes(gameboard, opening, r, c);
                } else {
                    opening[r][c] = true;
                }
            }
        }
        return opening;
    }

    private void openZeroes(int[][] gameboard, boolean[][] opening, int i, int j) {
        Stack<int[]> stack = new Stack();
        int r = gameboard.length;
        int c = r == 0 ? 0 : gameboard[0].length;
        if (!opening[i][j]) {
            opening[i][j] = true;
            stack.push(new int[]{i, j});

            while (!stack.isEmpty()) {
                int[] cp = stack.pop();
                int ci = cp[0], cj = cp[1];
                for (int[] neigh: NEIGHBORS) {
                    int ni = ci + neigh[0];
                    int nj = cj + neigh[1];
                    if (ni >= 0 && ni < r && nj >= 0 && nj < c
                        && !opening[ni][nj]) {
                        opening[ni][nj] = true;
                        if (gameboard[ni][nj] == 0) {
                            stack.push(new int[]{ni, nj});
                        }
                    }
                }
            }
        }
    }
}
