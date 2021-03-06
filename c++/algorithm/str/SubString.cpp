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

#include "SubString.h"
#include <queue>
#include <algorithm>
#include <iostream>
#include <map>

string SubString::longestNoRepeated(string s) {
    int m = 0;
    int p = 0;

    queue<char> norepeated;
    bool in[256];

    for (int i = 0; i < s.size(); i++) {
        char c = s[i];
        while (in[c]) {
           char cf = norepeated.front();
           in[cf] = false;
           norepeated.pop();
        }
        norepeated.push(c);
        in[c] = true;

        if (norepeated.size() > m) {
            m = norepeated.size();
            p = i + 1 - m;
        }
    }

    return m == 0 ? "" : s.substr(p, m);
}

string SubString::longestCommon(string s1, string s2) {
    vector<vector<int>> commons;

    for (int i = 0; i < s1.size() + 1; i++) {
        vector<int> r(s2.size() + 1, 0);
        commons.push_back(r);
    }

    int max = 0;
    int p = -1;
    for (int i = 1; i < s1.size() + 1; i++) {
        for (int j = 1; j < s2.size() + 1; j++) {
            if (s1[i - 1] == s2[j - 1]) {
                commons[i][j] = commons[i - 1][j - 1] + 1;
            } else {
                commons[i][j] = std::max(commons[i - 1][j], commons[i][j - 1]);
            }
            if (commons[i][j] > max) {
                max = commons[i][j];
                p = i - max;
            }
        }
    }

    return p == -1 ? "" : s1.substr(p, max);
}


// Given a string S and a string T, find the minimum window in S which will contain all the characters in T in
// complexity O(n).
//
//For example, S = "ADOBECODEBANC", T = "ABC", Minimum window is "BANC".
string SubString::minWinddow(string s, string t) {
    map<char, int> tm;
    int left = -1;

    string candidate;

    for (int i = 0; i < t.size(); i++) {
        char c = t[i];
        tm[c]++;
    }

    int ml = s.size() + 1;

    int count = 0;
    map<char, int> sm;
    for (int i = 0; i < s.size(); i++) {
        char c = s[i];

        if (tm[c] > 0) {
            sm[c]++;
            if (sm[c] <= tm[c]) {
                count++;
            }
            if (left == -1) {
                left = i;
            }
        }

        if (count == t.size()) {
            char fc = s[left];
            while (tm[fc] == 0 || sm[fc] > tm[fc]) {
                if (tm[fc] != 0) {
                    sm[fc]--;
                }
                left++;
                fc = s[left];
            }

            int len = i - left + 1;
            if (len < ml) {
                candidate = s.substr(left, len);
                ml = len;
            }

            sm[fc]--;
            left++;
            count--;
        }
    }

    return candidate;
}
