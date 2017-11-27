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

package com.haibo.yan.algorithm.tree;

import java.util.*;

/**
 * https://leetcode.com/problems/find-duplicate-subtrees
 *
 * Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the
 * root node of any one of them.
 *
 * Two trees are duplicate if they have the same structure with same node values.
 *
 * Example 1:
 *     1
 *    / \
 *   2   3
 *  /   / \
 * 4   2   4
 *    /
 *   4
 * The following are two duplicate subtrees:
 *    2
 *   /
 *  4
 * and
 *  4
 * Therefore, you need to return above trees' root in the form of a list.
 *
 */
public class FindDuplicateSubtrees {
    public List<BinaryTreeNode> findDuplicateSubtrees(BinaryTreeNode root) {
        Set<BinaryTreeNode> duplicates = new HashSet<>();
        HashMap<String, Integer> deserialSet = new HashMap<>();
        postOrder(duplicates, deserialSet, root);

        return new ArrayList(duplicates);
    }

    private String postOrder(Set<BinaryTreeNode> duplicates, HashMap<String, Integer> map, BinaryTreeNode root) {
        if (root == null) {
            return "#";
        }

        String deserial = postOrder(duplicates, map, root.left) + postOrder(duplicates, map, root.right) + root.val + "!";
        System.out.println(deserial);
        if (map.containsKey(deserial)) {
            if (map.get(deserial) == 1) {
                duplicates.add(root);
            }
            map.put(deserial, map.get(deserial) + 1);
        } else {
            map.put(deserial, 1);
        }

        return deserial;
    }
}
