//
// Created by Haibo Yan on 4/4/18.
//

#include "gmock/gmock.h"
#include "../../algorithm/array/SlidingWindow.h"

TEST(SlidingWindowTest, maxWindow1) {
    vector<int> windows = {1, 3, -1, -3, 5, 3, 6, 7};
    vector<int> expected = {3, 3, 5, 5, 6, 7};
    ASSERT_EQ(SlidingWindow::maxWindows(windows, 3), expected);
}

TEST(SlidingWindowTest, maxWindow2) {
    vector<int> empty = {};
    ASSERT_EQ(SlidingWindow::maxWindows(empty, 1), empty);
}

TEST(SlidingWindowTest, maxWindow3) {
    vector<int> windows = {1, 3, 1, 2, 0, 5};
    vector<int> expected = {3, 3, 2, 5};
    ASSERT_EQ(SlidingWindow::maxWindows(windows, 3), expected);
}

TEST(SlidingWindowTest, maxWindow4) {
    vector<int> windows = {7, 2, 4};
    vector<int> expected = {7, 4};
    ASSERT_EQ(SlidingWindow::maxWindows(windows, 2), expected);
}
