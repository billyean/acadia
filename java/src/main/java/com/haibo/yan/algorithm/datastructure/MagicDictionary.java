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

import java.util.*;

/**
 * see https://leetcode.com/problems/implement-magic-dictionary
 * Implement a magic directory with buildDict, and search methods.
 * For the method buildDict, you'll be given a list of non-repetitive words to build a dictionary.
 * For the method search, you'll be given a word, and judge whether if you modify exactly one character into another
 * character in this word, the modified word is in the dictionary you just built.
 * Example 1:
 * Input: buildDict(["hello", "leetcode"]), Output: Null
 * Input: search("hello"), Output: False
 * Input: search("hhllo"), Output: True
 * Input: search("hell"), Output: False
 * Input: search("leetcoded"), Output: False
 * Example 2:
 * Input: buildDict(["hello", "hallo", "leetcode"]), Output: Null
 * Input: search("hello"), Output: True
 * Input: search("hhllo"), Output: True
 * Input: search("hell"), Output: False
 * Input: search("leetcoded"), Output: False
 */
public class MagicDictionary {
    private final HashSet<String> exactDict;

    private final List<Map<String, Integer>> cache;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        cache = new ArrayList<>();
        exactDict = new HashSet<>();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String string : dict) {
            exactDict.add(string);
            for (int i = 0; i < string.length(); i++) {
                Map<String, Integer> wordMap;
                if (cache.size() <= i) {
                    wordMap = new HashMap<>();
                    cache.add(wordMap);
                } else {
                    wordMap = cache.get(i);
                }
                String wc = string.substring(0, i) + string.substring(i + 1);
                wordMap.put(wc, wordMap.getOrDefault(wc, 0) + 1);
            }
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        if (word.length() > cache.size()) {
            return false;
        }

        for (int i = 0; i < word.length(); i++) {
            String  lookfor = word.substring(0, i) +  word.substring(i + 1);
            Map<String, Integer> dict = cache.get(i);
            if (dict.containsKey(lookfor)) {
                if (!exactDict.contains(word) || dict.get(lookfor) > 1)
                    return true;
            }
        }

        return false;
    }

}
