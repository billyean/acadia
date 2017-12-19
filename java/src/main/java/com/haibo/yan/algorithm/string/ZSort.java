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
import java.util.HashMap;


/**
 * For g = ["Cow", "Chicken", "Deer", "Rabbit"] and z = 3the output should be
 * sortByZ(g, z) = ["Rabbit", "Deer", "Chicken", "Cow"].
 * Input/Output
 * [time limit] 3000ms (java)
 * [input] array.string g
 * A list of strings.
 * Guaranteed constraints:
 * 3 ≤ g.length ≤ 50,
 * 2 ≤ g[i].length < 40.
 *
 * [input] integer z
 *
 * Sort the list based on the zth character.
 *
 * Guaranteed constraints:
 * 1 ≤ z ≤ length of the shortest string in g.
 *
 * [output] array.string
 *
 * The sorted list.
 */
public class ZSort {
    String[] SortByZ(String[] g, int z) {

        HashMap<String, Integer> gp = new HashMap<>();
        for (int i = 0; i < g.length; i++) {
            gp.put(g[i], i);
        }

        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                char cz1 = Character.toLowerCase(s1.charAt(z - 1));
                char cz2 = Character.toLowerCase(s2.charAt(z - 1));
                int zc =  Character.compare(cz1, cz2);
                if (zc != 0) {
                    return zc;
                }
                return Integer.compare(gp.get(s1), gp.get(s2));
            }
        };

        Arrays.sort(g, comp);
        return g;
    }
}
