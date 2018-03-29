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

