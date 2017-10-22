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

public class NumSubarrayProductLessThanK {
    /**
     * 
     * see https://leetcode.com/problems/subarray-product-less-than-k
     *
     * Your are given an array of positive integers nums.
     * Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is
     * less than k.
     *
     * Example 1:
     * Input: nums = [10, 5, 2, 6], k = 100
     * Output: 8
     * Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6],
     * [5, 2, 6].
     * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k < 1)  return 0;

        int product = 1, left = -1, n = 0;

        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            while (left < i && product >= k)    product /= nums[++left];
            n += i - left;
        }

        return n;
    }
}
