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

package com.haibo.yan.algorithm.math;

import java.util.*;


public class Sum {
    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * Example:
     * Given nums = [2, 7, 11, 15], target = 9,
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     *
     */
    public int[] twoSum(int[] nums, int target) {
        int[] twoSumIndices = new int[]{-1, -1};

        HashMap<Integer, Integer> minusMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int minus = target - nums[i];
            if (minusMap.containsKey(nums[i])) {
                System.out.println(minus);
                twoSumIndices[0] = minusMap.get(nums[i]);
                twoSumIndices[1] = i;
                return twoSumIndices;
            }
            minusMap.put(minus, i);
        }

        return twoSumIndices;
    }

    /**
     * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets
     * in the array which gives the sum of zero.
     * Note: The solution set must not contain duplicate triplets.
     * For example, given array S = [-1, 0, 1, 2, -1, -4],
     * A solution set is:
     * [
     * [-1, 0, 1],
     * [-1, -1, 2]
     * ]
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int v = -nums[i];
            int s = i + 1, t = nums.length - 1;

            while (s < t) {
                int sum = nums[s] + nums[t];
                if (sum > v) {
                    t--;
                } else if (sum < v) {
                    s++;
                } else {
                    set.add(Arrays.asList(nums[i], nums[s], nums[t]));
                    s++;
                    t--;
                }
            }
        }
        return new ArrayList<List<Integer>>(set);
    }

    /**
     * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
     * Return the sum of the three integers. You may assume that each input would have exactly one solution.
     * For example, given array S = {-1 2 1 -4}, and target = 1.
     * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        long distance = Long.MAX_VALUE;

        int current = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            int v = target - nums[i];
            int s = i + 1, t = nums.length - 1;

            while (s < t) {
                int sum = nums[s] + nums[t];
                int cd = Math.abs(v - sum);
                if (cd < distance) {
                    current = nums[i] + sum;
                    distance = cd;
                }
                if (sum > v) {
                    t--;
                } else if (sum < v) {
                    s++;
                } else {
                    return target;
                }
            }
        }

        return current;
    }
}
