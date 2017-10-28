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

package com.haibo.yan.algorithm.string;

public class Interleave {
    /**
     * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
     *
     * Example,
     * Given:
     *
     * s1 = "aabcc",
     * s2 = "dbbca",
     * When s3 = "aadbbcbcac", return true.
     * When s3 = "aadbbbaccc", return false.
     *
     * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static int isInterleave(String a, String b, String c) {
        if (a.length() + b.length() != c.length()) {
            return 0;
        }

        char[] ca = a.toCharArray(), cb = b.toCharArray(), cc = c.toCharArray();

        for(int i = 0, j = 0; i < ca.length || j < cb.length; ) {
            if (i < ca.length && j < cb.length) {
                if (ca[i] == cb[j]) {
                    char cv = ca[i];
                    int in = i, jn = j, nn = i + j;
                    while (in < ca.length && ca[in] == cv){
                        in++;
                    }

                    while (jn < cb.length && cb[jn] == cv){
                        jn++;
                    }

                    while (nn < cc.length && cc[nn] == cv){
                        nn++;
                    }

                    if (nn > in + jn) {
                        return 0;
                    } else if (nn <= in + jn) {
                        if (in == ca.length && jn == cb.length) {
                            return 0;
                        }
                        if (in == ca.length || cc[nn] == ca[in]) {
                            i = in;
                            j = nn - i;
                        } else if (jn == cb.length || cc[nn] == cb[jn]) {
                            j = jn;
                            i = nn - j;
                        } else {
                            return 0;
                        }
                    }
                } else if (ca[i] == cc[i + j]) {
                    i++;
                } else if (cb[j] == cc[i + j]) {
                    j++;
                } else {
                    return 0;
                }
            } else if (i < ca.length) {
                if (ca[i] != cc[i + j]) {
                    return 0;
                }
                i++;
            } else {
                if (cb[j] != cc[i + j]) {
                    return 0;
                }
                j++;
            }
        }

        return 1;
    }
}
