package com.haibo.yan.algorithm.array;

public class JumpGameII {
    /**
     * Given an array of non-negative integers, you are initially positioned at the first index of the array.
     *
     * Each element in the array represents your maximum jump length at that position.
     *
     * Your goal is to reach the last index in the minimum number of jumps.
     *
     * Example:
     *
     * Input: [2,3,1,1,4]
     * Output: 2
     * Explanation: The minimum number of jumps to reach the last index is 2.
     *     Jump 1 step from index 0 to 1, then 3 steps to the last index.
     */
    public int jump(int[] nums) {
        int[]steps = new int[nums.length];
        for (int i = 0; i < steps.length; i++) {
            steps[i] = nums.length;
        }
        steps[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j < nums.length) {
                    steps[i+j] = Integer.min(steps[i+j], steps[i]+1);
                }
            }
        }
        return steps[nums.length - 1];
    }
}
