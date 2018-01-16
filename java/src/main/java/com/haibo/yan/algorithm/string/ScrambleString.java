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

import java.util.HashMap;

public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        if (s1.equals(s2)) {
            return true;
        }

        HashMap<Character, Integer> hm1 = new HashMap<>(), hm2 = new HashMap<>();

        for (char c: s1.toCharArray()) {
            hm1.put(c, hm1.getOrDefault(c, 0) + 1);
        }

        for (char c: s2.toCharArray()) {
            hm2.put(c, hm2.getOrDefault(c, 0) + 1);
        }

        return hm1.equals(hm2);

//        return isScramble(s1.toCharArray(), s2.toCharArray(), 0, s1.length());
    }

//    public boolean isScramble(char[] cs1, char[] cs2, int i, int j) {
//        if (i > j - 2) {
//            return false;
//        }
//
//        if (cs1[j - 1] == cs2[j - 1]) {
//            return isScramble(cs1, cs2, i, j - 1);
//        }
//
//        if (cs1[i] == cs2[i]) {
//            return isScramble(cs1, cs2, i + 1, j);
//        }
//
//        return isRotate(cs1, cs2, i, j);
//    }
//
//    public boolean isRotate(char[] cs1, char[] cs2, int i, int j) {
//        String s1 = new String(cs1, i, j - i);
//        String s2 = new String(cs2, i, j - i);
//        return (s1 + s1).indexOf(s2) >= 0;
//    }
}
