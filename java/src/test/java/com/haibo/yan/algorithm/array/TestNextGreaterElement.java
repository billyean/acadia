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

package com.haibo.yan.algorithm.array;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestNextGreaterElement {
    @DataProvider
    public Object[][] nextElements() {
        return new Object[][] {
                {12, 21},
                {1234, 1243},
                {12443322, 13222344},
                {198765432, 213456789},
                {21, -1},
                {1999999999, -1},
        };
    }

    @Test(dataProvider = "nextElements")
    public void test(int value, int next) {
        System.out.printf("#######test value = %d\n", value);
        assertEquals(new NextGreaterElement().nextGreaterElementIII(value), next);
    }
}
