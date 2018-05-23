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

#ifndef ALGORITHM_RANGE_H
#define ALGORITHM_RANGE_H

#include <vector>

using namespace std;

class Range {
public:
    Range(int b, int e): b_(b), e_(e) {}

    static vector<vector<Range>> overlap(vector<Range>);

    int begin() const {
        return b_;
    }

    int end() const {
        return e_;
    }
private:
    int b_;
    int e_;
};


#endif //ALGORITHM_RANGE_H
