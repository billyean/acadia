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
// Created by Haibo Yan on 3/19/18.
//

#include "BinarySearch.h"

#include <iostream>
#include <climits>

using namespace std;

int BinarySearch::search(int *rotated, int len, int k) {
    return search(rotated, k, 0, len);
}

int BinarySearch::search(int *rotated, int k, int s, int e) {
    if (s > e) {
        return -1;
    }

    int m = (s + e) >> 1;

    if (k < rotated[m]) {
        if (rotated[s] < rotated[m] && k >= rotated[e - 1] && k > rotated[s]) {
            return search(rotated, k, m + 1, e);
        } else {
            return search(rotated, k, s, m - 1);
        }
    } else if (k > rotated[m]) {
        if (rotated[e - 1] > rotated[m] && k < rotated[s]) {
            return search(rotated, k, s, m - 1);
        } else {
            return search(rotated, k, m + 1, e);
        }
    } else {
        while (m - 1 > 0 && rotated[m - 1] == k) {
            m--;
        }

        return m;
    }
}

double BinarySearch::median(vector<int>& v1, vector<int>& v2) {
    int l = v1.size() + v2.size();

    if ((l & 0x01) == 0) {
        return (kth(v1, v2, l / 2, 0, 0) + kth(v1, v2, l / 2 + 1, 0, 0)) / 2.0;
    } else {
        return kth(v1, v2, l / 2, 0, 0) / 1.0;
    }
}

int BinarySearch::kth(vector<int>& v1, vector<int>& v2, int k, int s1, int s2) {
    if (s1 >= v1.size()) {
        return v2[s2 + k - 1];
    }

    if (s2 >= v2.size()) {
        return v1[s1 + k - 1];
    }

    if (k == 1) {
        return min(v1[s1], v2[s2]);
    }

    int m1 = s1 + k / 2 - 1;
    int m2 = s2 + k / 2 - 1;

    int mid1 = m1 < v1.size() ? v1[m1] : INT_MAX;
    int mid2 = m2 < v2.size() ? v2[m2] : INT_MAX;

    if (mid1 < mid2) {
        return kth(v1, v2, k - k / 2, m1 + 1, s2);
    } else {
        return kth(v1, v2, k - k / 2, s1, m2 + 1);
    }

}

