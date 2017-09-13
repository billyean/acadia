package com.haibo.yan.algorithm.linkedlist;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static com.haibo.yan.algorithm.TestUtilities.assertLinkedListValues;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class TestRemoveK {
    @DataProvider
    public Object[][] circleLL() {
        Node ll1 = new Node(5);
        ll1.append(6).append(7);

        Node ll2 = new Node(1);
        ll2.append(2).append(3).append(4).append(5);


        return new Object[][] {
                {ll1, 4, Arrays.asList(5, 6, 7)},
                {ll1, 2, Arrays.asList(5, 7)},
                {ll2, 0, Arrays.asList(2, 3, 4, 5)},
        };
    }

    @Test(dataProvider = "circleLL")
    public void testCircle(Node head, int k, List<Integer> array) {
        RemoveK solution = new RemoveK(head);
        solution.remove(k);
        assertLinkedListValues(solution.head, array);
    }
}
