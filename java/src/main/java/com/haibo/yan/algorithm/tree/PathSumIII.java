package com.haibo.yan.algorithm.tree;

/**
 * https://leetcode.com/problems/path-sum-iii/submissions/
 */
public class PathSumIII {
    public int pathSum(BinaryTreeNode root, int sum) {
        if (root == null)
            return 0;
        return visit(root, sum)
                + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int visit(BinaryTreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        int total = 0;
        if (node.val == sum) {
            total++;
        }
        int ns = sum - node.val;

        return total + visit(node.left, ns) + visit(node.right, ns);
    }

}
