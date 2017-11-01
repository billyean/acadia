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

import java.util.stream.IntStream;

public class PartitionKSubsets {
    /**
     *  Given an array of integers nums and a positive integer k, find whether it's
     *  possible to divide this array into k non-empty subsets whose sums are all equal.
     *
     *  Example 1:
     *  Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
     *  Output: True
     *  Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums.length < k)
            return false;
        int total = IntStream.of(nums).sum();

        if (total % k != 0)
            return false;

        int average = total / k;

        return false;
    }
}
