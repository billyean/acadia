package com.haibo.yan.algorithm.array;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestArrayQueue {
    @Test
    public void test1() {
        ArrayQueue<Integer> queue = new ArrayQueue<>(3);
        assertEquals(queue.length(), 0);

        queue.pushBack(1);
        assertEquals(queue.head().intValue(), 1);
        assertEquals(queue.length(), 1);
        queue.pushBack(2);
        assertEquals(queue.head().intValue(), 1);
        assertEquals(queue.length(), 2);
        queue.pushBack(3);
        assertEquals(queue.head().intValue(), 1);
        assertEquals(queue.length(), 3);

        assertEquals(queue.popFront().intValue(), 1);
        assertEquals(queue.head().intValue(), 2);
        assertEquals(queue.length(), 2);

        assertEquals(queue.popFront().intValue(), 2);
        assertEquals(queue.head().intValue(), 3);
        assertEquals(queue.length(), 1);

        queue.pushBack(4);
        assertEquals(queue.head().intValue(), 3);
        assertEquals(queue.length(), 2);

        queue.pushBack(5);
        assertEquals(queue.head().intValue(), 3);
        assertEquals(queue.length(), 3);
    }


    @Test
    public void test2() {
        ArrayQueue<Integer> queue = new ArrayQueue<>(1);
        assertEquals(queue.length(), 0);

        queue.pushBack(1);
        assertEquals(queue.length(), 1);
        try {
            queue.pushBack(2);
        } catch (IndexOutOfBoundsException ioe) {
            assertEquals(ioe.getMessage(), "Stack is full");
        }
        assertEquals(queue.head().intValue(), 1);
        assertEquals(queue.popFront().intValue(), 1);
        assertEquals(queue.length(), 0);

        queue.pushBack(2);
        assertEquals(queue.head().intValue(), 2);
        assertEquals(queue.popFront().intValue(), 2);
    }
}
