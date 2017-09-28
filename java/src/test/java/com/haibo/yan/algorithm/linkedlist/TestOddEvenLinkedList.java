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

import java.util.Arrays;
import java.util.List;

public class TestOddEvenLinkedList {
    @DataProvider
    public Object[][] oddEvenList() {
        ListNode oddNum1 = new ListNode(1);
        oddNum1.append(2).append(3).append(4).append(5);
        ListNode oddNum2 = new ListNode(1);
        ListNode evenNum1 = new ListNode(1);
        evenNum1.append(2).append(3).append(4);
        ListNode evenNum2 = new ListNode(1);
        evenNum2.append(2);

        return new Object[][]{
                {oddNum1, Arrays.asList(1, 3, 5, 2, 4)} ,
                {oddNum2, Arrays.asList(1)},
                {evenNum1, Arrays.asList(1, 3, 2, 4)} ,
                {evenNum2, Arrays.asList(1, 2)}
        };
    }

    @Test(dataProvider = "oddEvenList")
    public void test(ListNode<Integer> original, List<Integer> expected) {
        TestUtilities.assertLinkedListValues(OddEvenLinkedList.oddEvenList(original), expected);
    }
}
