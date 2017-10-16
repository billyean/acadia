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

import static java.util.stream.Collectors.joining;

/**
 * see https://leetcode.com/problems/reverse-pairs
 *
 * Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2 * nums[j].
 * You need to return the number of important reverse pairs in the given array.
 * Example1:
 * Input: [1,3,2,3,1]
 * Output: 2
 * Example2:
 * Input: [2,4,3,5,1]
 * Output: 3
 * Note:
 * The length of the given array will not exceed 50,000.
 * All the numbers in the input array are in the range of 32-bit integer.
 *
 */
public class ReversePairs {
    public static int reversePairs(int[] nums) {
        // Shell sort solution


        return quickSort(nums, 0, nums.length - 1);

    }

    private static int quickSort(int[] nums, int start, int end) {
        if (start + 1 >= end)
            return 0;

        int p = start;

        int pairs = 0;

        int l = start + 1, r = end;

        while (l < r) {
            while (l < r && nums[l] <= nums[p]) {
                l++;
            }
            while (l < r && nums[r] >= nums[p]) {
                r--;
            }

            if (l < r) {
                pairs += swap(nums, l, r);
                l++;
                r--;
            }
        }

        if (nums[p] <= nums[l]) {
            l = l - 1;
        }

        pairs += swap(nums, p, l);

        System.out.println(IntStream.of(nums).mapToObj(String::valueOf).collect(joining(",", "[", "]")));
        System.out.printf("start = %d, l = %d, end = %d, pairs = %d\n", start, l, end, pairs);
        pairs += quickSort(nums, start, l - 1);
        pairs += quickSort(nums, l + 1, end);

        return pairs;
    }

    private static int swap(int[] nums, int i, int j) {
        System.out.printf("swap i = %d, j = %d\n", i, j);
        int pairs = 0;

        int t = nums[i];

        if (i != j && nums[i] > nums[j] * 2L) {
            pairs++;
        }

        for (int index = i + 1; index < j; index++) {
            if (nums[index]* 2L < nums[i]) {
                System.out.printf("1. index= %d, left = %d, right = %d\n", index, nums[index]* 2L, nums[i]);
                pairs++;
            }
            if (nums[index] > nums[j] * 2L) {
                pairs++;
            }
        }
        nums[i] = nums[j];
        nums[j] = t;
        return pairs;
    }

    public static void main(String[] args) {
        //int[] nums = {5, 4, 3, 2, 1};
        int[] nums = {-5 , -5};
        System.out.println(reversePairs(nums));
    }
}
