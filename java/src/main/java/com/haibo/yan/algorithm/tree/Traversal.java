package com.haibo.yan.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Traversal {

    public List<Integer> preOrderTraverse(Node head) {
        List<Integer> result = new ArrayList<>();
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(head);

            while (!stack.isEmpty()){
                Node node = stack.pop();
                result.add(node.value);

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

    public List<Integer> inOrderTraverse(Node head) {
        List<Integer> result = new ArrayList<>();

        if (head != null) {
            Stack<Node> stack = new Stack<>();
            Node cur = head;

            while (!stack.isEmpty() || cur != null){
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    cur = stack.pop();
                    result.add(cur.value);
                    // After pop up, access right tree.
                    cur = cur.right;
                }
            }
        }
        return result;
    }

    public List<Integer> postOrderTraverse(Node head) {
        List<Integer> result = new ArrayList<>();

        if (head != null) {
            Stack<Node> stack = new Stack<>();

            // remember the child when pop from stack, represent parent if pushing to stack. Initiate with null.
            Node prev = null;

            stack.push(head);

            while (!stack.isEmpty()){
                Node cur = stack.peek();

                if (prev == null || prev.left == cur ||  prev.right == cur) {
                    /**
                     * if it's root or current is prev's child, push child to stack. Otherwise to pop top node.
                     */
                    if (cur.left != null) {
                        stack.push(cur.left);
                    } else if (cur.right != null) {
                        stack.push(cur.right);
                    } else {
                        result.add(cur.value);
                        prev = stack.pop();
                    }
                } else if (cur.left == prev)   {
                    // Once pop, if popped node is left child, check if top node has right child, pop top node if it
                    // doesn't, otherwise push right child to stack.
                    if (cur.right != null) {
                        stack.push(cur.right);
                    } else {
                        stack.pop();
                        result.add(cur.value);
                    }
                } else {
                    // Once pop, if popped node is right child, just pop top node
                    stack.pop();
                    result.add(cur.value);
                }
                prev = cur;
            }
        }
        return result;
    }
}
