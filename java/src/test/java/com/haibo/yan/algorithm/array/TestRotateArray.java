package com.haibo.yan.algorithm.array;


import com.haibo.yan.algorithm.array.RemoveDuplicate;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test
public class TestRotateArray {
    public void testRotate() {
        int[] testArray1 = new int[]{1, 2, 3};

        RotateArray instance = new RotateArray();

        instance.rotateRight(testArray1, 4);
    }
}
