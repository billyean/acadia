package com.haibo.yan.algorithm.array;

/**
 * https://leetcode.com/problems/candy-crush/
 */
public class CandyCrush {
    public int[][] candyCrush(int[][] board) {
        int r = board.length;
        int c = board[0].length;

        boolean move = false;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int x = Math.abs(board[i][j]);
                if (x > 0) {
                    if (i > 0 && i < r - 1) {
                        if (Math.abs(board[i - 1][j]) == x && Math.abs(board[i + 1][j]) == x) {
                            board[i][j] = -x;
                            board[i - 1][j] = -x;
                            board[i + 1][j] = -x;
                            move = true;
                        }
                    }
                    if (j > 0 && j < c - 1) {
                        if (Math.abs(board[i][j - 1]) == x && Math.abs(board[i][j + 1]) == x) {
                            board[i][j] = -x;
                            board[i][j - 1] = -x;
                            board[i][j + 1] = -x;
                            move = true;
                        }
                    }
                }
            }
        }

        for (int j = 0; j < c; j++) {
            int m = r - 1;
            int n = r - 1;
            while (n >= 0) {
                if (board[n][j] > 0) {
                    board[m--][j] = board[n--][j];
                } else {
                    n--;
                }
            }

            while(m >= 0) {
                board[m--][j] = 0;
            }
        }

        return move ? candyCrush(board) : board;
    }
}
