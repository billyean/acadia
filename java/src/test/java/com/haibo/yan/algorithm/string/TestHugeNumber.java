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

public class TestHugeNumber {
    @DataProvider
    public Object[][] numsAndHugest() {
        return new Object[][] {
                {new String[]{"20", "3005", "2"}, "3005220"},
                {new String[]{"2002", "20"}, "202002"},
                {new String[]{"200", "02"}, "20002"},
                {new String[]{"101", "102"}, "102101"},
                {new String[]{"02", "200"}, "20002"},
                {new String[]{"00201", "0020"}, "002010020"}
        };
    }

    @Test(dataProvider = "numsAndHugest")
    public void testHugeNumber(String[] nums, String expected) {
        assertEquals(new HugeNumber().hugeNumber(nums), expected);
    }
}
