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

#include "RotateArray.h"

void RotateArray::swap(int *array, int i, int j) {
    int t = array[i];
    array[i] = array[j];
    array[j] = t;
}

void RotateArray::reverse(int *array, int s, int e) {
    if (s >= e)
        return;

    int m = (s + e) >> 1;
    for (int i = s; i < m; i++) {
        int x = e - 1 - (i - s);
        swap(array, i, x);
    }
}

void RotateArray::rotateLeft(int *array, int len, int k) {
    int m = k % len;
    reverse(array, 0, m);
    reverse(array, m, len);
    reverse(array, 0, len);
}

void RotateArray::rotateRight(int *array, int len, int k) {
    rotateLeft(array, len, len - k  % len);
}