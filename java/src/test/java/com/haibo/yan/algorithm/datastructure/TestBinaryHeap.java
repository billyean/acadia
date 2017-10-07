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

import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashMap;

import static org.testng.Assert.assertEquals;

public class TestBinaryHeap {
    @Test
    public void test() throws Exception {
        BinaryHeap<Integer, Integer> bi = new BinaryHeap<>(true, i -> i);

        bi.addElement(5);
        bi.addElement(6);
        bi.addElement(4);
        bi.addElement(3);
        bi.addElement(7);

        assertEquals(bi.extract().intValue(), 3);
        assertEquals(bi.extract().intValue(), 4);

        bi.addElement(8);
        bi.addElement(2);
        assertEquals(bi.extract().intValue(), 2);
        bi.addElement(1);
        assertEquals(bi.extract().intValue(), 1);
        assertEquals(bi.extract().intValue(), 5);
        assertEquals(bi.extract().intValue(), 6);
        assertEquals(bi.extract().intValue(), 7);
        assertEquals(bi.extract().intValue(), 8);

        try {
            bi.extract();
            throw new Exception("Should not reach here");
        } catch (IndexOutOfBoundsException ex) {
            //Pass
        }
    }

    @Test
    public void testWithComparator() throws Exception {
        BinaryHeap<Integer, Integer> bi = new BinaryHeap<>(true, i -> -i);

        bi.addElement(5);
        bi.addElement(6);
        bi.addElement(4);
        bi.addElement(3);
        bi.addElement(7);

        assertEquals(bi.extract().intValue(), 7);
        assertEquals(bi.extract().intValue(), 6);

        bi.addElement(8);
        bi.addElement(2);
        assertEquals(bi.extract().intValue(), 8);
        bi.addElement(1);
        assertEquals(bi.extract().intValue(), 5);
        assertEquals(bi.extract().intValue(), 4);
        assertEquals(bi.extract().intValue(), 3);
        assertEquals(bi.extract().intValue(), 2);
        assertEquals(bi.extract().intValue(), 1);

        try {
            bi.extract();
            throw new Exception("Should not reach here");
        } catch (IndexOutOfBoundsException ex) {
            //Pass
        }
    }



    @Test
    public void testDecrease() throws Exception {
        HashMap<Integer, Integer> map = new HashMap<>();

        BinaryHeap<Integer, Integer> bi = new BinaryHeap<>(true, map::get);
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        map.put(5, 5);
        map.put(6, 6);
        map.put(7, 7);
        map.put(8, 8);

        bi.addElement(5);
        bi.addElement(6);
        bi.addElement(4);
        bi.addElement(3);
        bi.addElement(7);

        assertEquals(bi.extract().intValue(), 3);
        map.put(7, 0);
        bi.decrease(7);
        assertEquals(bi.extract().intValue(), 7);

        bi.addElement(8);
        bi.addElement(2);
        map.put(8, 1);
        bi.decrease(8);
        assertEquals(bi.extract().intValue(), 8);
    }
}
