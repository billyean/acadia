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
// Created by Haibo Yan on 12/10/17.
//

#include <algorithm>
#include <queue>

using namespace std;

class MedianFinder {
public:
    /** initialize your data structure here. */
    priority_queue<int> large;

    priority_queue<int, vector<int>, greater<int> > small;

    MedianFinder();

    void addNum(int);

    double findMedian();
};
