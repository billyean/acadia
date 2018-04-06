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

