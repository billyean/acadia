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

package com.haibo.yan.algorithm.dp;

public class PaintHouse {
    /**
     * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost
     * of painting each house with a certain color is different. You have to paint all the houses such that no two
     * adjacent houses have the same color.
     * The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example,
     * costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with
     * color green, and so on... Find the minimum cost to paint all houses.
     */
    public int minCost(int[][] costs) {
        if(costs==null || costs.length==0)
            return 0;

        for(int i=1; i<costs.length; i++){
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
        }

        int m = costs.length-1;
        return Math.min(Math.min(costs[m][0], costs[m][1]), costs[m][2]);
    }
}
