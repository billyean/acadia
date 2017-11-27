package com.haibo.yan.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Traversal {

    public List<Integer> preOrderTraverse(BinaryTreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            Stack<BinaryTreeNode> stack = new Stack<>();
            stack.push(root);

            while (!stack.isEmpty()){
                BinaryTreeNode node = stack.pop();
                result.add(node.val);

                if (node.right != null) {
                    stack.push(node.right);
                }

                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }
        return result;
    }


    public List<Integer> inOrderTraverse(BinaryTreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root != null) {
            Stack<BinaryTreeNode> stack = new Stack<>();
            BinaryTreeNode cur = root;

            // cur is null means previous accessed node doesn't have right child, we can keep pop up node.
            while (!stack.isEmpty() || cur != null){
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    cur = stack.pop();
                    result.add(cur.val);
                    // After pop up, access right tree.
                    cur = cur.right;
                }
            }
        }
        return result;
    }

    public List<Integer> postOrderTraverse(BinaryTreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root != null) {
            Stack<BinaryTreeNode> stack = new Stack<>();

            // remember the child when pop from stack, represent parent if pushing to stack. Initiate with null.
            BinaryTreeNode prev = null;

            stack.push(root);

            while (!stack.isEmpty()){
                BinaryTreeNode cur = stack.peek();

                if (prev == null || prev.left == cur ||  prev.right == cur) {
                    /**
                     * if it's root or current is prev's child, push child to stack. Otherwise to pop top node.
                     */
                    if (cur.left != null) {
                        stack.push(cur.left);
                    } else if (cur.right != null) {
                        stack.push(cur.right);
                    } else {
                        result.add(cur.val);
                        stack.pop();
                    }
                } else if (cur.left == prev)   {
                    // Once pop, if popped node is left child, check if top node has right child, pop top node if it
                    // doesn't, otherwise push right child to stack.
                    if (cur.right != null) {
                        stack.push(cur.right);
                    } else {
                        stack.pop();
                        result.add(cur.val);
                    }
                } else {
                    // Once pop, if popped node is right child, just pop top node
                    stack.pop();
                    result.add(cur.val);
                }
                prev = cur;
            }
        }
        return result;
    }
}
