//
// Created by haibo on 3/13/18.
//

#ifndef ALGORITHM_MINSTACK_H
#define ALGORITHM_MINSTACK_H

#include <iostream>
#include <algorithm>

using namespace std;

class Element {
    friend class MinStack;
public:
    Element(int v, Element *n): _val(v), _m(min(v, n == NULL ? v : n->_m)), _n(n) {}
private:
    int _val;

    int _m;

    Element *_n;
};

class MinStack {
public:
    void push(int);

    int pop();

    int top();

    int get_min();
private:
    Element *_top = NULL;
};


#endif //ALGORITHM_MINSTACK_H
