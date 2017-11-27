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

package com.haibo.yan.algorithm.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberDigitOne {
    public int countDigitOne(int n) {
        if (n < 1) { return 0;}
        if (n < 10) { return 1;}

        //At least two digits
        List<Map<Integer, Integer>> oneMap = digitsOne(String.valueOf(n).length() - 1);
        return 0;
    }

    private int countDigitOne(String s, boolean leadingOne, List<Map<Integer, Integer>> oneMap) {
        if (s.equals("0")) {
            return 0;
        }

        char[] cs = s.toCharArray();

        if (cs[0] == '1') {

        } else {

        }
        return 0;
    }


    // dp solution for calculate ones by length, assume length is not less than 1.
    private List<Map<Integer, Integer>> digitsOne(int len) {
        List<Map<Integer, Integer>> ones = new ArrayList<>();

        ones.add(new HashMap<>(){
            {put(1, 1);}
        });

        for (int i = 1; i < len; i++) {
            // Calculate all ones leading number by 2-9
            Map<Integer, Integer> nextLen = new HashMap<>();
            for (Map<Integer, Integer> m : ones) {
                m.forEach((k, v) -> {
                    // Calculate leading by 2-8 one digits
                    int n1 = nextLen.getOrDefault(k, 0) + 8 * v;
                    nextLen.put(k, n1);

                    // Calculate leading by 1 one digits
                    int n2 = nextLen.getOrDefault(k, 0) + v;
                    nextLen.put(k + 1, n2);
                });

            }
        }

        return ones;
    }
}
