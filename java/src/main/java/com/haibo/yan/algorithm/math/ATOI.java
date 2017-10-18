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

import java.util.HashSet;
import java.util.Set;

/**
 * see https://leetcode.com/problems/string-to-integer-atoi
 *
 * Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself
 * what are the possible input cases.
 *
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to
 * gather all the input requirements up front.
 */
public class ATOI {
    public int myAtoi(String str) {
        if (str.length() == 0)
            return 0;

        char[] cs = str.trim().toCharArray();

        if (cs.length == 1) {
            if (cs[0] < '0' || cs[0] > '9')
                return 0;
            return cs[0] - '0';
        }

        boolean sign = true;
        int ds = cs[0] == '+' || cs[0] == '-' ? 1 : 0;

        if (ds == 1) {
           if (cs[0] == '-')
               sign = false;
        }

        long atoiValue = 0;

        for (int i = ds; i < cs.length; i++) {
            if (cs[i] < '0' || cs[i] > '9')
                break;
            int v = cs[i] - '0';
            atoiValue = atoiValue * 10 + v;

            if (sign) {
                if (atoiValue > Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
            } else {
                if (-atoiValue < Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;
            }
        }
        if (sign) {
            return (int)(atoiValue);
        } else {
            return (int)(-atoiValue);
        }
    }
}
