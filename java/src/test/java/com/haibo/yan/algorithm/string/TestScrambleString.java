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

public class TestScrambleString {
    @DataProvider
    public Object[][] testStrings() {
        return new Object[][]{
                {"great", "rgeat", true},
                {"great", "rgtae", true},
        };
    }

    @Test(dataProvider = "testStrings")
    public void test(String str1, String str2, boolean isScarmbled) {
        assertEquals(new ScrambleString().isScramble(str1, str2), isScarmbled, String.format("str1 = %s, str2 = %s", str1, str2));
    }
}
