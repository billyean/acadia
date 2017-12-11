//
// Created by Haibo Yan on 12/10/17.
//

#include <algorithm>
#include <queue>

using namespace std;

class MedianFinder {
public:
    /** initialize your data structure here. */
    priority_queue<int> large;

    priority_queue<int, vector<int>, greater<int> > small;

    MedianFinder();

    void addNum(int num);

    double findMedian();
};
