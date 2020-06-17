package com.haibo.yan.algorithm.array;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/split-array-with-equal-sum/
 */
public class SplitArrayWithEqualSum {
    public boolean splitArray(int[] nums) {
        int n = nums.length;
        int[] presum = new int[n];
        presum[0] = nums[0];
        for (int i = 1 ; i < n; i++) {
            presum[i] = presum[i - 1] + nums[i];
        }

        for (int j = 3; j < n - 3; j++) {
            HashSet<Integer> equal = new HashSet<>();
            for (int i = 1; i < j - 1; i++) {
                if (presum[i - 1] == presum[j - 1] - presum[i]) {
                    equal.add(presum[i - 1]);
                }
            }

            for (int k = j + 1; k < n - 1; k++) {
                if(presum[k - 1] - presum[j] == presum[n - 1] - presum[k] &&
                        equal.contains(presum[k - 1] - presum[j])) {
                    return true;
                }
            }
        }

        return false;
    }
}
