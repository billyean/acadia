/*
 * Copyright [2017] [Haibo(Tristan) Yan]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.haibo.yan.algorithm.binarysearch;

class RotateSearch {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int medium = (left  + right) / 2;

            if (target == nums[medium]) {
                return medium;
            } else if (nums[left] <= nums[medium]) {
                if (target < nums[medium] && target >= nums[left]) {
                    return search(nums, target, left, medium - 1);
                } else {
                    return search(nums, target, medium + 1, right);
                }
            } else {
                if (target > nums[medium] && target <= nums[right]) {
                    return search(nums, target, medium + 1, right);
                } else {
                    return search(nums, target, left, medium - 1);
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        RotateSearch s = new RotateSearch();
        System.out.println(s.search(new int[]{5, 1, 3}, 5));
    }
}
