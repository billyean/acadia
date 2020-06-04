package com.haibo.yan.algorithm.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/diagonal-traverse-ii/
 */
public class DiagonalTraverse {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<int[]> x = new ArrayList<>();

        for (int i = 0; i < nums.size(); i++) {
            List<Integer> row = nums.get(i);
            for (int j =0; j < row.size(); j++) {
                x.add(new int[]{row.get(j), i + j, j});
            }
        }

        Collections.sort(x, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1]) {
                    return Integer.compare(a[2], b[2]);
                } else {
                    return Integer.compare(a[1], b[1]);
                }
            }
        });
        return x.stream().mapToInt(a -> a[0]).toArray();
    }
}
