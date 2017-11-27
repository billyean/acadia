package com.haibo.yan.algorithm.tree;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

@Test
public class TestBinaryTreeListNodeSerialization {

    public void testSerialization() {
        BinaryTreeNode root = BinaryTreeNode.deserialize("9!4!3!1!###6!5!##7!#8!##13!10!##15!14!###");

        assertNotNull(root);
        assertEquals(root.val, 9);

        BinaryTreeNode node1_1 = root.left;
        BinaryTreeNode node1_2 = root.right;
        assertNotNull(node1_1);
        assertNotNull(node1_2);
        assertEquals(node1_1.val, 4);
        assertEquals(node1_2.val, 13);

        String serializedTree = BinaryTreeNode.serialize(root);
        assertEquals(serializedTree, "9!4!3!1!###6!5!##7!#8!##13!10!##15!14!###");

        BinaryTreeNode tree1 = BinaryTreeNode.deserialize("5!3!2!##4!##6!#7!##");
        assertEquals(tree1.val, 5);
        assertNotNull(tree1);

        assertNotNull(tree1);
        BinaryTreeNode tree1_left = tree1.left;
        BinaryTreeNode tree1_right = tree1.right;

        assertEquals(tree1_left.val, 3);
        assertEquals(tree1_right.val, 6);


        BinaryTreeNode tree2 = BinaryTreeNode.deserialize("5!2!#4!##6!#7!##");
        assertEquals(tree2.val, 5);
        assertNotNull(tree2);

        assertNotNull(tree2);
        BinaryTreeNode tree2_left = tree2.left;
        BinaryTreeNode tree2_right = tree2.right;

        assertEquals(tree2_left.val, 2);
        assertEquals(tree2_right.val, 6);
    }
}
