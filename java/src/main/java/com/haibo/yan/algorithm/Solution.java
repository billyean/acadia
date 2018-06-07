package com.haibo.yan.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    /*
     * Complete the function below.
     */
    static void createIssuerTree(List<Issuer> issuers) {
        class TreeNode {
            String id;

            List<TreeNode> children = new ArrayList<>();

            TreeNode(String id) {
                this.id = id;
            }

            @Override
            public int hashCode() {
                return id.hashCode();
            }

            @Override
            public boolean equals(Object o) {
                TreeNode tn = (TreeNode)o;
                return tn.id.equals(this.id);
            }
        }

        HashMap<String, TreeNode> idToTree = new HashMap<>();

        TreeNode root = null;

        for (Issuer issuer: issuers) {
            if (idToTree.containsKey(issuer.id)) {
                return;
            }
            TreeNode node = new TreeNode(issuer.id);
            if (idToTree.containsKey(issuer.id)) {
                return;
            }
            idToTree.put(issuer.id, node);
            if (issuer.parentId.equals("ROOT")) {
                if (root != null) {
                    return;
                }
                root = node;
            }
        }

        if (null == root) {
            return;
        }

        for (Issuer issuer: issuers) {
            String parentId = issuer.parentId;
            TreeNode parent = idToTree.get(parentId);
            TreeNode child = idToTree.get(issuer.id);
            if (null != parent) {
                if (parent.children.contains(child)) {
                    return;
                } else {
                    parent.children.add(child);
                }
            } else if (!issuer.parentId.equals("ROOT")) {
                return;
            }
        }

        List<TreeNode> level = new ArrayList<>();
        level.add(root);

        while (!level.isEmpty()) {
            List<TreeNode> nextLevel = new ArrayList<>();

            for (int i = 0; i < level.size(); i++) {
                TreeNode h = level.get(i);
                if (i > 0) {
                    System.out.print(" ");
                }
                System.out.print(h.id);
                nextLevel.addAll(h.children);
            }
            System.out.println();
            level = nextLevel;
        }
    }

    /**
     * Issuer class struture, do no modify
     */
    private static class Issuer {
        String parentId;
        String id;
        Issuer(String parentId, String id) {
            this.parentId = parentId;
            this.id = id;
        }
    }

    public static void main(String[] args) {
        List<Issuer> issuers = new ArrayList<>();

        issuers.add(new Issuer("ROOT", "1"));
        issuers.add(new Issuer("1", "2"));
        issuers.add(new Issuer("1", "3"));
        issuers.add(new Issuer("1", "4"));
        issuers.add(new Issuer("2", "25"));
        issuers.add(new Issuer("2", "28"));
        issuers.add(new Issuer("2", "27"));
        issuers.add(new Issuer("4", "41"));
        issuers.add(new Issuer("4", "43"));
        issuers.add(new Issuer("4", "42"));
        issuers.add(new Issuer("3", "13"));

        Solution.createIssuerTree(issuers);
    }
}
