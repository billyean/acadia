package com.haibo.yan.algorithm.array;

/**
 * https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/
 */
public class KLengthApart {
    public boolean kLengthApart(int[] nums, int k) {
        if (k == 0) {
            return true;
        }
        boolean atleat = true;

        int i = 0;
        while(i < nums.length && nums[i] == 0) {
            i++;
        }

        while (i < nums.length - 1) {
            int j = i + 1;
            while(j < nums.length && nums[j] == 0) {
                j++;
            }
            if(j < nums.length) {
                if (j - i <= k) {
                    return false;
                }
            }
            i = j;
        }

        return true;
    }
}
