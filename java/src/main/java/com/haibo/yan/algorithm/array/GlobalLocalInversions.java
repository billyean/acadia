package com.haibo.yan.algorithm.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/global-and-local-inversions/
 */
public class GlobalLocalInversions {
    public boolean isIdealPermutation(int[] A) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0 ; i < A.length; i++) {
            if (A[i] != i) {
                hm.put(i, A[i]);
            }
        }

        List<Integer> keys = new ArrayList<>(hm.keySet());

        for (int key : keys) {
            if (hm.containsKey(key)) {
                int value = hm.get(key);
                int nvalue = hm.get(value);
                if (value == key + 1 && nvalue == key) {
                    hm.remove(key);
                    hm.remove(value);
                }
            }
        }

        if(hm.size() == 0) {
            return true;
        }

        return false;
    }
}
