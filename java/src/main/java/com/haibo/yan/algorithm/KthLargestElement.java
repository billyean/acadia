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

package com.haibo.yan.algorithm;

import java.util.concurrent.ThreadLocalRandom;

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        return 0;
    }

    public int findKthLargest(int[] nums, int k, int start, int end) {
        if (start == end - 1) {
            return nums[start];
        }

        int s = start + 1, e = end - 1;
        int pivot = nums[start];
        while (s < e) {
            while (s < e && nums[s] < pivot) {
                s++;
            }
            while (s < e && nums[e] < pivot) {
                e--;
            }

            if (s < e) {
                swap(nums, s++, e--);
            } else {
//                if (end - )
            }
        }

        return 0;
    }

    private void shuffle(int[] nums) {
        for (int i = nums.length; i > 0; i--) {
            int ri = ThreadLocalRandom.current().nextInt(i);
            if (ri != i - 1) {
                swap(nums, ri, i - 1);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
}
