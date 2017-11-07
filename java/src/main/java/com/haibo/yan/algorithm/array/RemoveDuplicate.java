package com.haibo.yan.algorithm.array;

/**
 * see https://leetcode.com/problems/remove-element
 *
 * Given an array and a val, remove all instances of that val in place and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * Example:
 * Given input array nums = [3,2,2,3], val = 3
 * Your function should return length = 2, with the first two elements of nums being 2.
 */
public class RemoveDuplicate {
    public static int removeElement(int[] nums, int val) {
        int newLen = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[newLen++] = nums[i];
            }
        }

        return newLen;
    }
}
