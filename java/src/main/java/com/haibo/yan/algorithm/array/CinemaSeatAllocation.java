package com.haibo.yan.algorithm.array;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/cinema-seat-allocation/
 */
public class CinemaSeatAllocation {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, Integer> rowReversed = new HashMap<>();
        for (int[] seat : reservedSeats) {
            int r = seat[0];
            int c = seat[1];
            int allo = rowReversed.getOrDefault(r, 0);
            if (c >= 2 && c <= 3) {
                allo|= 1;
            }
            if (c >= 4 && c <= 5) {
                allo |= 3;
            }
            if (c >= 6 && c <= 7) {
                allo |= 12;
            }
            if (c >= 8 && c <= 9) {
                allo |= 8;
            }
            rowReversed.put(r, allo);
        }

        int sum = n * 2;
        for (int i : rowReversed.values()) {
            if (i == 1 || i == 3 || i == 9 || i == 8 || i == 12) {
                sum -= 1;
            } else if (i != 0) {
                sum -= 2;
            }
        }

        return sum;
    }
}
