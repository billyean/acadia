package com.haibo.yan.algorithm.array;

import com.haibo.yan.algorithm.tree.BinaryTreeNode;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class ConstructBinaryTree {
    int index = 0;

    public BinaryTreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> positions = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            positions.put(inorder[i], i);
        }
        index = inorder.length - 1;

        return buildNode(0, inorder.length - 1, positions, inorder, postorder);
    }

    private BinaryTreeNode buildNode(int start, int end, HashMap<Integer, Integer> positions, int[] inorder, int[] postorder) {
        if (start > end) {
            return null;
        }

        int val = postorder[index];
        BinaryTreeNode node = new BinaryTreeNode(val);
        int inPos = positions.get(val);

        index--;
        BinaryTreeNode right = buildNode(inPos + 1, end, positions, inorder, postorder);
        BinaryTreeNode left = buildNode(start, inPos - 1, positions, inorder, postorder);
        node.left = left;
        node.right = right;
        return node;
    }
}
