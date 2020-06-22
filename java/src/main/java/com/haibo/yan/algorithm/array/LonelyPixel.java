package com.haibo.yan.algorithm.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    /**
     * https://leetcode.com/problems/lonely-pixel-ii/
     * @param picture
     * @param N
     * @return
     */
    public int findBlackPixel(char[][] picture, int N) {
        int r = picture.length;
        int c = picture[0].length;


        HashMap<String, Integer> bws = new HashMap<>();
        List<String> rs = new ArrayList<>();
        int[] rows = new int[r];
        int[] cols = new int[c];


        for (int i = 0; i < r; i++) {
            StringBuilder b = new StringBuilder();
            for (int j = 0; j< c; j++) {
                if(picture[i][j] == 'B') {
                    rows[i]++;
                    cols[j]++;
                }
                b.append(picture[i][j]);
            }

            String s = b.toString();
            rs.add(s);
            bws.put(s, bws.getOrDefault(s, 0) + 1);
        }

        int res = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j< c; j++) {
                if(picture[i][j] == 'B') {
                    if (rows[i] == N && cols[j] == N && bws.get(rs.get(i)) == N) {
                        res++;
                    }
                }
            }
        }

        return res;
    }
}
