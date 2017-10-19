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

public class RemoveDuplicates {
    /**
     * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new
     * length.
     * Do not allocate extra space for another array, you must do this in place with constant memory.
     *
     * For example,
     * Given input array nums = [1,1,2],
     *
     * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It
     * doesn't matter what you leave beyond the new length.
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int newLen = 0;

        if (nums.length > 0) {
            int pos = 0;
            int current = nums[pos++];
            newLen = 1;

            while (pos < nums.length) {
                if (nums[pos] != current) {
                    nums[newLen++] = nums[pos];
                    current = nums[pos];
                }
                pos++;
            }
        }
        return newLen;
    }

    /**
     * Follow up for "Remove Duplicates":
     * What if duplicates are allowed at most twice?
     *
     * For example,
     * Given sorted array nums = [1,1,1,2,2,3],
     * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't
     * matter what you leave beyond the new length.
     * @param nums
     */
    public int removeDuplicatesAtMostTwice(int[] nums) {
        int newLen = 0;

        if (nums.length > 0) {
            int pos1 = 0;
            int pos2 = pos1 + 1;

            while (pos2 < nums.length) {
                if (nums[pos2] != nums[pos1]) {
                    int clen = pos2 > pos1 + 1 ? 2 : 1;
                    if (pos1 != newLen) {
                        System.arraycopy(nums, pos1, nums, newLen, clen);
                    }
                    newLen += clen;
                    pos1 = pos2;
                    pos2 = pos1 + 1;
                } else {
                    pos2++;
                }
            }

            int clen = pos1 < nums.length - 1 ? 2 : 1;
            if (pos1 != newLen) {
                System.arraycopy(nums, pos1, nums, newLen, clen);
            }
            newLen += clen;
        }
        return newLen;
    }

}
