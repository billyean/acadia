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

package com.haibo.yan.algorithm.tree;

import java.util.*;

/**
 *
 * see https://leetcode.com/problems/minimum-height-trees
 *
 * For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a
 * rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs).
 * Given such a graph, write a function to findInTwo all the MHTs and return a list of their root labels.
 *
 * Format
 * The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected
 * edges (each edge is a pair of labels).
 * You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as
 * [1, 0] and thus will not appear together in edges.
 * Example 1:
 * Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 *
 *    0
 *    |
 *    1
 *   / \
 *  2   3
 *
 * return [1]
 *
 * Example 2:
 * Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 *   0  1  2
 *    \ | /
 *      3
 *      |
 *      4
 *      |
 *      5
 *   return [3, 4]
 *
 *   Note:
 *   (1) According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are
 *   connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”
 *   (2) The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 */
public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1)
            return Arrays.asList(0);
        HashMap<Integer, Set<Integer>> connects = new HashMap<>();

        for (int[] edge: edges) {
            int v1 = edge[0], v2 = edge[1];
            Set<Integer> newV1 = connects.getOrDefault(v1, new HashSet<>());
            newV1.add(v2);
            connects.put(v1, newV1);

            Set<Integer> newV2 = connects.getOrDefault(v2, new HashSet<>());
            newV2.add(v1);
            connects.put(v2, newV2);
        }

        while (connects.keySet().size() > 2) {
            HashSet<Integer> connected = new HashSet<>();
            HashSet<Integer> upLevel = new HashSet<>();
            connects.forEach((k, v) -> {
                if (v.size() == 1) {
                    upLevel.add(k);
                    connected.add(v.iterator().next());
                }
            });

            for (int v : upLevel) {
                connects.remove(v);
            }

            for (int v : connected) {
                Set<Integer> connectedSet = connects.get(v);
                connectedSet.removeAll(upLevel);
            }
        }

        return new ArrayList<>(connects.keySet());
    }
}
