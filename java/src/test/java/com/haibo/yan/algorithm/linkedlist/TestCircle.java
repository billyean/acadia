package com.haibo.yan.algorithm.linkedlist;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class TestCircle {
    @DataProvider
    public Object[][] circleLL() {
        ListNode singleCircle = new ListNode(5);
        singleCircle.next = singleCircle;

        ListNode threeTwo = new ListNode(5);
        ListNode circlieStart = threeTwo.append(10).append(11);
        ListNode prev = circlieStart.append(1).append(2);
        prev.next = circlieStart;

        ListNode singleFiveCircle = new ListNode(16);
        ListNode singleFiveCirclePrev = singleFiveCircle.append(17).append(18).append(19).append(20);
        singleFiveCirclePrev.next = singleFiveCircle;


        return new Object[][] {
                {null, false, null},
                {new ListNode(10), false, null},
                {threeTwo, true, 1},
                {singleFiveCircle, true, 16},
        };
    }

    @Test(dataProvider = "circleLL")
    public void testCircle(ListNode head, boolean expected, Integer expectedNode) {
        assertEquals(new Circle<Integer>().hasCircle(head), expected);
        if (expectedNode == null) {
            assertNull(new Circle<Integer>().circleStart(head));
        } else {
            assertEquals(new Circle<Integer>().circleStart(head), expectedNode);
        }
    }
}
