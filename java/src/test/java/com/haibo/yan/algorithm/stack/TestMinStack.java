package com.haibo.yan.algorithm.stack;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test
public class TestMinStack {


    public void testMin() {
        MinStack<Integer> minStack = new MinStack<>();

        minStack.push(3);
        minStack.push(1);
        minStack.push(5);

        assertEquals(minStack.getMin(), Integer.valueOf(1));
        assertEquals(minStack.top(), Integer.valueOf(5));

        minStack.push(0);

        assertEquals(minStack.getMin(), Integer.valueOf(0));
        assertEquals(minStack.top(), Integer.valueOf(0));

        minStack.pop();

        assertEquals(minStack.getMin(), Integer.valueOf(1));
        assertEquals(minStack.top(), Integer.valueOf(5));
    }
}
