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
// Created by Haibo Yan on 5/22/18.
//

#include "Range.h"
#include <algorithm>

vector<vector<Range>> Range::overlap(vector<Range> ranges) {
    vector<vector<Range>> o;
    std::sort(ranges.begin(), ranges.end(), [](const Range& e1, const Range& e2){ return e1.begin() < e2.begin();});

    for (int i = 0; i < ranges.size() - 1; i++) {
        int j = i + 1;
        while (j < ranges.size() && ranges[j].begin() < ranges[i].end()) {
            vector<Range> r = {ranges[i], ranges[j]};
            o.push_back(r);
            j++;
        }
    }

    return o;
}