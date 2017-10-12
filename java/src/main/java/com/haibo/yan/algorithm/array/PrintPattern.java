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

package com.haibo.yan.algorithm.array;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class PrintPattern {
    public static List<List<Integer>> getPattern(int size) {
        List<List<Integer>> result = new ArrayList<>();

        if (size == 0)
            return result;

        result.add(Arrays.asList(1));

        for (int i = 0; i < size - 1; i++) {
            List<Integer> prev = result.get(result.size() - 1);
            LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

            for (int v : prev) {
                int c = map.getOrDefault(v, 0) + 1;
                map.put(v, c);
            }

            List<Integer> newLine = new ArrayList<>();
            map.forEach((k, v) -> { newLine.add(v); newLine.add(k); });
            result.add(newLine);
        }

        return result;
    }


}
