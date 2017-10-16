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

package com.haibo.yan.algorithm.datastructure;

public class RBTree<T extends Comparable> {
    RBTreeNode<T> root;

    private void leftRotate(RBTreeNode<T> node) {
        RBTreeNode<T> right = node.right;
        RBTreeNode<T> p = node.p;

        if (p != null) {
            right.p = p;
            if (node == p.left) {
                p.left = right;
            } else {
                p.right = right;
            }
        }

        RBTreeNode<T> left = node.left;

        if (right.left != null) {
            node.right = right.left;
            right.left.p = node;
        }

        right.left = node;
        node.p = right;
    }

    private void rightRotate(RBTreeNode<T> node) {
        RBTreeNode<T> p = node.p;
        RBTreeNode<T> right = node.right;

        if (p != null) {
            p.left = right;
            if (right != null) {
                right.p = p;
            }

            RBTreeNode<T> pp = p.p;
            node.p = pp;
            if (pp != null) {
                if (p == pp.left) {
                    pp.left = node;
                } else {
                    pp.right = node;
                }
            }

            node.right = p;
            p.p = node;
        }
    }
}
