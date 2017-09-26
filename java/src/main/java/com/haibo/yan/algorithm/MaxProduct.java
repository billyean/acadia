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

package com.haibo.yan.algorithm;

/**
 * Created by hyan on 2/7/17.
 */
public class MaxProduct {
    public int maxProduct(String[] words) {
        int[] iw = new int[words.length];
        int[] lw = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            iw[i] = strPre(words[i]);
            lw[i] = words[i].length();
        }

        int max = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words.length; j++) {
                if ((iw[i] & iw[j]) == 0) {
                    int product = lw[i] * lw[j];
                    if (product > max) {
                        System.out.println("i = " + i + "\tj = " + j);
                        max = product;
                    }
                }
            }
        }
        return max;
    }

    private int strPre(String s) {
        char[] cs = s.toCharArray();
        int r = 0;
        for (int i = 0; i < cs.length; i++) {
            r |= 1 << (cs[i] - 'a');
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(new MaxProduct().maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"}));
    }
}
