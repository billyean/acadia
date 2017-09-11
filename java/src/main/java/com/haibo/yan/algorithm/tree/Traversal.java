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
            Node cur = null;
            stack.push(cur);

            while (!stack.isEmpty()){
                cur = stack.peek();

                while (cur.left != null) {
                    stack.push(cur.left);
                    cur = cur.left;
                }

                cur = stack.pop();
                result.add(cur.value);

                if (cur.right != null) {
                    stack.push(cur.left);
                    cur = cur.left;
                }
            }
        }
        return result;
    }
}
