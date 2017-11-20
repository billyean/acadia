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

package com.haibo.yan.algorithm.datastructure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * see https://leetcode.com/problems/map-sum-pairs
 * Implement a MapSum class with insert, and sum methods.
 * For the method insert, you'll be given a pair of (string, integer). The string represents the key and the integer
 * represents the value. If the key already existed, then the original key-value pair will be overridden to the new one.
 * For the method sum, you'll be given a string representing the prefix, and you need to return the sum of all the
 * pairs' value whose key starts with the prefix.
 * Example 1:
 * Input: insert("apple", 3), Output: Null
 * Input: sum("ap"), Output: 3
 * Input: insert("app", 2), Output: Null
 * Input: sum("ap"), Output: 5
 */
public class MapSum {
    private HashMap<String, Integer> map;

    private HashMap<String, Set<String>> preToString;

    /** Initialize your data structure here. */
    public MapSum() {
        map = new HashMap<>();
        preToString = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
        for (int i = 1; i <= key.length(); i++) {
            String sub = key.substring(0, i);
            Set<String> s = preToString.getOrDefault(sub, new HashSet<>());
            s.add(key);
            preToString.put(sub, s);
        }
    }

    public int sum(String prefix) {
        if (preToString.containsKey(prefix)) {
            return preToString.get(prefix).stream().mapToInt(k -> map.get(k)).sum();
        }
        return 0;
    }
}
