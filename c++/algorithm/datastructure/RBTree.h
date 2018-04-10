//
// Created by haibo on 4/9/18.
//

#ifndef ALGORITHM_RBTREE_H
#define ALGORITHM_RBTREE_H

#include <iostream>

enum Color {red, black};

template <typename T>
class RBTreeNode {
friend class RBTree;
public:
    RBTreeNode(RBTreeNode<T>* parent, RBTreeNode<T>* left, RBTreeNode<T>* right, T* t, Color color):
            parent_(parent), left_(left), right_(right), t_(t), color_(color) {
    }

    static RBTreeNode<T>* Nil = new RBTreeNode(Nil, Nil, Nil, NULL, black);
private:
    RBTreeNode<T>* parent_;

    RBTreeNode<T>* left_;

    RBTreeNode<T>* right_;

    T* t_;

    Color color_;
};

template <typename T>
class RBTree {

private:
    RBTreeNode<T>* root_;

    static void rotateLeft(RBTree t, RBTreeNode<T>* x) {
        RBTreeNode<T>* left = x->left_;
        RBTreeNode<T>* y = x->right_;
        RBTreeNode<T>*  p = x->parent_;

        x->right_ = y->left_;
        if (y->left_ != RBTreeNode::Nil) {
            y->left_->parent_ = x;
        }
        y->left_ = x;
        x->parent_ = y;
        y->parent_ = p;

        if (p == RBTreeNode::Nil) {
            t.root_ = y;
        } else if (p->left_ == x) {
            p->left_ = y;
        } else {
            p->right_ = y;
        }
    };

    static void rotateRight(RBTree t, RBTreeNode<T>* x) {
        RBTreeNode<T>* y = x->left_;
        RBTreeNode<T>* right = x->right_;
        RBTreeNode<T>*  p = x->parent_;

        x->left_ = y->right_;
        if (y->right_ != RBTreeNode::Nil) {
            y->right_->parent_ = x;
        }
        y->right_ = x;
        x->parent_ = y;
        y->parent_ = p;

        if (p == RBTreeNode::Nil) {
            t.root_ = y;
        } else if (p->left_ == x) {
            p->left_ = y;
        } else {
            p->right_ = y;
        }
    };

    static void rbInsertFixUp(RBTree t, RBTreeNode<T>* z) {
        while (z->parent_->color_ == red) {
            RBTreeNode<T>* p = z->parent_;
            if (p->parent_ != RBTreeNode::Nil) {
                if (p == p->parent_->left_) {
                    if (p->parent_->right_->color_ == red) {
                        p->color_ = black;
                        p->parent_->right_->color_ = black;
                        p->parent_->color_ = red;
                        z = p->parent_;
                    } else if (z == p->right_) {
                        rotateLeft(t, z->parent_);
                        z = p;
                    }
                    p->color_ = black;
                    p->parent_->color_ = red;
                    rotateRight(t, p->parent_);
                } else {
                    if (p->parent_->left_->color_ == red) {
                        p->color_ = black;
                        p->parent_->left_->color_ = black;
                        p->parent_->color_ = red;
                        z = p->parent_;
                    } else if (z == p->left_) {
                        rotateRight(t, z->parent_);
                        z = p;
                    }
                    p->color_ = black;
                    p->parent_->color_ = red;
                    rotateLeft(t, p->parent_);
                }
            }
        }
        t.root_->color_ = black;
    }
};


#endif //ALGORITHM_RBTREE_H
