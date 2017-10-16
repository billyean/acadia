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

package com.haibo.yan.algorithm.dp;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestWildcardMatching {
    @DataProvider
    public Object[][] matchObjects() {
        return new Object[][]{
                {"aa","a", false} ,
                {"aa","aa", true} ,
                {"aaa","aa", false} ,
                {"aa","*", true} ,
                {"aa","a*", true},
                {"ab","?*", true},
                {"aab","c*a*b", false}
        };
    }

    @Test(dataProvider = "matchObjects")
    public void test(String string, String pattern, boolean expected) {
        assertEquals(WildcardMatching.isMatch(string, pattern), expected, String.format("s: %s, p: %s", string, pattern));
    }
}
