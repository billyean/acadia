package com.haibo.yan.algorithm;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class TestIterableIterator {
    @Test
    public void test1() {
        List<Integer>  l1 = Arrays.asList(1, 2, 3);
        List<Integer>  l2 = Arrays.asList(4, 5);
        List<Integer>  l3 = Arrays.asList(6);
        List<Integer>  l4 = Arrays.asList(7, 8, 9, 10);
        List<Integer>  l5 = Arrays.asList(11, 12, 13);
        List<Integer>  l6 = Arrays.asList(14, 15, 16, 17, 18, 19);

        List b3 = Arrays.asList(l6, 20);
        List b2 = Arrays.asList(21, 22, l5, Collections.emptyList());
        List b4 = Arrays.asList(Arrays.asList(Arrays.asList()));
        List a1 = Arrays.asList(Collections.emptyList(), l1, b2, b3, b4);

        IterableIterator<Integer> iter = new IterableIterator<>(a1);
        assertTrue(iter.hasNext());
        assertEquals(iter.next(), Integer.valueOf(1));
        assertEquals(iter.next(), Integer.valueOf(2));
        assertTrue(iter.hasNext());
        assertEquals(iter.next(), Integer.valueOf(3));
        assertEquals(iter.next(), Integer.valueOf(21));
        assertEquals(iter.next(), Integer.valueOf(22));
        assertEquals(iter.next(), Integer.valueOf(11));
        assertEquals(iter.next(), Integer.valueOf(12));
        assertEquals(iter.next(), Integer.valueOf(13));
        assertTrue(iter.hasNext());
        assertEquals(iter.next(), Integer.valueOf(14));
        assertEquals(iter.next(), Integer.valueOf(15));
        assertEquals(iter.next(), Integer.valueOf(16));
        assertEquals(iter.next(), Integer.valueOf(17));
        assertEquals(iter.next(), Integer.valueOf(18));
        assertEquals(iter.next(), Integer.valueOf(19));
        assertEquals(iter.next(), Integer.valueOf(20));
        assertFalse(iter.hasNext());
    }
}
