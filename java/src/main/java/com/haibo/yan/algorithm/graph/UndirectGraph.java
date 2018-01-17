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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UndirectGraph<T> extends Graph {
    public UndirectGraph(Set<Vertex<T>> vertices) {
        super(vertices);
    }

    @Override
    public void addEdge(Edge edge) {
        edges.add(edge);

        Vertex<T> from = edge.from;
        Vertex<T> to = edge.to;

        List<Vertex<T>> fadjacents = (List<Vertex<T>>)verticesToAdjacents.getOrDefault(from, new ArrayList<>());
        fadjacents.add(to);
        verticesToAdjacents.put(from, fadjacents);
        List<Vertex<T>> tadjacents = (List<Vertex<T>>)verticesToAdjacents.getOrDefault(to, new ArrayList<>());
        tadjacents.add(from);
        verticesToAdjacents.put(to, tadjacents);


        List<Edge<T>> fedges = (List<Edge<T>>)verticesToEdges.getOrDefault(from, new ArrayList<>());
        fedges.add(edge);
        verticesToEdges.put(from, fedges);

        List<Edge<T>> tedges = (List<Edge<T>>)verticesToEdges.getOrDefault(to, new ArrayList<>());
        tedges.add(edge);
        verticesToEdges.put(to, tedges);
    }
}
