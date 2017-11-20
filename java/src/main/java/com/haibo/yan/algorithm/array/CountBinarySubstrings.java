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

package com.haibo.yan.algorithm.array;

public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int count = 0;
        char[] cs = s.toCharArray();

        int i0 = 0, i1 = 0;

        int up = 0;

        for(int i = 0; i < cs.length; i++) {
            if (cs[i] == '0') {
                switch (up) {
                    case 0:
                    case 2:
                        i0++;
                        break;
                    case 1:
                        if (i0 > 1 || i1 > 1) {
                            count += 2;
                        } else if (i0 == 1 && i1 == 1) {
                            count++;
                        } else if (i0 == 0) {

                        }
                        i0 = 0;
                        up = 2;
                        break;
                }
            } else {
                switch (up) {
                    case 0:
                    case 2:
                        i1++;
                        break;
                    case 1:
                        if (i0 > 1 || i1 > 1) {
                            count += 2;
                        } else {
                            count++;
                        }
                        i0 = 0;
                        up = 2;
                        break;
                }
            }
        }
        return count;
    }
}
