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

package com.haibo.yan.algorithm.linkedlist;

import com.haibo.yan.algorithm.TestUtilities;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class TestAddTwoNumbers {

    @DataProvider
    public Object[][] addersI() {
        return new Object[][]{
                {ListNode.deserialize("4"), ListNode.deserialize("5"), Arrays.asList(9)},
                {ListNode.deserialize("2#4#3"), ListNode.deserialize("5#6#4"), Arrays.asList(7, 0, 8)},
                {ListNode.deserialize("7#2#4#3"), ListNode.deserialize("5#6#4"), Arrays.asList(2, 9, 8, 3)},
                {ListNode.deserialize("9#9#9#9#5#3#1"), ListNode.deserialize("2#4#7#2"), Arrays.asList(1, 4, 7, 2, 6, 3, 1)}
        };
    }

    @Test(dataProvider = "addersI")
    public void testAddNumbersI(ListNode<Integer> adder1, ListNode<Integer> adder2, List<Integer> expectedSum) {
        ListNode<Integer> actual = new AddTwoNumbers().addTwoNumbersI(adder1, adder2);
        TestUtilities.assertLinkedListValues(actual, expectedSum);
    }

    @DataProvider
    public Object[][] addersII() {
        return new Object[][]{
                {ListNode.deserialize("4"), ListNode.deserialize("5"), Arrays.asList(9)},
                {ListNode.deserialize("7#2#4#3"), ListNode.deserialize("5#6#4"), Arrays.asList(7, 8, 0, 7)},
                {ListNode.deserialize("9#9#9#9#5#3#1"), ListNode.deserialize("2#4#7#2"), Arrays.asList(1, 0, 0, 0, 2, 0, 0, 3)}
        };
    }

    @Test(dataProvider = "addersII")
    public void testAddNumbersII(ListNode<Integer> adder1, ListNode<Integer> adder2, List<Integer> expectedSum) {
        ListNode<Integer> actual = new AddTwoNumbers().addTwoNumbersII(adder1, adder2);
        TestUtilities.assertLinkedListValues(actual, expectedSum);
    }
}
