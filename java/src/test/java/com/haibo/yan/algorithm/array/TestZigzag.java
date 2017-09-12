package com.haibo.yan.algorithm.array;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test
public class TestZigzag {
    @DataProvider
    public Object[][] zigzagArray() {
        return new Object[][] {
                {"PAYPALISHIRING", 1, "PAYPALISHIRING"},
                {"PAYPALISHIRING", 2, "PYAIHRNAPLSIIG"},
                {"PAYPALISHIRING", 3, "PAHNAPLSIIGYIR"},
        };
    }

    @Test(dataProvider = "zigzagArray")
    public void testZigzagArray(String original, int row, String expected) {
        assertEquals(new Zigzag().convert(original, row), expected);
    }
}
