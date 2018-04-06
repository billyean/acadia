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
// Created by haibo on 3/28/18.
//

#include "gtest/gtest.h"
#include "../../algorithm/array/TaskScheduler.h"

TEST(TaskSchedulerTest, simple1) {
    vector<char> test_data = {'A', 'A', 'A', 'B', 'B', 'B'};
    ASSERT_EQ(TaskScheduler::leastInterval(test_data, 2), 8);
}

TEST(TaskSchedulerTest, simple2) {
    vector<char> test_data = {'A', 'A', 'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C'};
    ASSERT_EQ(TaskScheduler::leastInterval(test_data, 2), 15);
}

TEST(TaskSchedulerTest, simple3) {
    vector<char> test_data = {'A', 'A', 'A', 'B', 'B', 'B'};
    ASSERT_EQ(TaskScheduler::leastInterval(test_data, 0), 6);
}

TEST(TaskSchedulerTest, simple4) {
    vector<char> test_data = {'A', 'A', 'A', 'B', 'B', 'B'};
    ASSERT_EQ(TaskScheduler::leastInterval(test_data, 50), 104);
}

TEST(TaskSchedulerTest, simple5) {
    vector<char> test_data = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
    ASSERT_EQ(TaskScheduler::leastInterval(test_data, 2), 15);
}

