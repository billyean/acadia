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

package com.haibo.yan.algorithm.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public abstract class Graph<T> {
    protected HashMap<Vertex<T>, List<Vertex<T>>> verticesToAdjacents = new HashMap<>();

    protected HashMap<Vertex<T>, List<Edge<T>>> verticesToEdges = new HashMap<>();

    protected List<Edge<T>> edges;

    public Graph(Set<Vertex<T>> vertices) {
        this.verticesToAdjacents = new HashMap<>();
        this.edges = new ArrayList<>();

        vertices.forEach(vertex -> verticesToAdjacents.put(vertex, new ArrayList<>()));
    }

    public List<Vertex<T>> getAdjacents(Vertex<T> vertex) {
        return verticesToAdjacents.get(vertex);
    }

    public List<Edge<T>> getAllEdges(Vertex<T> vertex) {
        return verticesToEdges.get(vertex);
    }

    public Set<Vertex<T>> allVertices() {
        return verticesToAdjacents.keySet();
    }

    public abstract void addEdge(Edge<T> edge);
}
