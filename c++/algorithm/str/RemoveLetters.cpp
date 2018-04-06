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

#include "RemoveLetters.h"

#include <deque>
#include <iostream>

string RemoveLetters::remove(string word) {
    deque<char> d = {};
    int cn[256];
    bool in_queue[256];

    // I was surprised that C++ is not initialized the array with default value.
    // At least in my ubuntu 16.04, it doesn't initiate in_queue
    for (int i = 0 ; i < 256; i++) {
        cn[i] = 0;
        in_queue[i] = false;
    }

    for (int i = 0; i < word.length(); i++) {
        cn[word[i]]++;
    }

    for (int i = 0; i < word.length(); i++) {
        char c = word[i];
        cn[c]--;

        if (in_queue[c]) {
            continue;
        }

        while (d.begin() != d.end() && d.back() > c && cn[d.back()] > 0) {
            in_queue[d.back()] = false;
            d.pop_back();
        }
        in_queue[c] = true;
        d.push_back(c);
    }

    string r = "";

    for (auto i = d.begin(); i != d.end(); i++) {
        r += (*i);
    }

    return r;
}