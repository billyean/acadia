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

package com.haibo.yan.algorithm.graph;

import java.util.*;

public class MST {
    /**
     * PRIM algorithm to calculate
     * @param graph
     * @return
     */
    public Set<WeightEdge<Integer>> prim(WeightUndirectGraph<Integer> graph) {
        Set<WeightEdge<Integer>> mst = new HashSet<>();

        HashMap<Integer, Integer> weights = new HashMap<>();

        HashMap<Integer, WeightEdge<Integer>> mstMap = new HashMap<>();

        Comparator<Vertex<Integer>> cmp
                = Comparator.comparing((Vertex<Integer> v) -> weights.containsKey(v.t) ? weights.get(v.t) : Integer.MAX_VALUE);

        PriorityQueue<Vertex<Integer>> minHeap = new PriorityQueue<>(cmp);

        Set<Vertex<Integer>> vertices = graph.allVertices();

        for (Vertex<Integer> vertex : vertices) {
            minHeap.add(vertex);
        }

        Vertex<Integer> first = vertices.iterator().next();

        weights.put(first.t, 0);

        int visited = 1;

        while (visited < vertices.size()) {
            Vertex<Integer> min = minHeap.poll();
            List<WeightEdge<Integer>> edges = graph.getAllEdges(min);

            for (WeightEdge<Integer> edge : edges) {
                Vertex<Integer> adjacent = edge.from == min ? edge.to : edge.from;
                if (!weights.containsKey(adjacent.t) || edge.getWeight() < weights.get(adjacent.t)) {
                    minHeap.remove(adjacent);
                    weights.put(adjacent.t, edge.getWeight()) ;
                    minHeap.add(adjacent);
                    mstMap.put(adjacent.value(), edge);
                }
            }
            visited++;
        }

        return new HashSet<>(mstMap.values());
    }

    public Set<WeightEdge<Integer>> krusal(WeightUndirectGraph<Integer> graph) {
        Set<WeightEdge<Integer>> mst = new HashSet<>();

        Set<Vertex<Integer>> vertices = graph.allVertices();

        HashMap<Integer, Vertex<Integer>> iMap = new HashMap<>();

        for (Vertex<Integer> v : vertices) {
            iMap.put(v.t, v);
        }

        UnionFind uf = new UnionFind(vertices.size());

        List<WeightEdge<Integer>> edges = graph.allWeightEdges();
        edges.sort(Comparator.comparing(WeightEdge::getWeight));

        int union = 0;

        for (WeightEdge<Integer> edge : edges) {
            if (union >= vertices.size() - 1) {
                break;
            }
            // Vertex is starting from 1 but Union-find works perfectly with zero based array.
            Vertex<Integer> f = edge.from, t = edge.to;
            int f1 = f.t - 1, t1 = t.t - 1;
            if (uf.findRoot(f1) != uf.findRoot(t1)) {
                uf.union(f1, t1);
                union++;
                mst.add(edge);
            }
        }

        return mst;
    }
}
