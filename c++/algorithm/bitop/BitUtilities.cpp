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
// Created by haibo on 3/28/18.
//

#include "BitUtilities.h"
#include <iostream>

using namespace std;

void BitUtilities::swap(int *v1, int *v2) {
    int v = (*v1) ^ (*v2);
    *v1 ^= v;
    *v2 ^= v;
}

bool BitUtilities::powerOfTwo(int n) {

    return (n & (n - 1)) == 0;
}

bool BitUtilities::powerOfFour(int n) {
    return n == 1 || (n & (n - 1)) == 0 && (n & 0xaaaaaaaa )== 0;
}
