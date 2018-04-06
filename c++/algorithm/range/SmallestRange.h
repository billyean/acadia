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

#ifndef ALGORITHM_SMALLESTRANGE_H
#define ALGORITHM_SMALLESTRANGE_H

#include <vector>
#include <set>
#include <map>

using namespace std;

class SmallestRange {
public:
    vector<int> smallestRange(vector<vector<int>>&);
private:
    map<int, set<int>> merge(vector<vector<int>>&);
};


#endif //ALGORITHM_SMALLESTRANGE_H
