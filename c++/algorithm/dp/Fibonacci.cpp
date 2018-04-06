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

#include "Fibonacci.h"
#include <iostream>

vector<vector<long>> Fibonacci::times(vector<vector<long>> m1, vector<vector<long>> m2, int r){
    vector<vector<long>> p;

    for (int i = 0; i < r; i++) {
        vector<long> l;
        for (int j = 0; j < r; j++) {
            l.push_back(0);
        }
        p.push_back(l);
    }

    for (int i = 0; i < r; i++) {
        for (int j = 0; j < r; j++) {
            for (int k = 0; k < r; k++) {
                p[i][j] += m1[i][k] * m2[k][j];
            }
        }
    }

    return p;
}

Fibonacci::Fibonacci() {
    vector<vector<long>> one = {
            {1, 1},
            {1, 0}
    };

    _twoFi[1] = one;

    for (int i = 1; i < 8; i++) {
        int k = 1 << i;
        vector<vector<long>> m = _twoFi[k / 2];
        _twoFi[k] = times(m, m, 2);
    }
}

long Fibonacci::nth(int n) {
    if (n < 3) {
        return 1;
    }
    n--;

    int l = n & -n;
    vector<vector<long>> m = _twoFi[l];
    n -= l;

    while(n > 0) {
        l = n & -n;
        m = times(m, _twoFi[l], 2);
        n -= l;
    }

    return m[0][0];
}