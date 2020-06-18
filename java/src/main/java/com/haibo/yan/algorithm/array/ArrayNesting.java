package com.haibo.yan.algorithm.array;

/**
 * https://leetcode.com/problems/array-nesting/
 */
public class ArrayNesting {
    public int arrayNesting(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                int t = 0;
                int j = i;
                while(nums[j] != -1) {
                    t++;
                    int x = nums[j];
                    nums[j] = -1;
                    j = x;
                }
                max = Integer.max(t, max);
            }
        }
        return max;
    }
}
