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

import com.haibo.yan.algorithm.math.AddOne;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestAddOne {
    @DataProvider
    public Object[][] addOneDP(){
        return new Object[][]{
                {new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 6}} ,
                {new int[]{1, 9, 9, 9}, new int[]{2, 0, 0, 0}} ,
                {new int[]{9, 9}, new int[]{1, 0, 0}} ,
        };
    }

    @Test(dataProvider = "addOneDP")
    public void test(int[] input, int[] expected) {
        assertEquals(AddOne.addOne(input), expected);
    }
}
