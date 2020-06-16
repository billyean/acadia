package com.haibo.yan.algorithm.array;

import java.util.TreeMap;

/**
 * https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
 */
public class DivideArrayKConsecutiveNumbers {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0)
            return false;
        TreeMap<Integer, Integer> valuePos = new TreeMap<>();

        for (int i = 0; i < nums.length; i++) {
            valuePos.put(nums[i], valuePos.getOrDefault(nums[i], 0) + 1);
        }

        while (!valuePos.isEmpty()) {
            int x = k;
            int key = valuePos.firstKey();
            int value = valuePos.get(key);
            if(--value == 0) {
                valuePos.remove(key);
            } else {
                valuePos.put(key, value);
            }
            key++;
            x--;
            while(valuePos.containsKey(key) && x > 0) {
                value = valuePos.get(key);
                if(--value == 0) {
                    valuePos.remove(key);
                } else {
                    valuePos.put(key, value);
                }
                key++;
                x--;
            }
            if (x > 0)
                return false;
        }

        return valuePos.isEmpty();
    }
}
