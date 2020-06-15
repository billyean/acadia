package com.haibo.yan.algorithm.array;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/subarray-sum-equals-k/
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> presum = new HashMap<>();
        presum.put(0, 1);
        int sum = 0;
        int c = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            c += presum.getOrDefault(sum - k, 0);
            presum.put(sum, presum.getOrDefault(sum, 0) + 1);
        }

        return c;
    }
}
