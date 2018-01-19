/*
 *
 *  * Copyright [2018] [Haibo(Tristan) Yan]
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

public class ClosestPalindrome {
    public String nearestPalindromic(String n) {
        if (n.length() <= 1) {
            return n;
        }

        char[] cs = n.toCharArray();

        int j = cs.length - 1;

        while (j > 0) {
            if (cs[j] != '0')   break;
            j--;
        }

        if (j == 0 && cs[j] == '1') {
            char[] ncs = new char[cs.length - 1];
            for (int k = 0; k < ncs.length; k++) {
                ncs[k] = '9';
            }
            return new String(ncs);
        }


        for (int i = 0; i < cs.length >> 1; i++) {
            cs[cs.length - i - 1] = cs[i];
        }

        return new String(cs);
    }
}
