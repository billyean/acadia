/*
 * Copyright (c) [2017] [Haibo(Tristan) Yan]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.haibo.yan.algorithm.math;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigInteger;

import static org.testng.Assert.assertEquals;

public class TestMyBigInt {
    @DataProvider
    public Object[][] bigIntString() {
        return new Object[][]{
            {"0", "123"},
            {"123", "111"},
                {"-101", "110"},
                {"-101456789", "-34567890123456009"},
                {"+1234567891011121314151617181920212223242526", "-10099989796959493929190898887868584838281"},
                {"+1234567891011121314151617181920212223242526", "+10099989796959493929190898887868584838281"},
                {"-1234567891011121314151617181920212223242526", "10099989796959493929190898887868584838281"},
                {"1234567891011121314151617181920212223242526", "-10099989796959493929190898887868584838281"},
                {"1234567891011121314151617181920212223242526", "10099989796959493929190898887868584838281"},
        };
    }

    @Test(dataProvider = "bigIntString")
    public void testMultiply(String s1, String s2) {
        String actual = new MyBigInt().multiply(s1, s2);
        String expected = new BigInteger(s1).multiply(new BigInteger(s2)).toString();
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "bigIntString")
    public void testAdd(String s1, String s2) {
        String actual = new MyBigInt().add(s1, s2);
        String expected = new BigInteger(s1).add(new BigInteger(s2)).toString();
        assertEquals(actual, expected, String.format("%s + %s", s1, s2));
    }

    @Test(dataProvider = "bigIntString")
    public void testMinus(String s1, String s2) {
        String actual = new MyBigInt().minus(s1, s2);
        String expected = new BigInteger(s1).subtract(new BigInteger(s2)).toString();
        assertEquals(actual, expected, String.format("%s - %s", s1, s2));
    }
}
