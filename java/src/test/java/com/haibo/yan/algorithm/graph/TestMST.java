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

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class TestMST {
    private WeightUndirectGraph<Integer> graph;

    private Set<WeightEdge<Integer>> expected = new HashSet<>();

    @BeforeClass
    public void setUp() {
        Set<Vertex<Integer>> set = new HashSet<>();
        Vertex<Integer> v1 = Vertex.createVertex(1, Integer.class);
        Vertex<Integer> v2 = Vertex.createVertex(2, Integer.class);
        Vertex<Integer> v3 = Vertex.createVertex(3, Integer.class);
        Vertex<Integer> v4 = Vertex.createVertex(4, Integer.class);
        Vertex<Integer> v5 = Vertex.createVertex(5, Integer.class);
        Vertex<Integer> v6 = Vertex.createVertex(6, Integer.class);
        set.add(v1);
        set.add(v2);
        set.add(v3);
        set.add(v4);
        set.add(v5);
        set.add(v6);
        graph = new WeightUndirectGraph<>(set);

        graph.addEdge(new WeightEdge<>(v1, v2, 3));
        WeightEdge<Integer> e1 = new WeightEdge<>(v1, v4, 1);
        graph.addEdge(e1);
        expected.add(e1);
        graph.addEdge(new WeightEdge<>(v2, v4, 3));
        WeightEdge<Integer> e2 = new WeightEdge<>(v2, v3, 1);
        graph.addEdge(e2);
        expected.add(e2);
        WeightEdge<Integer> e3 = new WeightEdge<>(v3, v4, 1);
        graph.addEdge(e3);
        expected.add(e3);
        graph.addEdge(new WeightEdge<>(v3, v5, 5));

        WeightEdge<Integer> e4 = new WeightEdge<>(v3, v6, 4);
        graph.addEdge(e4);
        expected.add(e4);
        graph.addEdge(new WeightEdge<>(v4, v5, 6));
        WeightEdge<Integer> e5 = new WeightEdge<>(v5, v6, 2);
        graph.addEdge(e5);
        expected.add(e5);

    }

    @Test
    public void testPrim() {
        System.out.println("Prim ...");
        MST mst = new MST();
        Set<WeightEdge<Integer>> minCut = mst.prim(graph);

        assertEquals(expected, minCut);
    }

    @Test
    public void testKrusal() {
        System.out.println("Krusal ...");
        MST mst = new MST();
        Set<WeightEdge<Integer>> minCut = mst.krusal(graph);

        assertEquals(expected, minCut);
    }

}
