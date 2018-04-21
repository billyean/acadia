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
// Created by haibo on 4/19/18.
//

#ifndef ALGORITHM_TREE_H
#define ALGORITHM_TREE_H
#include <vector>
#include <stack>
#include <algorithm>

using namespace std;

template <class T>
class TreeNode {
public:
    TreeNode(T& t, TreeNode<T>* left, TreeNode<T>* right): t_(t), left_(left), right_(right) {}

    T& value() { return t_; }

    TreeNode<T>* left() { return left_; }

    TreeNode<T>* right() { return right_; }
private:
    TreeNode<T>* left_;
    TreeNode<T>* right_;
    T& t_;
};

#endif //ALGORITHM_TREE_H
