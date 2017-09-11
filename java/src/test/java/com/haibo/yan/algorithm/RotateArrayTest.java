package com.haibo.yan.algorithm;


import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test
public class RotateArrayTest {
    public void testRotate() {
        int[] testArray1 = new int[]{1, 2, 3};

        RotateArray instance = new RotateArray();

        instance.rotateRight(testArray1, 4);
    }
}
