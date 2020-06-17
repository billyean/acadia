package com.haibo.yan.algorithm.array;

/**
 * https://leetcode.com/problems/decrease-elements-to-make-array-zigzag/
 */
public class DecreaseElementsToMakeArrayZigzag {
    public int movesToMakeZigzag(int[] nums) {
        int ogm = 0, egm = 0;

        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            int m = Integer.min(i == 0 ? Integer.MAX_VALUE : nums[i - 1],
                    i == nums.length - 1 ? Integer.MAX_VALUE : nums[i + 1]);
            if(i % 2 == 0) {
                ogm += v < m ? 0 : v - m  + 1;
            } else {
                egm += v < m ? 0  : v - m  + 1;
            }
        }
        return Integer.min(ogm, egm);
    }
}
