package com.haibo.yan.algorithm.tree;

/**
 * Binary tree for hold int val.
 */
public class BinaryTreeNode {
    int val;

    BinaryTreeNode left;

    BinaryTreeNode right;

    public BinaryTreeNode(int val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BinaryTreeNode) || o == null) {
            return false;
        }

        BinaryTreeNode other = (BinaryTreeNode)o;

        if (this.val != other.val) {
            return false;
        }

        boolean leftSame = false;

        if (this.left == null) {
            return other.left == null;
        } else {
            leftSame = this.left.equals(other.left);
        }

        boolean rightSame = false;
        if (this.right == null) {
            return other.right == null;
        } else {
            rightSame = this.right.equals(other.right);
        }
        return leftSame && rightSame;
    }

    /**
     * pre-order serialize tree.
     * We use special characters ! representing dilemeter of node, special characters # representing null node.
     * Below binary tree would be 9!4!3!1!###6!5!##7!#8!##13!10!##15!14!###
     *            9
     *        /      \
     *       4        13
     *     /   \     /   \
     *    3     6   10   15
     *   /     /  \      /
     *  1     5   7     14
     *             \
     *             8
     *
     * @return a serialized string to represent pre-order traversal of a tree.
     */
    public static String serialize(BinaryTreeNode root) {
        if (root == null) {
            return "#";
        }

        StringBuilder builder = new StringBuilder();
        recursiveSerialize(root, builder);
        return builder.toString();
    }

    private static void recursiveSerialize (BinaryTreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append("#");
        } else {
            builder.append(root.val).append("!");
            recursiveSerialize(root.left, builder);
            recursiveSerialize(root.right, builder);
        }
    }

    /**
     * Be aware this is for binary search tree
     * @param root
     * @param key
     * @return
     */
    public static BinaryTreeNode deleteNode (BinaryTreeNode root, int key) {
        BinaryTreeNode parent = null, node = root;

        while(node != null && node.val != key) {
            parent = node;
            node = node.val > key ? node.left : node.right;
        }

        BinaryTreeNode newNode = null;
        if (node != null) {
            BinaryTreeNode left = node.left;
            BinaryTreeNode right = node.right;

            if (left == null || right == null) {
                newNode = left == null ? right : left;
            } else {
                BinaryTreeNode leftRight = left.right;
                BinaryTreeNode next = right;
                while (next.left != null) {
                    next = next.left;
                }
                newNode = left;
                newNode.right = right;
                next.left = leftRight;
            }

            if (parent != null) {
                if (parent.left == node) {
                    parent.left = newNode;
                } else {
                    parent.right = newNode;
                }
            }
        }

        if (parent == null) {
            return newNode;
        } else {
            return root;
        }
    }

    /**
     * see https://leetcode.com/problems/delete-node-in-a-bst
     * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root
     * node reference (possibly updated) of the BST.
     * Basically, the deletion can be divided into two stages:
     * Search for a node to remove.
     * If the node is found, delete the node.
     * Note: Time complexity should be O(height of tree).
     *
     * Example:
     *
     * root = [5,3,6,2,4,null,7]
     * key = 3
     *
     *     5
     *   /  \
     *  3    6
     * / \    \
     * 2   4   7
     *
     * Given key to delete is 3. So we find the node with val 3 and delete it.
     *
     * 1. One valid answer is [5,4,6,2,null,null,7], shown in the following BST.
     *
     *     5
     *    / \
     *   4   6
     *  /     \
     * 2       7
     *
     * 2. Another valid answer is [5,2,6,null,4,null,7].(Taking this approach)
     *
     *    5
     *   / \
     *  2   6
     *  \   \
     *   4   7
     * @param parent
     * @param node
     * @param key
     * @return
     */
    private static BinaryTreeNode deleteNode (BinaryTreeNode parent, BinaryTreeNode node, int key) {
        if (node != null) {
            if (node.val == key) {
                BinaryTreeNode left = node.left;
                BinaryTreeNode right = node.left;
                BinaryTreeNode newNode;
                if (left == null || right == null) {
                    newNode = left == null ? right : left;
                } else {
                    BinaryTreeNode leftRight = left.right;
                    BinaryTreeNode next = right;
                    while (next.left != null) {
                        next = next.left;
                    }
                    newNode = left;
                    newNode.right = right;
                    next.left = leftRight;
                }

                if (parent != null) {
                    if (parent.left == node) {
                        parent.left = newNode;
                    } else {
                        parent.right = newNode;
                    }
                }
            } else if (node.val > key) {
                deleteNode(node, node.left, key);
            } else {
                deleteNode(node, node.right, key);
            }
        }

        if (parent == null) {
            return node;
        } else {
            return parent;
        }
    }

    static class NodePos {
        BinaryTreeNode node;

        int start;

        public NodePos(BinaryTreeNode node, int start) {
            this.node = node;
            this.start = start;
        }
    }

    public static BinaryTreeNode deserialize(String string) {
        if (string == null || string.length() == 0) {
            return null;
        }

        return recursiveDeserialize(string,  0).node;
    }

    private static NodePos recursiveDeserialize(String string, int start) {
        if (string.indexOf('#', start) == start) {
            return new NodePos(null, start + 1);
        }

        int nextDelimeter = string.indexOf('!', start);
        int value = Integer.parseInt(string.substring(start, nextDelimeter));

        BinaryTreeNode root = new BinaryTreeNode(value);

        int nextStart = nextDelimeter + 1;

        if (nextStart < string.length()) {
            NodePos leftEnd = recursiveDeserialize(string, nextStart);
            root.left = leftEnd.node;

            nextStart = leftEnd.start;

            if (nextStart < string.length()) {
                NodePos right = recursiveDeserialize(string, leftEnd.start);
                root.right = right.node;
                nextStart = right.start;
            }
        }
        return new NodePos(root, nextStart);
    }
}
