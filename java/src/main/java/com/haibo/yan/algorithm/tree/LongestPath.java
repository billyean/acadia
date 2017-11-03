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
import java.util.HashMap;
import java.util.List;

public class LongestPath {

    public List<BinaryTreeNode> longestPath(BinaryTreeNode root) {
        HashMap<BinaryTreeNode, List<BinaryTreeNode>> cache = new HashMap<>();

        return longestPath(root, cache);
    }

    public List<BinaryTreeNode> longestPath(BinaryTreeNode root,
                                            HashMap<BinaryTreeNode, List<BinaryTreeNode>> cache) {

        if (root == null)
            return new ArrayList<>();

        List<BinaryTreeNode> left = longestPath(root.left, cache);
        List<BinaryTreeNode> right = longestPath(root.right, cache);

        List<BinaryTreeNode> longest = left.size() > right.size() ? left : right;

        List<BinaryTreeNode> current = new ArrayList(longest);
        current.add(root);
        cache.put(root, current);

        List<BinaryTreeNode> deepestLeft = cache.getOrDefault(root.left, Collections.EMPTY_LIST);
        List<BinaryTreeNode> deepestRight = cache.getOrDefault(root.right, Collections.EMPTY_LIST);
        cache.remove(root.left);
        cache.remove(root.right);

        if (deepestLeft.size() + deepestRight.size() + 1 > longest.size()) {
            List<BinaryTreeNode> newLongest = new ArrayList<>();
            newLongest.addAll(deepestLeft);
            newLongest.add(root);
            newLongest.addAll(deepestRight);
            return newLongest;
        } else {
            return longest;
        }
    }
}
