package com.haibo.yan.algorithm.tree;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://leetcode.com/problems/range-sum-of-bst/
 */
public class RangeSumOfBST {
    public int rangeSumBST(BinaryTreeNode root, int L, int R) {
        AtomicInteger i = new AtomicInteger(0);
        dfs(root, i, L, R);
        return i.get();
    }

    private void dfs(BinaryTreeNode node, AtomicInteger i, int L, int R) {
        if(node == null)
            return;
        if (node.val >= L && node.val <= R) {
            i.addAndGet(node.val);
        }
        dfs(node.left, i, L, R);
        dfs(node.right, i, L, R);
    }
}
