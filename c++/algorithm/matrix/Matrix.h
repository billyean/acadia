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
// Created by haibo on 5/11/18.
//

#ifndef ALGORITHM_MATRIX_H
#define ALGORITHM_MATRIX_H
#include <vector>

using namespace std;

class Matrix {
public:
    static void setZeroes(vector<vector<int>> &);

    static vector<int> spiralOrder(vector<vector<int>> &);

    static vector<vector<int>> spinalMatrix(int);

    static bool search1(vector<vector<int>> &, int);

    static bool search2(vector<vector<int>> &, int);
};


#endif //ALGORITHM_MATRIX_H
