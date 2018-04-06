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
// Created by haibo on 3/19/18.
//

#include "PrintPattern.h"

string PrintPattern::count_and_say(int n) {
    if (n < 1) {
        return "";
    }

    string saying = "1";

    for (int i = 2; i < n; i++) {
        string next = "";
        for (int j = 0; j < saying.size(); j++) {
            int v = saying[j++] - '0';
            int c = 1;
            while (j < saying.size() && saying[j] == saying[j - 1]) {
                c++;
            }
            next += c;
            next += v;
        }
        saying = next;
    }

    return saying;
}


vector<vector<int>> PrintPattern::pattern(int n) {
    vector<vector<int>> p;

    if (n >= 1) {
        vector<int> v{1};
        p.push_back(v);

        for (int i = 2; i < n; i++) {
            vector<int> n;
            vector<int> l = p[p.size() - 1];
            for (int j = 0; j < l.size(); j++) {
                int v = l[j];
                int c = 1;
                while (j < l.size() && l[j] == l[j - 1]) {
                    c++;
                }
                n.push_back(c);
                n.push_back(v);
            }
            p.push_back(n);
        }
    }

    return p;
}