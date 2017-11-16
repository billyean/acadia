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
    public int search1(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        return search1(nums, target, 0, nums.length - 1);
    }

    private int search1(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int medium = (left  + right) / 2;

            if (target == nums[medium]) {
                return medium;
            } else if (nums[left] <= nums[medium]) {
                if (target < nums[medium] && target >= nums[left]) {
                    return search1(nums, target, left, medium - 1);
                } else {
                    return search1(nums, target, medium + 1, right);
                }
            } else {
                if (target > nums[medium] && target <= nums[right]) {
                    return search1(nums, target, medium + 1, right);
                } else {
                    return search1(nums, target, left, medium - 1);
                }
            }
        }

        return -1;
    }

    public int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        return search2(nums, target, 0, nums.length - 1);
    }

    private int search2(int[] nums,int target,  int s, int e) {
        System.out.printf("s = %d, e = %d\n", s, e);
        if (s > e)
            return -1;

        int m = (s + e) / 2;

        if (nums[m] == target) {
            return m;
        } else if (nums[m] > target) {
            if (nums[s] < nums[m] && target >= nums[s] || nums[s] > nums[m]) {
                return search2(nums,target,  s, m - 1);
            } else {
                return search2(nums,target,  m + 1, e);
            }
        } else {
            if (nums[m] < nums[e] && target <= nums[e] || nums[m] > nums[e]) {
                return search2(nums,target,  m + 1, e);
            } else {
                return search2(nums,target,  s, m - 1);
            }
        }
    }

    public boolean isInList(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return false;

        return isInList(nums, target, 0, nums.length - 1);
    }

    private boolean isInList(int[] nums,int target,  int s, int e) {
        if (s > e)
            return false;

        int m = (s + e) / 2;

        if (nums[m] == target) {
            return true;
        } else if (nums[s] == nums[m] && nums[e] == nums[m]) {
            return isInList(nums, target, s, m - 1) || isInList(nums, target, m + 1, e);
        } else if (nums[m] > target) {
            if (nums[s] < nums[m] && target >= nums[s] || nums[s] > nums[m]) {
                return isInList(nums, target, s, m - 1);
            } else {
                return isInList(nums, target, m + 1, e);
            }
        } else {
            if (nums[m] < nums[e] && target <= nums[e] || nums[m] > nums[e]) {
                return isInList(nums, target, m + 1, e);
            } else {
                return isInList(nums, target, s, m - 1);
            }
        }
    }
}
