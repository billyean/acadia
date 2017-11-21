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

package com.haibo.yan.algorithm.linkedlist;

import com.haibo.yan.algorithm.TestUtilities;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class TestReverseKGroup {
    @DataProvider
    public Object[][] reverseLinkedList() {
        return new Object[][]{
                {ListNode.deserialize("1"), 10, ListNode.deserialize("1")},
                {ListNode.deserialize("1#2#3#4#5"), 1, ListNode.deserialize("1#2#3#4#5")},
                {ListNode.deserialize("1#2#3#4#5"), 2, ListNode.deserialize("2#1#4#3#5")},
                {ListNode.deserialize("1#2#3#4#5"), 3, ListNode.deserialize("3#2#1#4#5")},
                {ListNode.deserialize("1#2#3#4#5#6"), 2, ListNode.deserialize("2#1#4#3#6#5")},
                {ListNode.deserialize("1#2#3#4#5#6"), 3, ListNode.deserialize("3#2#1#6#5#4")},
        };
    }

    @Test(dataProvider = "reverseLinkedList")
    public void testReverseKGroup(ListNode<Integer> ln, int k, ListNode<Integer> expected) {
        TestUtilities.assertEquals(new ReverseKGroup().reverseKGroup(ln, k), expected);
    }
}
