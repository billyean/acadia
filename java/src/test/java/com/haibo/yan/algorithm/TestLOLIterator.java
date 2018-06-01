package com.haibo.yan.algorithm;

import com.haibo.yan.algorithm.LOLIterator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class TestLOLIterator {
    @Test
    public void test1() {
        List<List<Integer>> l = Arrays.asList(
          Arrays.asList(1, 2, 3),
            Arrays.asList(4, 5, 6),
            Arrays.asList(7, 8)
        );

        Iterator<Integer> iter = LOLIterator.listIterator(l);
        assertTrue(iter.hasNext());
        assertEquals(iter.next().intValue(), 1);
        assertEquals(iter.next().intValue(), 2);
        assertEquals(iter.next().intValue(), 3);
        assertTrue(iter.hasNext());
        assertTrue(iter.hasNext());
        assertEquals(iter.next().intValue(), 4);
        assertEquals(iter.next().intValue(), 5);
        assertEquals(iter.next().intValue(), 6);
        assertEquals(iter.next().intValue(), 7);
        assertEquals(iter.next().intValue(), 8);
        assertFalse(iter.hasNext());
    }


    @Test
    public void test2() {
        List<List<Integer>> l = Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(),
            Arrays.asList(4, 5, 6),
            Arrays.asList(7, 8)
        );

        Iterator<Integer> iter = LOLIterator.listIterator(l);
        assertTrue(iter.hasNext());
        assertEquals(iter.next().intValue(), 1);
        assertEquals(iter.next().intValue(), 2);
        assertEquals(iter.next().intValue(), 3);
        assertTrue(iter.hasNext());
        assertTrue(iter.hasNext());
        assertEquals(iter.next().intValue(), 4);
        assertEquals(iter.next().intValue(), 5);
        assertEquals(iter.next().intValue(), 6);
        assertEquals(iter.next().intValue(), 7);
        assertEquals(iter.next().intValue(), 8);
        assertFalse(iter.hasNext());
    }
}
