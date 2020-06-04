package com.haibo.yan.algorithm.array;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/make-two-arrays-equal-by-reversing-sub-arrays/
 */
public class IsSame {
    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer, Integer> x = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            x.put(arr[i], x.getOrDefault(arr[i], 0) + 1);
        }

        for (int i = 0; i < target.length; i++) {
            if (!x.containsKey(target[i])) {
                return false;
            }
            int n = x.get(target[i]);
            if (n > 1) {
                x.put(target[i], n - 1);
            } else {
                x.remove(target[i]);
            }
        }
        return x.isEmpty();
    }
}
