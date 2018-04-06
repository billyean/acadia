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
// Created by Haibo Yan on 4/5/18.
//

#include "EditDistance.h"

int EditDistance::minD(string s1, string s2) {
    int d[s1.size()][s2.size()];

    for (int i = 0; i < s1.size(); i++) {
        d[i][0] = s1[i] == s2[0] ? 0: 1;
    }
    for (int j = 0; j < s2.size(); j++) {
        d[0][j] = s1[0] == s2[j] ? 0: 1;
    }

    for (int i = 1; i < s1.size(); i++) {
        for (int j = 0; j < s2.size(); j++) {
            if (s1[i] == s2[j]) {
                d[i][j] = d[i - 1][j - 1];
            } else {
                d[i][j] = min(min(d[i - 1][j], d[i - 1][j - 1]), d[i][j - 1]) + 1;
            }
        }
    }

    return d[s1.size() - 1][s2.size() - 1];
}

bool EditDistance::oneEditDistance(string s1, string s2) {
    int d = s1.size() - s2.size();

    if (d < -1 || d > 1) {
        return false;
    }

    for (int i = 0; i < min(s1.size(), s2.size()); i++) {
        if (s1[i] != s2[i]) {
            if (d == 0) {
                return equals(s1, s2, i + 1, i + 1, s1.size() - i - 1);
            } else if (d == -1) {
                return equals(s1, s2, i, i + 1, s1.size() - i);
            } else {
                return equals(s1, s2, i + 1, i, s2.size() - i);
            }
        }
    }

    return true;
}

bool EditDistance::equals(string s1, string s2, int b1, int b2, int l) {
    int e1 = b1 + l, e2 = b2 + l;
    if (e1 > s1.size() || e2 > s2.size()) {
        return false;
    }

    for (int i = 0; i < l; i++) {
        if (s1[i + b1] != s2[i + b2]) {
            return false;
        }
    }

    return true;
}