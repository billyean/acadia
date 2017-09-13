package com.haibo.yan.algorithm.linkedlist;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class TestCircle {
    @DataProvider
    public Object[][] circleLL() {
        Node singleCircle = new Node(5);
        singleCircle.next = singleCircle;

        Node threeTwo = new Node(5);
        Node circlieStart = threeTwo.append(10).append(11);
        Node prev = circlieStart.append(1).append(2);
        prev.next = circlieStart;

        Node singleFiveCircle = new Node(16);
        Node singleFiveCirclePrev = singleFiveCircle.append(17).append(18).append(19).append(20);
        singleFiveCirclePrev.next = singleFiveCircle;


        return new Object[][] {
                {null, false, null},
                {new Node(10), false, null},
                {threeTwo, true, 1},
                {singleFiveCircle, true, 16},
        };
    }

    @Test(dataProvider = "circleLL")
    public void testCircle(Node head, boolean expected, Integer expectedNode) {
        assertEquals(new Circle<Integer>().hasCircle(head), expected);
        if (expectedNode == null) {
            assertNull(new Circle<Integer>().circleStart(head));
        } else {
            assertEquals(new Circle<Integer>().circleStart(head), expectedNode);
        }
    }
}
