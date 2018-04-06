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
// Created by haibo on 3/13/18.
//

#ifndef ALGORITHM_SLIDINGWINDOW_H
#define ALGORITHM_SLIDINGWINDOW_H

#include <vector>
#include <string>

using namespace std;

class SlidingWindow {
public:
    static vector<int> maxWindows(vector<int>&, int);

    static vector<double> median(vector<int>&, int);

    static string min_ordered(string, string);

    static string min_unordered(string, string);
};


#endif //ALGORITHM_SLIDINGWINDOW_H
