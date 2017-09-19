/*
 * Copyright [2017] [Haibo(Tristan) Yan]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.haibo.yan.algorithm;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestValidAnagram {
    @DataProvider
    public Object[][] anagramString() {
        return new Object[][] {
            {"anagram", "nagaram", true},
                {"rat", "cat", false}
        };
    }

    @Test(dataProvider = "anagramString")
    public void testIsAnagram(String s1, String s2, boolean expected) {
        assertEquals(ValidAnagram.isAnagram(s1, s2), expected);
    }
}
