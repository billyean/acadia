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

#include <algorithm>
#include <iostream>
#include "Utilities.h"

vector<int> Utilities::add(vector<int>& v1, vector<int>& v2) {
    vector<int> r;

    int l1 = v1.size(), l2 = v2.size();
    int c = 0;
    int i = 0;
    for (i = 0; i < min(l1, l2); i++) {
        int s = v1[i] + v2[i] + c;
        c = s >= 10 ? 1 : 0;
        r.push_back(s % 10);
    }

    for (; i < l1; i++) {
        int s = v1[i] + c;
        c = s >= 10 ? 1 : 0;
        r.push_back(s % 10);
    }

    for (; i < l2; i++) {
        int s = v1[2] + c;
        c = s >= 10 ? 1 : 0;
        r.push_back(s % 10);
    }

    if (c == 1) {
        r.push_back(1);
    }
    return r;
}

vector<int> Utilities::add_one(vector<int>& v) {
    vector<int> r;

    int c = 1;

    for (int i = v.size() - 1; i >= 0; i--) {
        int s = c + v[i];
        c = s == 10 ? 1 : 0;
        s %= 10;
        r.push_back(s);
    }

    if (c == 1) {
        r.push_back(1);
    }
    std::reverse(r.begin(), r.end());

    return r;
}

int Utilities::atoi(string s) {
    int base = 10;

    int i = 0;
    bool pos = true;

    if (s[i] == '+' || s[i] == '-') {
        pos = s[i] == '+';
        i++;
    }
    if (s[i] == '0') {
        base = 8;
        i++;
        if (s[i] == 'x' || s[i] == 'X') {
            base = 16;
            i++;
        }
    }

    int value = 0;
    for (int j = i; j < s.size(); j++) {
        char c = s[j];
        value *= base;
        if (c >= '0' && c <='9') {
            value += c - '0';
        } else if (c >= 'a' && c <='f') {
            value += c - 'a' + 10;
        } else if (c >= 'A' && c <='F') {
            value += c - 'A' + 10;
        }
    }
    return pos ? value : -value;
}

bool Utilities::ugly(int n) {
    if (n < 1) {
        return false;
    }

    if (n == 1) {
        return true;
    }

    if (n % 2 == 0) {
        return ugly(n / 2);
    }

    if (n % 3 == 0) {
        return ugly(n / 3);
    }

    if (n % 5 == 0) {
        return ugly(n / 5);
    }

    return false;
}

int Utilities::nth_ugly(int n) {
    bool ugly[15626];

    for (int i = 0; i < 15626; i++) {
        ugly[i] = false;
    }

    for (int v : {1,2,3,4,5,6}) {
        ugly[v] = true;
    }

    int l = 2, u = 5;

    if (n <= 6) {
        return n;
    }

    int i = 2;

    while (i < n && l < 15626) {
        int i2 = l * 2;
        int i3 = l * 3;
        int i5 = l * 5;
        u = max(u, i5);
        if (i2 < 15626)
            ugly[i2] = true;
        if (i3 < 15626)
            ugly[i3] = true;
        if (i5 < 15626)
            ugly[i5] = true;
        do {
            l++;
        } while (!ugly[l]);
        i++;
    }
    return l;
}

int Utilities::reverse(int n) {
    int r = 0;

    while (n != 0) {
        int d = n % 10;
        n /= 10;
        r *= 10;
        r += d;
    }

    return r;
}

int Utilities::bits(int n) {
    int b = 0;
    while (n != 0) {
        n -= n & -n;
        b++;
    }
    return b;
}

void Utilities::sort_by_one_bits(vector<int> &nums) {
    sort(nums.begin(), nums.end(), [](int i1, int i2){ return bits(i1) < bits(i2);});
}
