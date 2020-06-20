package com.haibo.yan.algorithm.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/submissions/
 */
public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int D) {
        int u = Arrays.stream(weights).sum();
        int n = weights.length;
        int l = u / D;
        while (l < u) {
            int m = (l + u) / 2;
            if (canLoad(weights, D, m)) {
                u = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    private boolean canLoad(int[] weights, int D, int capacity) {
        int t = 0;
        int s = 0;

        for (int i = 0; i < weights.length; i++) {
            if (s > capacity || weights[i] > capacity) {
                return false;
            }
            if (s == 0 && weights[i] > capacity) {
                return false;
            }
            if (s + weights[i] == capacity) {
                t++;
                s = 0;
            } else if (s + weights[i] > capacity) {
                t++;
                s = weights[i];
            } else {
                s += weights[i];
            }
        }

        t += s == 0 ? 0 : 1;
        return t <= D;
    }
}
