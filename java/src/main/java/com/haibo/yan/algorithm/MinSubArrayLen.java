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

package com.haibo.yan.algorithm;

public class MinSubArrayLen {
    /**
     * Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which
     * the sum ≥ s. If there isn't one, return 0 instead.
     * For example, given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has the minimal length of 2 under the
     * problem constraint.
     *
     * We can use 2 points to mark the left and right boundaries of the sliding window. When the sum is greater than the
     * target, shift the left pointer; when the sum is less than the target, shift the right pointer.
     *
     * @param s a positive number
     * @param nums a positive numbers array
     * @return min numbers of subarray elements add up to given value s.
     */
    public static int minSubArrayLen(int s, int[] nums) {
        int left = 0, right = 0;

        int sum = 0;

        int min = Integer.MAX_VALUE;

        while (sum >= s || right < nums.length) {
           if (sum < s) {
               sum += nums[right++];
           } else if (sum > s) {
               sum -= nums[left++];
           } else {
               int step = right - left;
               if (step < min) {
                   min = step;
               }
               sum -= nums[left++];
           }
        }

        return min;
    }
}
