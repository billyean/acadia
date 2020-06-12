package com.haibo.yan.algorithm.array;

import java.util.TreeMap;

/**
 * https://leetcode.com/problems/array-of-doubled-pairs/
 */
public class ArrayOfDoubledPairs {
    public boolean canReorderDoubled(int[] A) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int n : A) {
            int v = map.getOrDefault(n, 0) + 1;
            map.put(n, v);
        }
        map.remove(0);

        while(!map.isEmpty()) {
            int k = map.firstKey();
            int v = map.get(k);
            map.remove(k);

            if (k < 0 && k % 2 != 0) {
                return false;
            }
            int kh = k < 0 ? k / 2 : k * 2;
            int vh = map.getOrDefault(kh, 0);
            if (vh < v) {
                return false;
            } else if (vh == v) {
                map.remove(kh);
            } else {
                map.put(kh, vh - v);
            }
        }

        return true;
    }
}
