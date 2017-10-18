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

import static java.util.stream.Collectors.joining;

public class PrintPattern {
    public static List<List<Integer>> getPattern(int size) {
        List<List<Integer>> result = new ArrayList<>();

        if (size == 0)
            return result;

        result.add(Arrays.asList(1));

        for (int i = 0; i < size - 1; i++) {
            List<Integer> prev = result.get(result.size() - 1);
            result.add(generatePattern(prev));
        }

        return result;
    }

    private static List<Integer> generatePattern(List<Integer> list) {
        List<Integer> newLine = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1 || list.get(i) != list.get(i + 1)) {
                newLine.add(count + 1);
                newLine.add(list.get(i));
                count = 0;
            } else {
                count++;
            }
        }
        return newLine;
    }


    /**
     * See https://leetcode.com/problems/count-and-say
     *
     * The count-and-say sequence is the sequence of integers with the first five terms as following:
     *
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     * 1 is read off as "one 1" or 11.
     * 11 is read off as "two 1s" or 21.
     * 21 is read off as "one 2, then one 1" or 1211.
     * Given an integer n, generate the nth term of the count-and-say sequence.
     *
     * Note: Each term of the sequence of integers will be represented as a string.
     *
     * Example 1:
     * Input: 1
     * Output: "1"
     * Example 2:
     *
     * Input: 4
     * Output: "1211"
     *
     * @param n
     * @return
     */
    public static String countAndSay(int n)  {
        List<Integer> list = Arrays.asList(1);
        for (int i = 1; i < n; i++) {
            list = generatePattern(list);
        }

        return list.stream().map(String::valueOf).collect(joining(""));
    }
}
