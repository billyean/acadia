package com.haibo.yan.algorithm;

import org.testng.Assert;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class TestUtilities {
    public static <T> void assertEquals(List<List<T>> list1, List<List<T>> list2) {
        Assert.assertEquals(list1.size(), list2.size());

        for (int i = 0; i < list1.size(); i++) {
            Assert.assertEquals(list1.get(i), list2.get(i), String.format("%s != %s",
                    list1.get(i).stream().map(t -> t.toString()).collect(joining(",", "[", "]")),
                    list2.get(i).stream().map(t -> t.toString()).collect(joining(",", "[", "]"))));
        }
    }
}
