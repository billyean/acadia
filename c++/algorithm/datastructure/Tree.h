//
// Created by haibo on 4/19/18.
//

#ifndef ALGORITHM_TREE_H
#define ALGORITHM_TREE_H
#include <vector>
#include <stack>
#include <algorithm>

using namespace std;

template <class T>
class Tree {
public:
    Tree(T& t, Tree<T>* left, Tree<T>* right): t_(t), left_(left), right_(right) {}

    static vector<T> preOrder(Tree<T>*);

    static vector<T> inOrder(Tree<T>*);

    static vector<T> postOrder(Tree<T>*);
private:
    Tree<T>* left_;
    Tree<T>* right_;
    T& t_;
};

template <class T>
vector<T> Tree::preOrder(Tree<T>* root) {
    vector<T> ordered;
    stack<Tree<T>*> nodes;
    if (root != NULL) {
        nodes.push(root);

        while (!nodes.empty()) {
            Tree<T>* top = nodes.top();
            ordered.push_back(top->t_);
            nodes.pop();
            if (top->right_ != NULL) {
                nodes.push(top->right_);
            }
            if (top->left_ != NULL) {
                nodes.push(top->left_);
            }
        }
    }

    return ordered;
}

template <class T>
vector<T> Tree::inOrder(Tree<T>* root) {
    vector<T> ordered;

    if (root != NULL) {
        Tree<T>* current = root;
        stack<Tree<T>*> nodes;

        while (!nodes.empty() || current != NULL) {
            if (current != NULL) {
                if (current->left_ != NULL) {
                    nodes.push(current->left_);
                }
                current = current->left_;
            } else {
                Tree<T>* top = nodes.top();
                nodes.pop();
                ordered.push_back(top->t_);
                current = current->right_;
            }
        }
    }

    return ordered;
}



template <class T>
vector<T> Tree::postOrder(Tree<T>* root) {
    vector<T> ordered;

    if (root != NULL) {
        Tree<T>* prev = NULL;
        stack<Tree<T>*> nodes;
        nodes.push(root);

        while (!nodes.empty()) {
            Tree<T>* current = nodes.top();
            if (prev == NULL || current == prev->left_ || current == prev->right_) {
                if (current->left_ != NULL) {
                    nodes.push(current->left_);
                } else if (current->right_ != NULL) {
                    nodes.push(current->right_);
                }
            } else if (current->left_ == prev) {
                if (current->right_ != NULL) {
                    nodes.push(current->right_);
                } else {
                    ordered.push_back(current->t_);
                    nodes.pop();
                }
            } else {
                ordered.push_back(current->t_);
                nodes.pop();
            }
            prev = current;
        }
    }

    return ordered;
}
#endif //ALGORITHM_TREE_H
