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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * see https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then
 * right to left for the next level and alternate between).
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *  3
 * / \
 * 9  20
 * /  \
 * 15  7
 * return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(BinaryTreeNode root) {
        List<BinaryTreeNode> nodes = new ArrayList<>();
        if (root != null) {
            nodes.add(root);
        }

        return zigzagLevelOrder(nodes, true);
    }

    private List<List<Integer>> zigzagLevelOrder(List<BinaryTreeNode> nodes, boolean odd) {
        List<List<Integer>> result = new ArrayList<>();
        if (nodes.size() != 0) {


            List<Integer> current = new ArrayList<>();
            List<BinaryTreeNode> nextLevel = new ArrayList<>();
            for (BinaryTreeNode node : nodes) {
                current.add(node.value);
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(0, node.right);
                }
            }

            if (!odd) {
                Collections.reverse(current);
            }
            result.add(current);
            result.addAll(zigzagLevelOrder(nextLevel, !odd));
        }
        return result;
    }
}
