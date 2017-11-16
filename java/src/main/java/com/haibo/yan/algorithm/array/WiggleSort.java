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

import java.util.Arrays;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

/**
 *
 * Given an unsorted array nums, reorder it such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
 *
 * Example:
 * (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
 * (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
 *
 * Note:
 * You may assume all input has valid answer.
 *
 * Follow Up:
 * Can you do it in O(n) time and/or in-place with O(1) extra space?
 */
public class WiggleSort {
    /**
     * O(nlog(n)) solution.
     * @param nums
     */
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i += 2) {
            // start from 2nd elements, swap every pair
            if (i + 1 < nums.length) {
                int t = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = t;
            }
        }
    }

    /**
     * O(n) solution.
     * @param nums
     */
    public void wiggleSortN(int[] nums) {
        if (nums.length >= 2) {
            Arrays.sort(nums);
            boolean flag = true;

            int i = 1, j = nums.length - 1;

            while (i < j && nums[i] != nums[i + 1] && nums[j] != nums[j - 1]) {
                if (flag) {
                    swap(nums, i, j);
                }
                i++;
                j--;
                flag = !flag;
            }
        }
    }

    private void moveDiff(int[] nums, int i) {
        int j = i;
        while (j < nums.length && nums[j] == nums[i - 1]) {
            j++;
        }

        if (j != i && j < nums.length) {
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j) {
        System.out.printf("Swap %d and %d\n", i, j);
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
