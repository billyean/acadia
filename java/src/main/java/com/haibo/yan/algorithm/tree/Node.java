package com.haibo.yan.algorithm.tree;

public class Node {
    int value;

    Node left;

    Node right;

    public Node(int value) {
        this.value = value;
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
    public static String serialize(Node root) {
        if (root == null) {
            return "#";
        }

        StringBuilder builder = new StringBuilder();
        recursiveSerialize(root, builder);
        return builder.toString();
    }

    private static void recursiveSerialize (Node root, StringBuilder builder) {
        if (root == null) {
            builder.append("#");
        } else {
            builder.append(root.value).append("!");
            recursiveSerialize(root.left, builder);
            recursiveSerialize(root.right, builder);
        }
    }

    static class NodePos {
        Node node;

        int start;

        public NodePos(Node node, int start) {
            this.node = node;
            this.start = start;
        }
    }

    public static Node deserialize(String string) {
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

        Node root = new Node(value);

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
