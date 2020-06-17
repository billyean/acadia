package com.haibo.yan.algorithm.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/sort-the-matrix-diagonally/
 */
public class SortMatrixDiagonally {
    public int[][] diagonalSort(int[][] mat) {
        int M = mat.length, N = mat[0].length;
        Map<Integer, List<Integer>> diagonals = new HashMap<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int s = Integer.min(i, j);
                int xi = i - s, xj = j - s;
                int p = xi * N + xj;
                List<Integer> l = diagonals.getOrDefault(p, new ArrayList<>());
                l.add(mat[i][j]);
                diagonals.put(p, l);
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : diagonals.entrySet()) {
            int p = entry.getKey();
            List<Integer> l = entry.getValue();
            Collections.sort(l);
            int i = p / N, j = p % N;

            for (int v : l) {
                mat[i++][j++] = v;
            }
        }

        return mat;
    }
}
