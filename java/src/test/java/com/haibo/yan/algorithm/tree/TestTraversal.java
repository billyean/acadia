package com.haibo.yan.algorithm.tree;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

@Test
public class TestTraversal {
    /**
     *            9
     *        /      \
     *       4        13
     *     /   \     /   \
     *    3     6   10   15
     *   /     /  \      /
     *  1     5   7     14
     *             \
     *             8
     * @return
     */
    @DataProvider
    public static Object[][] preOrderTree() {
        return new Object[][] {{Node.deserialize("9!4!3!1!###6!5!##7!#8!##13!10!##15!14!###"),
                Arrays.asList(9, 4, 3, 1, 6, 5, 7, 8, 13, 10, 15, 14)}};
    }

    @Test(dataProvider = "preOrderTree")
    public void testPreOrder(Node head, List<Integer> expectedResult){
        Traversal traversal = new Traversal();
        assertEquals(traversal.preOrderTraverse(head), expectedResult);
    }

    @DataProvider
    public static Object[][] inOrderTree() {
        return new Object[][] {{Node.deserialize("9!4!3!1!###6!5!##7!#8!##13!10!##15!14!###"),
                Arrays.asList(1, 3, 4, 5, 6, 7, 8, 9, 10, 13, 14, 15)}};
    }

    @Test(dataProvider = "inOrderTree")
    public void testInOrder(Node head, List<Integer> expectedResult){
        Traversal traversal = new Traversal();
        assertEquals(traversal.inOrderTraverse(head), expectedResult);
    }

    @DataProvider
    public static Object[][] postOrderTree() {
        return new Object[][] {{Node.deserialize("9!4!3!1!###6!5!##7!#8!##13!10!##15!14!###"),
                Arrays.asList(1, 3, 5, 8, 7, 6, 4, 10, 14, 15, 13, 9)}};
    }

    @Test(dataProvider = "postOrderTree")
    public void testPostOrder(Node head, List<Integer> expectedResult){
        Traversal traversal = new Traversal();
        assertEquals(traversal.postOrderTraverse(head), expectedResult);
    }
}
