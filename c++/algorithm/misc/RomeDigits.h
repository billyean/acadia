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

#ifndef ALGORITHM_ROMEDIGITS_H
#define ALGORITHM_ROMEDIGITS_H

#include <vector>
#include <map>
#include <string>
#include <tuple>

using namespace std;

class RomeDigits {
public:
    RomeDigits();
    string int_to_rome(int);
    int rome_to_int(string);
private:
    map<char, int> _rtoi;
    vector<tuple<int, int, string, string>> _boundary;
};


#endif //ALGORITHM_ROMEDIGITS_H
