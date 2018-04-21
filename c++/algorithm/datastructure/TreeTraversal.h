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

#ifndef ALGORITHM_TREETRAVERSAL_H
#define ALGORITHM_TREETRAVERSAL_H

#include "TreeNode.h"
#include <vector>

using namespace std;

class TreeTraversal {
public:
    template<typename T> static  vector<T> preOrder(TreeNode<T>*);

    template<typename T> static vector<T> inOrder(TreeNode<T>*);

    template<typename T> static vector<T> postOrder(TreeNode<T>*);
};


#endif //ALGORITHM_TREETRAVERSAL_H
