/*
 *
 *  * Copyright [2018] [Haibo(Tristan) Yan]
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

package com.haibo.yan.algorithm.linkedlist;

import com.haibo.yan.algorithm.TestUtilities;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class TestLinkedNode {
    @DataProvider
    public Object[][] linkedNodes() {
        return new Object[][]{
                {ListNode.deserialize(""), Arrays.asList()},
                {ListNode.deserialize("5"), Arrays.asList(5)},
                {ListNode.deserialize("2#3"), Arrays.asList(3, 2)},
                {ListNode.deserialize("5#6#4"), Arrays.asList(4, 6, 5)},
                {ListNode.deserialize("7#2#4#3"), Arrays.asList(3, 4, 2, 7)},
                {ListNode.deserialize("9#9#9#9#5#3#1"), Arrays.asList(1, 3, 5, 9, 9, 9, 9)}
        };
    }

    @Test(dataProvider = "linkedNodes")
    public void test(ListNode<Integer> orig, List<Integer> expected) {
        TestUtilities.assertLinkedListValues(ListNode.reverse(orig), expected);
    }
}
