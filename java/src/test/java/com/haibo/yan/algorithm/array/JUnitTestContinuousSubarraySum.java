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

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class JUnitTestContinuousSubarraySum {
    @Parameter(0)
    public int[] array;

    @Parameter(1)
    public int sum;

    @Parameter(2)
    public boolean expected;

    @Parameters(name = "{index}: array={0} sum={1} expected={2}")
    public static Collection<Object[]> data() {
       return Arrays.asList(new Object[][]{
               {new int[]{23, 2, 4, 6, 7}, 6, true},
               {new int[]{23, 2, 6, 4, 7}, 6, true},
               {new int[]{23, 2, 4, 6, 7}, 7, true},
               {new int[]{23, 2, 4, 6, 7}, 23, false},
               {new int[]{23, 2, 4, 6, 7}, -6, true},
               {new int[]{0, 0}, 0, true},
       });

    }

    @Test
    public void test() {
        Assert.assertEquals(new ContinuousSubarraySum().checkSubarraySum(array, sum), expected);
    }
}
