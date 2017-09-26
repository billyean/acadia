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

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.haibo.yan.algorithm.TestUtilities.assertLinkedListValues;

public class TestReorder {
    @DataProvider
    public Object[][] reorderLL() {
        Node<Integer> ll1 = new Node(1);
        ll1.append(2).append(3).append(4);

        Node<Integer> ll2 = new Node(1);
        ll2.append(2).append(3).append(4).append(5);

        return new Object[][] {
                {ll1, Arrays.asList(1, 4, 2, 3)},
                {ll2, Arrays.asList(1, 5, 2, 4, 3)},
        };
    }

    @Test(dataProvider = "reorderLL")
    public void testReorder(Node<Integer> head, List<Integer> array) {
        ReorderList.reorder(head);
        assertLinkedListValues(head, array);
    }
}
