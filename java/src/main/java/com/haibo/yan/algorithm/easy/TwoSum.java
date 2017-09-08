package com.haibo.yan.algorithm.easy;

import java.util.HashMap;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] twoSumIndices = new int[]{-1, -1};

        HashMap<Integer, Integer> minusMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int minus = target - nums[i];
            if (minusMap.containsKey(nums[i])) {
                System.out.println(minus);
                twoSumIndices[0] = minusMap.get(nums[i]);
                twoSumIndices[1] = i;
                return twoSumIndices;
            }
            minusMap.put(minus, i);
        }

        return twoSumIndices;
    }
}
