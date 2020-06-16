package com.haibo.yan.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/queens-that-can-attack-the-king/
 */
public class QueensCanAttackKing {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> can = new ArrayList<>();
        HashMap<Integer, List<Integer>> qp = new HashMap<>();
        for (int[] queen : queens) {
            int r = queen[0];
            int c = queen[1];
            int x = r * 8 + c;
            qp.put(x, Arrays.stream(queen).boxed().collect(Collectors.toList()));
        }

        int[][] moves = new int[][]{
                {-1, 0},
                {1, 0},
                {0, 1},
                {0, -1},
                {1, 1},
                {-1, -1},
                {1, -1},
                {-1, 1}
        };

        for (int[] move : moves) {
            int[] kp = new int[]{king[0], king[1]};
            kp[0] += move[0];
            kp[1] += move[1];
            while (kp[0] < 8 && kp[0] >= 0 && kp[1] < 8 && kp[1] >= 0) {
                int r = kp[0];
                int c = kp[1];
                int x = r * 8 + c;
                if (qp.containsKey(x)) {
                    can.add(qp.get(x));
                    break;
                }
                kp[0] += move[0];
                kp[1] += move[1];
            }
        }
        return can;
    }
}
