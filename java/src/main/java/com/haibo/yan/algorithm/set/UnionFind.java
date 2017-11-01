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

package com.haibo.yan.algorithm.set;

import java.util.HashMap;

public class UnionFind {
    private static HashMap<Integer, UnionFind> flyweights = new HashMap<>();

    private final int node;

    private UnionFind parent;

    private int weight;

    private UnionFind(int node) {
        this.node = node;
        this.parent = null;
        this.weight = 0;
    }

    public UnionFind getInstance(int node) {
        UnionFind instance = flyweights.getOrDefault(node, new UnionFind(node));
        flyweights.put(node, instance);
        return instance;
    }

    UnionFind union(UnionFind other) {
        UnionFind a1 = this.root(), a2 = other.root();
        UnionFind newRoot = a1.getWeight() > a2.getWeight() ?  a1 : a2;
        UnionFind newKid = a1.getWeight() > a2.getWeight() ?  a2 : a1;
        newRoot.setWeight(a1.getWeight() + a2.getWeight());
        newKid.setParent(newRoot);
        return newRoot;
    }

    UnionFind root() {
        if (parent != null) {
            return parent.root();
        } else {
            return this;
        }
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public UnionFind getParent() {
        return parent;
    }

    public void setParent(UnionFind parent) {
        this.parent = parent;
    }
}
