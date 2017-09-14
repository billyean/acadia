package com.haibo.yan.algorithm.array;

import org.testng.annotations.Test;

import static com.haibo.yan.algorithm.TestUtilities.assertEqualsWithLen;
import static org.testng.Assert.assertEquals;

public class TestRemoveDuplicate {
    public Object[][] arrayToResult() {
        return new Object[][]{
                {new int[]{3, 2, 2, 3}, 3, 2, new int[]{2 ,2}},
                {new int[]{3, 2, 2, 3}, 2, 2, new int[]{3 ,3}},
                {new int[]{3, 3, 3, 3}, 2, 4, new int[]{3 ,3, 3, 4}},
                {new int[]{3, 3, 3, 3}, 3, 0, new int[]{}},
        };
    }

    @Test
    public void testRemoveDuplicate(int[] original, int k, int expectedLen, int[] expectedArray) {
        int len = RemoveDuplicate.removeElement(original, k);
        assertEquals(len, expectedLen);

        assertEqualsWithLen(original, expectedArray, len);
    }
}
