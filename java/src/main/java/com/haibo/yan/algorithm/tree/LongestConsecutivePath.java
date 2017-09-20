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

import java.util.List;

/**
 * Find longest consecutive path in a tree.
 */
public class LongestConsecutivePath {
    /**
     * Recursive call to get longest consecutive path
     * @param parent
     * @param node
     * @param currentConsecutivePath current longest consecutive path number
     * @return
     */
    private static int helper(TreeNode parent, TreeNode node, int currentConsecutivePath) {
        if (node == null) {
            return currentConsecutivePath;
        }

        /**
         * Calculate current consecutive path number.
         */
        if (parent != null && node.val == parent.val + 1) {
            currentConsecutivePath++;
        } else {
            currentConsecutivePath = 1;
        }

        int max = currentConsecutivePath;

        List<TreeNode> children = node.children;
        if (children != null) {
            for (int i = 0; i < children.size(); i++) {
                TreeNode child = children.get(i);
                int v = helper(node, child, currentConsecutivePath);
                // Check every children's consecutive path number, get longest one
                if (v > max) {
                    max = v;
                }
            }
        }
        return max;
    }

    /**
     * Calculate most longest consecutive sequence in a tree
     * @param root
     * @return
     */
    public static int mostConsecutivePath(TreeNode root) {
        return helper(null, root, 0);
    }
}
