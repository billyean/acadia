//
// Created by haibo on 3/13/18.
//

#include "SlidingWindow.h"
#include <deque>
#include <iostream>

// Maintains a deque that max value position in the windows is in the front of deque, all elements less than max value
// following the max value position will be kept as ordered.
vector<int> SlidingWindow::maxWindows(vector<int>& nums, int k) {
    deque<int> deque;
    vector<int> windows;

    cout << endl;
    for (int i = 0; i < nums.size(); i++) {
        int c = nums[i];
        if (deque.size() != 0 && i - deque.front() == k) {
            deque.pop_front();
        }
        while (deque.size() > 0 && c > nums[deque.back()]) {
            deque.pop_back();
        }

        deque.push_back(i);

        if (i >= k - 1) {
            windows.push_back(nums[deque.front()]);
        }
    }

    return windows;
}