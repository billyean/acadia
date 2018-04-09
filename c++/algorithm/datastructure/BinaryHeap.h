//
// Created by Haibo Yan on 4/9/18.
//

#ifndef ALGORITHM_BINARYHEAP_H
#define ALGORITHM_BINARYHEAP_H

#include <vector>

using namespace std;

template <class T>
class BinaryHeap {
public:
    void add(T);

    void remove(T);

    T top();
private:
    vector<T> heap_;

    void fixUp(int);

    void fixDown(int);
};


#endif //ALGORITHM_BINARYHEAP_H
