package com.haibo.yan.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/
 */
public class FindAllDuplicatesArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int v = Math.abs(nums[i]) - 1;
            if (nums[v] < 0) {
                l.add(Math.abs(nums[i]));
            }
            if(nums[v] > 0) nums[v] = -nums[v];
        }

        return l;
    }
}
