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

package com.haibo.yan.algorithm.datastructure;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class TestLRU {
    private LRU<Integer, Integer> lru;

    @BeforeClass
    public void setup() {
        lru = new LRU<>(4);
    }

    @Test
    public void test() {
        lru.set(1,1);
        lru.set(2,2);
        assertEquals(lru.get(1).intValue(), 1);
        assertEquals(lru.get(2).intValue(), 2);
        assertNull(lru.get(3));
        lru.set(3,3);
        lru.set(4,4);
        assertEquals(lru.get(1).intValue(), 1);
        assertEquals(lru.get(2).intValue(), 2);
        assertEquals(lru.get(3).intValue(), 3);
        lru.set(5,5);
        assertNull(lru.get(4));
    }
}
