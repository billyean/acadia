//
// Created by Haibo Yan on 4/9/18.
//

#include "BinaryHeap.h"

template <class T>
void BinaryHeap::fixUp(int l) {
    if (l > 0 && l < heap_.size()) {
        int p = l >> 1;
        if (heap_[p] > heap_[l]) {
            iter_swap(heap_.begin() + p, _heap.begin() + l);
            fixUp(p);
        }
    }
}

template <class T>
void BinaryHeap::fixDown(int p) {
    if (p >= 0 && p < heap_.size()) {
        int l = p << 1 + 1;
        int r = l + 1;

        T m = heap_[p];
        int w = p;
        if (l < heap_.size() && heap_[l] < m) {
            m = heap_[l];
            w = l;
        }
        if (r < heap_size() && heap_[r] < m) {
            m = heap_[r];
            w = r;
        }
        if (p != w) {
            iter_swap(heap_.begin() + p, _heap.begin() + w);
            fixUp(w);
        }
    }
}

template <class T>
void BinaryHeap::add(T t) {
    heap_.push_back(t);
    fixUp(heap_.size() - 1);
}

