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

package com.haibo.yan.algorithm.linkedlist;

import com.haibo.yan.algorithm.TestUtilities;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestSwapPairs {
    @DataProvider
    public Object[][] linkedList() {
        return new Object[][]{
                {ListNode.deserialize("1#2#3#4"), ListNode.deserialize("2#1#4#3")},
                {ListNode.deserialize("1#2#3"), ListNode.deserialize("2#1#3")}
        };
    }

    @Test(dataProvider = "linkedList")
    public void testSwap(ListNode<Integer> original, ListNode<Integer> expected) {
        TestUtilities.assertEquals(SwapPairs.swap(original), expected);
    }

    @Test(dataProvider = "linkedList")
    public void testSwapWithExtra(ListNode<Integer> original, ListNode<Integer> expected) {
        TestUtilities.assertEquals(SwapPairs.swapWithExtraNode(original), expected);
    }
}
