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

package com.haibo.yan.algorithm.string;

import java.util.Arrays;
import java.util.Comparator;

public class HugeNumber {
    String hugeNumber(String[] nums) {
        if (nums == null || nums.length == 0)
            return "";
        Comparator<String> cmp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                int l1 = o1.length(), l2 = o2.length();

                if (l1 > l2) {
                    if (o1.substring(0, l2).equals(o2) && !o1.startsWith("0")) {
                        return compare(o1.substring(l2), o2);
                    }
                }

                if(l1 < l2) {

                    if (o2.substring(0, l1).equals(o1) && !o2.startsWith("0")) {
                        return compare(o1, o2.substring(l1));
                    }
                }


                return o1.compareTo(o2);
            }
        };

        Arrays.sort(nums, cmp);
        StringBuilder s = new StringBuilder();
        for (String n : nums) {
            s.insert(0, n);
        }


        int leadingZero = 0;
        while (leadingZero < s.length() && s.substring(leadingZero, leadingZero + 1).equals("0")) {
            leadingZero++;
        }

        return s.substring(leadingZero, s.length());
    }
}
