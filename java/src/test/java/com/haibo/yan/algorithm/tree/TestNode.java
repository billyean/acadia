package com.haibo.yan.algorithm.tree;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

@Test
public class TestNode {

    public void testSerialization() {
        Node root = Node.deserialize("9!4!3!1!###6!5!##7!#8!##13!10!##15!14!###");

        assertNotNull(root);
        assertEquals(root.value, 9);

        Node node1_1 = root.left;
        Node node1_2 = root.right;
        assertNotNull(node1_1);
        assertNotNull(node1_2);
        assertEquals(node1_1.value, 4);
        assertEquals(node1_2.value, 13);

        String serializedTree = Node.serialize(root);
        assertEquals(serializedTree, "9!4!3!1!###6!5!##7!#8!##13!10!##15!14!###");
    }
}
