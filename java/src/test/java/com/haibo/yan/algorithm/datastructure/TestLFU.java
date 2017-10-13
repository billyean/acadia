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

package com.haibo.yan.algorithm.datastructure;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class TestLFU {
    private LFU<Integer, Integer> lfu;

    @BeforeClass
    public void setup() {
        lfu = new LFU<>(4);
    }

    @Test
    public void test() {
        lfu.set(1,1);
        lfu.set(2,2);
        assertEquals(lfu.get(1).intValue(), 1);
        assertEquals(lfu.get(2).intValue(), 2);
        assertNull(lfu.get(3));
        lfu.set(3,3);
        lfu.set(4,4);
        assertEquals(lfu.get(1).intValue(), 1);
        assertEquals(lfu.get(2).intValue(), 2);
        assertEquals(lfu.get(3).intValue(), 3);
        lfu.set(5,5);
        assertNull(lfu.get(4));
        assertEquals(lfu.get(5).intValue(), 5);
        assertEquals(lfu.get(5).intValue(), 5);
        assertEquals(lfu.get(5).intValue(), 5);
        lfu.set(4, 4);
        assertNull(lfu.get(3));
    }
}
