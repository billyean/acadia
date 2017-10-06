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
package com.haibo.yan.algorithm.facebook;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static java.util.stream.Collectors.joining;

import java.util.ArrayList;

/**
 * Permutate a int array, consider there could be duplicate in the array.
 */
public class Facebook1 {

    public Set<List<Integer>> subSet(int[] array) {
        Set<List<Integer>> sub = new HashSet<>();
        
        HashMap<Integer, Integer> vNums = new HashMap<>();
        for (int i : array) {
            int num = vNums.getOrDefault(i, 0);
            vNums.put(i, num + 1);
        }

        sub.add(new ArrayList<>());
        
        while (!vNums.isEmpty()) {
            Set<List<Integer>> temp = new HashSet<>();
            for (List<Integer> list : sub) {
                List<Integer> newList = new ArrayList<>();
                newList.addAll(list);
                temp.add(newList);
            }
            int nextV = vNums.keySet().iterator().next();
            for (List<Integer> set : temp) {
                set.add(nextV);
            }
            sub.addAll(temp);
            vNums.put(nextV, vNums.get(nextV) - 1);
            vNums.remove(nextV, 0);
        }
        
        return sub;
    }

    public static void main(String[] args) {
        Set<List<Integer>> subSet = new Facebook1().subSet(new int[]{3, 3, 6, 9});
        
        System.out.println(subSet.stream().map(s -> s.stream().map(String::valueOf).
                collect(joining(",", "[", "]"))).collect(joining("\n", "[", "]")));

    }

}

