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
// Created by haibo on 3/13/18.
//

#include "MinStack.h"

void MinStack::push(int value) {
    _top = new Element(value, _top);
}


int MinStack::pop() {
    if (_top == NULL) {
        throw runtime_error("Empty stack");
    }

    int r = _top->_val;
    _top = _top->_n;

    return r;
}

int MinStack::top() {
    if (_top == NULL) {
        throw runtime_error("Empty stack");
    }

    return _top->_val;
}

int MinStack::get_min() {
    if (_top == NULL) {
        throw runtime_error("Empty stack");
    }

    return _top->_m;
}