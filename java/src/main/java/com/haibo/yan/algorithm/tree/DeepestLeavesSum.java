package com.haibo.yan.algorithm.tree;

/**
 * https://leetcode.com/problems/deepest-leaves-sum/
 */
public class DeepestLeavesSum {
    public int deepestLeavesSum(BinaryTreeNode root) {
        return deepestLeavesSumInternal(root)[1];
    }

    private int[] deepestLeavesSumInternal(BinaryTreeNode root) {
        int[] result = new int[2];
        if (root == null) {
            return result;
        }

        int[] ls = deepestLeavesSumInternal(root.left);
        int[] rs = deepestLeavesSumInternal(root.right);
        if (ls[0] < rs[0]) {
            result[0] = rs[0] + 1;
            result[1] = rs[1];
        } else if (ls[0] > rs[0]) {
            result[0] = ls[0] + 1;
            result[1] = ls[1];
        } else {
            if(ls[0] == 0) {
                result[0] = 1;
                result[1] = root.val;
            } else {
                result[0] = ls[0] + 1;
                result[1] = ls[1] + rs[1];
            }
        }
        return result;
    }
}
