/*
 * Copyright (c) [2017] [Haibo(Tristan) Yan]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.haibo.yan.algorithm.array;

/**
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 */
public class SearchRange {
    public final static int[] NOT_FOUND = {-1, -1};

    public int[] searchRange(int[] nums, int target) {
        return searchRange(nums, 0, nums.length, 0, target);
    }


    /**
     *
     * @param nums
     * @param s
     * @param t
     * @param d
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int s, int t, int d, int target) {
        System.out.println("s = %d, s = %");
        if (s < t) {
            int m = (s + t) / 2;
            if (target == nums[m]) {
                if (d == 0) {
                    int left = m, right = m;
                    int[] leftR = searchRange(nums, s, m - 1, 1, target);
                    int[] rightR = searchRange(nums, s, m - 1, 1, target);
                    if (leftR != NOT_FOUND) {
                        left = leftR[0];
                    }
                    if (rightR != NOT_FOUND) {
                        right = rightR[0];
                    }
                    return new int[]{left, right};
                } else if (d == 1){
                    int left = m, right = t;
                    int[] leftR = searchRange(nums, s, m - 1, d, target);
                    if (leftR != NOT_FOUND) {
                        left = leftR[0];
                    }
                    return new int[]{left, right};
                } else {
                    int left = s, right = m;
                    int[] rightR = searchRange(nums, m + 1, t, d, target);
                    if (rightR != NOT_FOUND) {
                        right = rightR[0];
                    }
                    return new int[]{left, right};
                }
            } else if (target < nums[m]) {
                return searchRange(nums, s, m - 1, d, target);
            } else {
                return searchRange(nums, m + 1, t, d, target);
            }
        } else {
            return NOT_FOUND;
        }
    }
}
