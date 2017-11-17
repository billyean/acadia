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

package com.haibo.yan.algorithm.datastructure;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.testng.Assert.assertEquals;

public class TestMagicDictionary {
    @DataProvider
    public Object[][] dictionaryProvider() {
        return new Object[][]{
                {new String[]{"hello", "leetcode"},
                new HashMap<String, Boolean>(){
                    { put("hello", false);
                        put("hhllo", true);
                        put("hell", false);
                        put("leetcoded", false);}
                }},
                {new String[]{"hello", "hallo", "leetcode"},
                        new HashMap<String, Boolean>(){
                            { put("hello", true);
                                put("hhllo", true);
                                put("hell", false);
                                put("leetcoded", false);}
                        }},
        };
    }

    @Test(dataProvider = "dictionaryProvider")
    public void test(String[] words, HashMap<String, Boolean> testMap) {
        MagicDictionary dict = new MagicDictionary();
        dict.buildDict(words);

        for (String wordCheck : testMap.keySet()) {
            assertEquals(dict.search(wordCheck), testMap.get(wordCheck).booleanValue(),
                    String.format("%s is expected to be %b\n", wordCheck, testMap.get(wordCheck).booleanValue()));
        }
    }
}
