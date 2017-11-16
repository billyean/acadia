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

package com.haibo.yan.algorithm.bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.joining;

public class WordLadder {
//    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//
//    }


//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//    }


    private Set<String> bfs(Set<String> words, Set<String> dict) {
        Set<String> neighbours = new HashSet<String>();
        for (String word : words) {
            char[] wc = word.toCharArray();
            for (String w : dict) {
                if (!neighbours.contains(w)) {
                    char[] dc = w.toCharArray();
                    if (charDiff(wc, dc) == 1) {
                        neighbours.add(w);
                    }
                }
            }
        }

        dict.removeAll(neighbours);
        return neighbours;
    }

    private int charDiff(char[] cs1, char[] cs2) {
        int diff = 0;
        for (int i = 0; i < cs1.length; i++) {
            if (cs1[i] != cs2[i]) {
                diff++;
            }
        }

        return diff;
    }
}
