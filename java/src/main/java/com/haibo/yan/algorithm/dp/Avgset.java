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

package com.haibo.yan.algorithm.dp;

import java.util.*;
import java.util.stream.Collectors;

public class Avgset {
    public ArrayList<ArrayList<Integer>> avgset(ArrayList<Integer> a) {

        Collections.sort(a);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int sum = a.stream().mapToInt(Integer::intValue).sum();


        int avg = sum / a.size();

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        map.put(0, new ArrayList<>());

        for (int i = 0; i < a.size(); i++) {
            int ai = a.get(i);
            Set<Integer> keys = new HashSet(map.keySet());

            for (int key : keys) {
                ArrayList<Integer> al = map.get(key);
                int newKey = key + avg - ai;
                ArrayList<Integer> nal = map.get(newKey);

                ArrayList<Integer> newAl = new ArrayList(al);
                newAl.add(i);
                if (newKey == 0 || newKey > 0 && newKey < newAl.size()) {
                    return partition(a, newAl);
                } else if (nal == null || al.size() < nal.size() - 1) {
                    map.put(newKey, newAl);
                }
            }
        }

        return list;
    }

    private ArrayList<ArrayList<Integer>> partition(ArrayList<Integer> a, ArrayList<Integer> al) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        int ali = 0;
        for (int i = 0; i < a.size(); i++) {
            if (ali < al.size() && i == al.get(ali)) {
                left.add(a.get(i));
                ali++;
            } else {
                right.add(a.get(i));
            }
        }

        result.add(left);
        result.add(right);
        return result;
    }
}
