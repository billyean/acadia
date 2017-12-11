//
// Created by Haibo Yan on 12/10/17.
// see https://leetcode.com/problems/find-median-from-data-stream/description/
//
// Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So
// the median is the mean of the two middle value.
//
// Examples:
// [2,3,4] , the median is 3
//
// [2,3], the median is (2 + 3) / 2 = 2.5
// Design a data structure that supports the following two operations:
// void addNum(int num) - Add a integer number from the data stream to the data structure.
// double findMedian() - Return the median of all elements so far.
// For example:
//
// addNum(1)
// addNum(2)
// findMedian() -> 1.5
// addNum(3)
// findMedian() -> 2
//

#include "MedianFinder.h"

MedianFinder::MedianFinder() {
}

void MedianFinder::addNum(int num) {
    if (small.size() == 0) {
        small.push(num);
    } else if (large.size() == 0) {
        large.push(num);
    } else {
        auto const s = small.top();
        auto const l = large.top();

        if (num <= l) {
            large.push(num);
        } else if  (num >= s) {
            small.push(num);
        } else if (small.size() > large.size()) {
            large.push(num);
        } else {
            small.push(num);
        }

        if (small.size() > large.size() + 1) {
            int const s = small.top();
            small.pop();
            large.push(s);
        } else if (large.size() > small.size() + 1) {
            int const s = large.top();
            large.pop();
            small.push(s);
        }
    }
}

double MedianFinder::findMedian() {
    if (small.size() == large.size()) {
        return small.top() / 2.0 + large.top() / 2.0;
    } else if (small.size() > large.size()) {
        return (double)small.top();
    } else {
        return (double)large.top();
    }
}