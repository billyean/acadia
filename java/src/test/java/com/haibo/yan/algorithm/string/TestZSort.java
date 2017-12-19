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

package com.haibo.yan.algorithm.string;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestZSort {
    @DataProvider
    public Object[][] stringsResult() {
        return new Object[][] {
                {new String[]{"Cow", "Chicken", "Deer", "Rabbit"}, 3,
                        new String[]{"Rabbit", "Deer", "Chicken", "Cow"}},
                {new String[]{"Cow", "Chbcken", "Deer", "Rabbit"}, 3,
                        new String[]{ "Chbcken", "Rabbit", "Deer","Cow"}},
                {new String[]{}, 3,
                        new String[]{ }},
                {new String[]{}, 3,
                        new String[]{ }},
        };
    }

    @Test(dataProvider = "stringsResult")
    public void testIsomorphic(String[] strings, int z, String[] zSorted) {
        assertEquals(new ZSort().SortByZ(strings, z), zSorted);
    }
}
