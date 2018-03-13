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