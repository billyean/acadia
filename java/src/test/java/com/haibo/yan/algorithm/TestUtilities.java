package com.haibo.yan.algorithm;

import com.haibo.yan.algorithm.linkedlist.ListNode;
import org.testng.Assert;

import java.io.PrintStream;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static org.testng.Assert.assertNull;


public class TestUtilities {
    /**
     *
     * @param list1
     * @param list2
     * @param <T>
     */
    public static <T> void assertEquals(List<List<T>> list1, List<List<T>> list2) {
        Assert.assertEquals(list1.size(), list2.size());

        for (int i = 0; i < list1.size(); i++) {
            Assert.assertEquals(list1.get(i), list2.get(i), String.format("%s != %s",
                    list1.get(i).stream().map(t -> t.toString()).collect(joining(",", "[", "]")),
                    list2.get(i).stream().map(t -> t.toString()).collect(joining(",", "[", "]"))));
        }
    }

    public static <T> void assertLinkedListValues(ListNode<T> head, List<T> expectedValues) {
        if (expectedValues == null || expectedValues.size() == 0) {
            assertNull(head);
        } else {
            for (int i = 0; i < expectedValues.size(); i++) {
                Assert.assertNotNull(head, String.format("Actual %dth Node is null", i));
                Assert.assertEquals(head.val, expectedValues.get(i));
                head = head.next;
            }
        }
    }

    public static <T> void assertEqualsWithLen(T[] actual, T[] expected, int len) {
        for (int i = 0; i < len; i++) {
            Assert.assertEquals(actual[i], expected[i]);
        }
    }

    public static void assertEqualsWithLen(int[] actual, int[] expected, int len) {
        for (int i = 0; i < len; i++) {
            Assert.assertEquals(actual[i], expected[i]);
        }
    }

    public static void assertEquals(int[] actual, int[] expected) {
        Assert.assertEquals(actual.length, expected.length);
        assertEqualsWithLen(actual, expected, actual.length);
    }

    public static <T extends Comparable> void assertEquals(ListNode<T> h1, ListNode<T> h2) {
        while (h1 != null && h2 != null) {
            Assert.assertEquals(h1.val.compareTo(h2.val), 0, String.format("h1.val = %s, h2.val = %s", h1.val, h2.val));
            h1 = h1.next;
            h2 = h2.next;
        }

        Assert.assertTrue(h1 == null && h2 == null);
    }
}
