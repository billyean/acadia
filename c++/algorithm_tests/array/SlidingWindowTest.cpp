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
