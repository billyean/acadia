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

#include "Anagram.h"

#include <map>

bool Anagram::is_anagram(string s1, string s2) {
    int s1c[256], s2c[256];

    for (auto i = 0; i < s1.length(); i++) {
        s1c[s1[i]]++;
    }

    for (auto i = 0; i < s2.length(); i++) {
        s2c[s2[i]]++;
    }

    for (int i = 0; i < 256; i++) {
        if (s1c[i] != s2c[i]) {
            return false;
        }
    }

    return true;
}