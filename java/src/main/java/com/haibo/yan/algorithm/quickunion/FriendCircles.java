package com.haibo.yan.algorithm.quickunion;

import java.util.*;

/**
 * https://leetcode.com/problems/friend-circles/
 */
public class FriendCircles {
    private class Node {
        Node p;
        int val;
        int n;

        Node(int val) {
            this.val = val;
            this.n = 1;
            this.p = this;
        }

        Node root() {
            Node c = this;
            while (c.p != c) {
                c = c.p;
            }
            return c;
        }

        boolean sameTree(Node other) {
            return this.root() == other.root();
        }

        void mergeNode(Node other) {
            if (!sameTree(other)) {
                Node r1 = this.root();
                Node r2 = other.root();
                if (r1.n >= r2.n) {
                    r2.p = r1;
                    r1.n += r2.n;
                } else {
                    r1.p = r2;
                    r2.n += r1.n;
                }
            }
        }
    }

    public int findCircleNum(int[][] M) {
        List<Node> trees = new ArrayList<>();
        for (int i = 0; i < M.length; i++) {
            trees.add(new Node(i));
        }

        for (int i = 0; i < M.length - 1; i++) {
            for (int j = i + 1; j < M.length; j++) {
                if (M[i][j] == 1) {
                    trees.get(i).mergeNode(trees.get(j));
                }
            }
        }

        Set<Integer> roots = new HashSet<>();
        for (Node n : trees) {
            roots.add(n.root().val);
        }
        return roots.size();
    }
}
