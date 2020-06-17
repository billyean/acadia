package com.haibo.yan.algorithm.array;

import java.util.List;

interface BinaryMatrix {
    int get(int row, int col);
    List<Integer> dimensions();
 };

/**
 * https://leetcode.com/problems/leftmost-column-with-at-least-a-one/
 */
public class LeftmostColumnWithAtLeastAOne {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> d = binaryMatrix.dimensions();
        int r = d.get(0);
        int c = d.get(1);

        int leftmost = c;
        for (int i = 0; i < r; i++) {
            int l = leftOne(i, binaryMatrix, 0, c - 1);
            if (l != -1) {
                leftmost = Integer.min(leftmost, l);
            }
        }

        return leftmost == c ? -1 : leftmost;
    }

    private int leftOne(int r, BinaryMatrix binaryMatrix, int start, int end) {
        if (start > end) {
            return -1;
        }

        int q = (start + end) / 2;

        int ans = binaryMatrix.get(r, q);

        if (ans == 1) {
            int p = leftOne(r, binaryMatrix, start, q -1);
            return p == -1 ? q : p;
        } else {
            return leftOne(r, binaryMatrix, q + 1, end);
        }
    }
}
