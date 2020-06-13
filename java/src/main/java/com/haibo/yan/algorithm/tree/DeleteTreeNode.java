package com.haibo.yan.algorithm.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DeleteTreeNode {

    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        HashMap<Integer, List<Integer>> links = new HashMap<>();

        for (int i = 1; i < parent.length; i++) {
            int p = parent[i];
            List<Integer> c = links.getOrDefault(p, new ArrayList<>());
            c.add(i);
            links.put(p, c);
        }

        dfsSum(0, links, parent, value);

        int n = 0;
        for (int i: parent) {
            if (i != -1) {
                n++;
            }
        }

        return n + 1;
    }

    private int dfsSum(int k, HashMap<Integer, List<Integer>> links, int[] parent, int[] value) {
        if (!links.containsKey(k)) {
            if (value[k] == 0) {
                parent[k] = -1;
            }
            return value[k];
        }
        int total = links.get(k).stream().mapToInt(t -> dfsSum(t, links, parent, value)).sum();
        if (total + value[k] == 0) {
            delete(k, links, parent, value);
        }
        return total + value[k];
    }

    private void delete(int p, HashMap<Integer, List<Integer>> links, int[] parent, int[] value) {
        if (parent[p] == -1) {
            return;
        }
        if (links.containsKey(p)) {
            for (int v : links.get(p)) {

                delete(v, links, parent, value);
            }
        }
        parent[p] = -1;
    }

    public static void main(String[] args) {
        int r = new DeleteTreeNode().deleteTreeNodes(7, new int[]{-1,0,0,1,2,2,2},
                new int[]{1, -2, 4, 0, -2, -1, -1});

        System.out.println(r);
    }
}
