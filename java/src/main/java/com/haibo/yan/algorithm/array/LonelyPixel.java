package com.haibo.yan.algorithm.array;

public class LonelyPixel {
    /**
     * https://leetcode.com/problems/lonely-pixel-i/
     * @param picture
     * @return
     */
    public int findLonelyPixel(char[][] picture) {
        int r = picture.length;
        int c = picture[0].length;

        int[] rows = new int[r];
        int[] cols = new int[c];

        int sum = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (picture[i][j] == 'B') {
                    sum++;
                    rows[i]++;
                    cols[j]++;
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (picture[i][j] == 'B') {
                    if (rows[i] != 1 || cols[j] != 1) {
                        sum--;
                    }
                }
            }
        }

        return sum;

    }
}
