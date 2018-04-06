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

#include "SingleNumber.h"

int SingleNumber::findInTwos() {
    int s = 0;

    for (auto i = nums_.begin(); i != nums_.end(); i++) {
        s ^= (*i);
    }

    return s;
}

int SingleNumber::findInThrees() {
    int one = 0;
    int two = 0;
    int three = 0;

    for (auto i = nums_.begin(); i != nums_.end(); i++) {
        two |= one & (*i);
        one ^= (*i);
        three = one & two;
        one &= ~three;
        two &= ~three;

    }

    return one;
}

int SingleNumber::findInFours() {
    int one = 0;
    int two = 0;
    int three = 0;
    int four = 0;

    for (auto i = nums_.begin(); i != nums_.end(); i++) {
        two |= one & (*i);
        one ^= (*i);
        three = one & two;
        four = three & ~(one);
        one &= ~four;
        two &= ~four;
        three &= ~four;
    }

    return one;
}