//
// Created by Haibo Yan on 4/9/18.
//

#ifndef ALGORITHM_BINARYHEAP_H
#define ALGORITHM_BINARYHEAP_H

#include <vector>

using namespace std;

template <typename T> class BinaryHeap {
public:
    void add(T);

    void remove(T);

    T top() const;

    int size() const;

    bool exists(T);
private:
    vector<T> heap_;

    void fixUp(int);

    void fixDown(int);

    int exists(T, int);
};

template <typename T>
void BinaryHeap<T>::fixUp(int l) {
    if (l > 0 && l < heap_.size()) {
        int p = l >> 1;
        if (heap_[p] > heap_[l]) {
            iter_swap(heap_.begin() + p, heap_.begin() + l);
            fixUp(p);
        }
    }
}

template <typename T>
void BinaryHeap<T>::fixDown(int p) {
    if (p >= 0 && p < heap_.size()) {
        int l = (p << 1) + 1;
        int r = l + 1;

        T m = heap_[p];
        int w = p;
        if (l < heap_.size() && heap_[l] < m) {
            m = heap_[l];
            w = l;
        }
        if (r < heap_.size() && heap_[r] < m) {
            m = heap_[r];
            w = r;
        }
        if (p != w) {
            iter_swap(heap_.begin() + p, heap_.begin() + w);
            fixUp(w);
        }
    }
}

template <typename T>
void BinaryHeap<T>::add(T t) {
    heap_.push_back(t);
    fixUp(heap_.size() - 1);
}

template <typename T>
T BinaryHeap<T>::top() const {
    return heap_[0];
}

template <typename T>
int BinaryHeap<T>::size() const {
    return heap_.size();
}

template <typename T>
int BinaryHeap<T>::exists(T t, int p) {
    if (p < 0 || p >= heap_.size()) {
        return -1;
    }

    if (heap_[p] > t) {
        return -1;
    }

    if (heap_[p] == t) {
        return p;
    }

    int l = (p << 1) + 1, r = l + 1;
    int e = -1;
    if ((e = exists(t, l)) != -1) {
        return e;
    }

    if ((e = exists(t, r)) != -1) {
        return e;
    }

    return -1;
}

template <typename T>
bool BinaryHeap<T>::exists(T t) {
    return exists(t, 0) != -1;
}

template <typename T>
void BinaryHeap<T>::remove(T t) {
    int p = exists(t, 0);

    if (p >=0 && p < heap_.size() - 1) {
        iter_swap(heap_.begin() + p, heap_.begin() + heap_.size() - 1);
    }
    heap_.pop_back();
    fixDown(p);
}


#endif //ALGORITHM_BINARYHEAP_H
