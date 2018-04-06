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
// Created by haibo on 3/24/18.
//

#ifndef ALGORITHM_ISLANDS_H
#define ALGORITHM_ISLANDS_H

#include <vector>
#include <iostream>

using namespace std;

class Islands {
public:
    Islands(vector<vector<char>>& matrix_): matrix(matrix_){}

    int size();
private:
    vector<vector<char>>& matrix;

    void dfs(int, int, char, char, char);
};


#endif //ALGORITHM_ISLANDS_H
