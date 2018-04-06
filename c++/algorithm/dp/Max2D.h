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
// Created by Haibo Yan on 4/5/18.
//

#ifndef ALGORITHM_MAX2D_H
#define ALGORITHM_MAX2D_H

#include <vector>

using namespace std;

class Max2D {
public:
    static int square(vector<vector<char>>&);

    static int rect(vector<vector<char>>&);

    static int histogram(vector<int>&);
};


#endif //ALGORITHM_MAX2D_H
