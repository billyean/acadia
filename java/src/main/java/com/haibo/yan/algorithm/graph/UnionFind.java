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

package com.haibo.yan.algorithm.graph;

import java.util.stream.IntStream;

public class UnionFind {
    final int[] vertices;

    final int[] roots;

    final int[] weights;

    public UnionFind(int n) {
        vertices = IntStream.range(0, n).toArray();
        roots = IntStream.range(0, n).toArray();
        weights = IntStream.range(0, n).map(i -> 1).toArray();
    }

    public int findRoot(int v) {
        while (roots[v] != v) {
            return findRoot(roots[v]);
        }

        return v;
    }

    public void union(int v1, int v2) {
        int r1 = findRoot(v1), r2 = findRoot(v2);

        if (r1 != r2) {
            int r = weights[r1] > weights[r2] ? r1 : r2;
            int c = (r == r1) ? r2 : r1;
            roots[c] = r;
            weights[r] += weights[c];
        }
    }
}
