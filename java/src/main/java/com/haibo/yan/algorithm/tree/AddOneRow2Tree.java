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
import java.util.Arrays;
import java.util.List;

/**
 * see https://leetcode.com/problems/add-one-row-to-tree
 * Given the root of a binary tree, then value v and depth d, you need to add a row of nodes with value v at the given
 * depth d. The root node is at depth 1.
 *
 * The adding rule is: given a positive integer depth d, for each NOT null tree nodes N in depth d-1, create two tree
 * nodes with value v as N's left subtree root and right subtree root. And N's original left subtree should be the left
 * subtree of the new left subtree root, its original right subtree should be the right subtree of the new right subtree
 * root. If depth d is 1 that means there is no depth d-1 at all, then create a tree node with value v as the new root
 * of the whole original tree, and the original tree is the new root's left subtree.
 *
 * Example 1:
 * Input:
 * A binary tree as following:
 *      4
 *    /   \
 *   2     6
 *  / \   /
 * 3   1 5
 * v = 1
 * d = 2
 * Output:
 *       4
 *      / \
 *     1   1
 *    /     \
 *   2       6
 *  / \     /
 * 3   1   5
 * Example 2:
 * Input:
 * A binary tree as following:
 *     4
 *    /
 *   2
 *  / \
 * 3   1
 * v = 1
 * d = 3
 * Output:
 *       4
 *      /
 *     2
 *    / \
 *   1   1
 *  /     \
 * 3       1
 * Note:
 * The given d is in range [1, maximum depth of the given tree + 1].
 * The given binary tree has at least one tree node.
 */
public class AddOneRow2Tree {
    public BinaryTreeNode addOneRow(BinaryTreeNode root, int v, int d) {
        if (d == 1) {
            BinaryTreeNode newRoot = new BinaryTreeNode(v);
            newRoot.left = root;
            return newRoot;
        }

        List<BinaryTreeNode> upLevel = nodesInDepth(Arrays.asList(root), d);

        for (BinaryTreeNode node : upLevel) {
            BinaryTreeNode left = node.left;
            BinaryTreeNode right = node.right;
            BinaryTreeNode newLeft = new BinaryTreeNode(v);
            BinaryTreeNode newRight = new BinaryTreeNode(v);
            node.left = newLeft;
            node.right = newRight;
            newLeft.left = left;
            newRight.right = right;

        }
        return root;
    }

    private List<BinaryTreeNode> nodesInDepth(List<BinaryTreeNode> roots, int depth) {
        if (depth  == 2)
            return roots;

        List<BinaryTreeNode> nextRows = new ArrayList<>();

        for (BinaryTreeNode root : roots) {
            if (root.left != null) {
                nextRows.add(root.left);
            }
            if (root.right != null) {
                nextRows.add(root.right);
            }
        }

        return nodesInDepth(nextRows, depth - 1);
    }
}
