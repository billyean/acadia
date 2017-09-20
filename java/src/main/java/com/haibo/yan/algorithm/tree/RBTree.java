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

package com.haibo.yan.algorithm.tree;

/**
 * Created by hyan on 2/7/17.
 */

import java.util.List;

public   class RBTree<T extends Comparable> {
    enum Color {
        Red,
        Black
    }

    private Color color;

    private RBTree<T> parent;

    private RBTree<T> left;

    private RBTree<T> right;

    private T value;

    public RBTree(T value) {
        this.color = Color.Red;
        this.value = value;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isRed() {
        return color == Color.Red;
    }


    public RBTree<T> leftChild() {
        return left;
    }

    public void setLeft(RBTree<T> newLeft) {
        this.left = newLeft;
    }

    public RBTree<T> rightChild() {
        return right;
    }

    public void setRight(RBTree<T> newRight) {
        this.right = newRight;
    }

    public RBTree<T> parent() {
        return parent;
    }

    public void setParent(RBTree<T> newParent) {
        this.parent = newParent;
    }

    private void normalize() {
        RBTree<T> p = this.parent;
        if (p != null && p.isRed()) {
            if (p.parent() != null) {
                RBTree<T> pp = p.parent();
                if (p == pp.leftChild()) {
                    if (pp.rightChild().isRed()) {
                        pp.setColor(Color.Red);
                        p.setColor(Color.Black);
                        pp.rightChild().setColor(Color.Black);
                        pp.normalize();
                    } else if (this == p.rightChild()) {
                        RBTree<T> cleft = this.left;
                        this.parent = p.parent();
                        this.left = p;
                        p.setParent(this);
                        p.setRight(cleft);
                        cleft.setParent(p);
                        p.normalize();
                    } else {
                        RBTree<T> pright = p.rightChild();
                        p.setColor(Color.Black);
                        pp.setColor(Color.Red);
                        p.setRight(pp);
                        pp.setParent(p);
                        pp.setLeft(pright);
                        pright.setParent(pp);
                    }
                } else {
                    if (pp.leftChild().isRed()) {
                        pp.setColor(Color.Red);
                        pp.leftChild().setColor(Color.Black);
                        p.setColor(Color.Black);
                        pp.normalize();
                    } else if (this == p.leftChild()) {
                        RBTree<T> cright = this.right;
                        this.parent = p.parent();
                        this.right = p;
                        p.setParent(this);
                        p.setLeft(cright);
                        cright.setParent(p);
                        p.normalize();
                    } else {
                        RBTree<T> pleft = p.leftChild();
                        p.setColor(Color.Black);
                        pp.setColor(Color.Red);
                        p.setLeft(pp);
                        pp.setParent(p);
                        pp.setLeft(pleft);
                        pleft.setParent(pp);
                    }
                }
            } else {
                p.setColor(Color.Black);
            }
        } else {
            this.color = Color.Black;
        }
    }
}
