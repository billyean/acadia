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

package com.haibo.yan.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class PathSum {
    public int pathSum(BinaryTreeNode root, int sum) {
        int[] sumArray = new int[]{0, sum};
        pathSum(root, new ArrayList<>(), sumArray);
        return sumArray[0];
    }

    private void pathSum(BinaryTreeNode root, List<Integer> sumList, int[] sum) {
        if (root == null) {
            return;
        }

        sumList.add(sum[1]);


        sum[0] += sumList.stream().filter(v -> v == root.val).peek(System.out::println).count();

        List<Integer> nextLevl = sumList.stream().map(v -> v - root.val).collect(Collectors.toList());

        pathSum(root.left, nextLevl, sum);
        pathSum(root.left, nextLevl, sum);

        sumList.remove(sumList.size() - 1);
    }
}
