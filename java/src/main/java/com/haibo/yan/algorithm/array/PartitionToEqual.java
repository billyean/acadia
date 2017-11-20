/*
 *
 *  * Copyright [2017] [Haibo(Tristan) Yan]
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *     http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.haibo.yan.algorithm.array;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

/**
 * https://leetcode.com/problems/partition-to-k-equal-sum-subsets
 * Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k
 * non-empty subsets whose sums are all equal.
 *
 * Example 1:
 * Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * Output: True
 * Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 * Note:
 *
 * 1 <= k <= len(nums) <= 16.
 * 0 < nums[i] < 10000.
 */
public class PartitionToEqual {
    /**
     * Greedy algorithm. Divide sum to K partition as average. then try to put every element into any partition as much
     * as possible.
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = IntStream.of(nums).sum();
        if (k < 1 || sum %  k != 0) {
            return false;
        }

        int avg = sum / k;

        if (IntStream.of(nums).anyMatch(v -> v > avg)) {
            return false;
        }

        Arrays.sort(nums);
        reverse(nums);
        Set<Map<Integer, Integer>> partitions = new HashSet<>();

        HashMap<Integer, Integer> o = new HashMap<>();
        o.put(avg, k);
        partitions.add(o);

        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];

            Set<Map<Integer, Integer>> newPartitions = new HashSet<>();

            for (Map<Integer, Integer> partition : partitions) {
                int[] allPossibles = partition.keySet().stream().filter(t -> t >= v).mapToInt(Integer::valueOf).toArray();
                for (int key : allPossibles) {
                    Map<Integer, Integer> next = new HashMap<>(partition);
                    int n = key - v;
                    if (next.get(key) == 1) {
                        next.remove(key);
                    } else {
                        next.put(key, next.get(key) - 1);
                    }
                    next.put(n, next.getOrDefault(n, 0) + 1);
                    newPartitions.add(next);
                }
            }
            if (newPartitions.size() == 0) {
                return false;
            }
            partitions = newPartitions;
        }
        return true;
    }

    private void reverse(int[] nums) {
        for (int i = 0;  i < nums.length / 2; i++) {
            int t = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = t;
        }
    }
}
