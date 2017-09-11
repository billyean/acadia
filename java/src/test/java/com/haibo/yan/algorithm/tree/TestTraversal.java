package com.haibo.yan.algorithm.tree;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

@Test
public class TestTraversal {
    @DataProvider
    public static Object[][] tree() {
        return new Object[][] {{2, true}, {6, false}, {19, true}, {22, false}, {23, true}};
    }

    public void testPreOrder(Node head, List<Integer> expectedResult){

    }

}
