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

package com.haibo.yan.algorithm.easy;

public class RemoveDuplicates {
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

    public static void main(String[] args) {
        int[] testData = new int[]{1 , 1, 1, 2, 3, 3, 4, 4, 4, 4, 4 , 4, 5};

        int noDupLen = new RemoveDuplicates().removeDuplicates(testData);

        System.out.println("New len = " + noDupLen);

        for (int i = 0; i < noDupLen; i++) {
            System.out.println(String.format("data[%d] = %d", i, testData[i]));
        }
    }

}
