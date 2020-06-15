package com.haibo.yan.algorithm.array;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
 */
public class LongestContinuousSubarray {
    public int longestSubarray(int[] nums, int limit) {
        int i = 0;
        int j = 0;
        int x = 1;
        TreeMap<Integer, Set<Integer>> map = new TreeMap<>();
        Set<Integer> ns = new HashSet<>();
        ns.add(0);
        map.put(nums[0], ns);

        while (j < nums.length - 1) {
            int n = nums[++j];
            ns = map.getOrDefault(n, new HashSet<>());
            ns.add(j);
            map.put(n , ns);
            if (map.lastKey() - map.firstKey() > limit) {
                x = Integer.max(x, j - i);

                while(map.lastKey() - map.firstKey() > limit) {
                    n = nums[i];
                    ns = map.get(n);
                    ns.remove(i);
                    if(ns.isEmpty()) {
                        map.remove(n);
                    }
                    i++;
                }
            }
        }
        x = Integer.max(x, j - i + 1);

        return x;
    }
}
