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
// Created by haibo on 3/16/18.
//

#ifndef ALGORITHM_UTILITIES_H
#define ALGORITHM_UTILITIES_H

#include <vector>
#include <string>

using namespace std;

class Utilities {
public:
    static vector<int> add_one(vector<int>&);

    static void sort_by_one_bits(vector<int>&);

    static int reverse(int);

    static vector<int> add(vector<int>&, vector<int>&);

    static int atoi(string);

    static bool ugly(int);

    static int nth_ugly(int);
private:
    static int bits(int);
};


#endif //ALGORITHM_UTILITIES_H
