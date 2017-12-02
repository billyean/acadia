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

package com.haibo.yan.algorithm.tree;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class TestDeleteBST {
    @DataProvider
    public Object[][] bst(){
        return new Object[][]{
                {BinaryTreeNode.deserialize("5!3!2!##4!##6!#7!##"),
                        3,
                        BinaryTreeNode.deserialize("5!2!#4!##6!#7!##")
                }
        };
    }

    @Test(dataProvider = "bst")
    public void test(BinaryTreeNode tree, int key, BinaryTreeNode expected) {
        assertTrue(BinaryTreeNode.deleteNode(tree, key).equals(expected));
    }
}
