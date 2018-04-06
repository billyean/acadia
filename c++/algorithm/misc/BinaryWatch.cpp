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
// Created by haibo on 3/14/18.
//

#include "BinaryWatch.h"
#include <sstream>

int BinaryWatch::bits(int h, int m) {
    auto b = 0;

    while (h > 0) {
        h -= h & -h;
        b++;
    }

    while (m > 0) {
        m -= m & -m;
        b++;
    }

    return b;
}

string BinaryWatch::time(int h, int m) {
    char out[6];

    snprintf(out, 6, "%d:%02d", h, m);
    return string(out);
}

BinaryWatch::BinaryWatch() {
    for (auto h = 0; h < 12; h++) {
        for (auto m = 0; m < 60; m++) {
            auto b = bits(h, m);
            auto s = time(h, m);

            if (_cache.find(b) == _cache.end()) {
                vector<string> single{s};
                _cache[b] = single;
            } else {
                _cache[b].push_back(s);
            }
        }
    }
}

vector<string> BinaryWatch::get_n(int n) {
    return _cache[n];
}