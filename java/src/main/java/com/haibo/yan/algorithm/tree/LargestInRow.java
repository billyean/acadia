package com.haibo.yan.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/
 */
public class LargestInRow {
    public List<Integer> largestValues(BinaryTreeNode root) {
        List<Integer> r = new ArrayList<>();
        if (root == null) {
            return r;
        }

        List<Integer> ll = largestValues(root.left);
        List<Integer> lr = largestValues(root.right);

        r.add(root.val);

        if (ll.size() > lr.size()) {
            List<Integer> t = ll;
            ll = lr;
            lr = t;
        }

        int i = 0;
        while (i < ll.size()) {
            if (ll.get(i) >= lr.get(i)) {
                r.add(ll.get(i));
            } else {
                r.add(lr.get(i));
            }
            i++;
        }
        while (i < lr.size()) {
            r.add(lr.get(i));
            i++;
        }
        return r;
    }
}
