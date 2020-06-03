package com.haibo.yan.algorithm.array;

import java.util.*;

/**
 * https://leetcode.com/problems/maximum-width-ramp/
 */
public class MaximumWidthRamp {
    public int maxWidthRamp(int[] A) {
        List<int[]> l = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {
            int[] ar = new int[]{i, A[i]};
            l.add(ar);
        }

        Collections.sort(l, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1]) {
                    return Integer.compare(a[0], b[0]);
                } else {
                    return Integer.compare(a[1], b[1]);
                }
            }
        });

        int p = l.get(0)[0];

        int max  = 0;

        for (int[] v: l) {
            if (v[0] < p) {
                p = v[0];
            } else if (v[0] > p) {
                max = Integer.max(max, v[0] - p);
            }
        }

        return max;
    }

    public int maxWidthRamp1(int[] A) {
        if (A == null || A.length <= 1) return 0;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            if (stack.isEmpty() || A[i] < A[stack.peek()]) {
                stack.push(i);
            }
        }
        for (int j = A.length - 1; j > res; j--) {
            while (!stack.isEmpty() && A[j] >= A[stack.peek()]){
                res = Math.max(res, j - stack.pop());
            }
        }
        return res;
    }
}
