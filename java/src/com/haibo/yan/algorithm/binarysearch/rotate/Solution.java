package com.haibo.yan.algorithm.binarysearch.rotate;

class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int medium = (left  + right) / 2;

            if (target == nums[medium]) {
                return medium;
            } else if (nums[left] <= nums[medium]) {
                if (target < nums[medium] && target >= nums[left]) {
                    return search(nums, target, left, medium - 1);
                } else {
                    return search(nums, target, medium + 1, right);
                }
            } else {
                if (target > nums[medium] && target <= nums[right]) {
                    return search(nums, target, medium + 1, right);
                } else {
                    return search(nums, target, left, medium - 1);
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.search(new int[]{5, 1, 3}, 5));
    }
}
