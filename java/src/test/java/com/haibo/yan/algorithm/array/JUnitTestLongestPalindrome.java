/*
 *
 *  * Copyright [2017] [Haibo(Tristan) Yan]
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *     http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.haibo.yan.algorithm.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.*;


@RunWith(Parameterized.class)
public class JUnitTestLongestPalindrome {
    @Parameter(0)
    public String string;

    @Parameter(1)
    public int expectedLen;

    @Parameters(name = "{index}: string={0} expectedLen={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][] { {"abaxabaxabybaxabyb", 11},
                        {"abaxabaxabb", 9},
                        {"abc1234321ab", 7} });
    }

    @Test
    public void testSum() {
        assertEquals(new LongestPalindrome().lenOfLongest(string.toCharArray()), expectedLen);
    }

}
