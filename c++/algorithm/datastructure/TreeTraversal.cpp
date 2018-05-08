//Copyright [2018] [Haibo Yan]
//
//Licensed under the Apache License, Version 2.0 (the "License");
//you may not use this file except in compliance with the License.
//You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
//Unless required by applicable law or agreed to in writing, software
//distributed under the License is distributed on an "AS IS" BASIS,
//WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//See the License for the specific language governing permissions and
//limitations under the License.
//
// Created by Haibo Yan on 4/20/18.
//

#include "TreeTraversal.h"

template <class T>
vector<T> TreeTraversal::preOrder(TreeNode<T>* root) {
    vector<T> ordered;
    stack<TreeNode<T>*> nodes;
    if (root != NULL) {
        nodes.push(root);

        while (!nodes.empty()) {
            TreeNode<T>* top = nodes.top();
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
vector<T> TreeTraversal::inOrder(TreeNode<T>* root) {
    vector<T> ordered;

    if (root != NULL) {
        TreeNode<T>* current = root;
        stack<TreeNode<T>*> nodes;

        while (!nodes.empty() || current != NULL) {
            if (current != NULL) {
                if (current->left_ != NULL) {
                    nodes.push(current->left_);
                }
                current = current->left_;
            } else {
                TreeNode<T>* top = nodes.top();
                nodes.pop();
                ordered.push_back(top->t_);
                current = current->right_;
            }
        }
    }

    return ordered;
}

template <class T>
vector<T> TreeTraversal::postOrder(TreeNode<T>* root) {
    vector<T> ordered;

    if (root != NULL) {
        TreeNode<T>* prev = NULL;
        stack<TreeNode<T>*> nodes;
        nodes.push(root);

        while (!nodes.empty()) {
            TreeNode<T>* current = nodes.top();
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
