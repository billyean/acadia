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
// Created by Haibo Yan on 3/19/18.
//

#include "gtest/gtest.h"
#include "../../algorithm/array/BinarySearch.h"

TEST(BinarySearchTest, searchInOrdered) {
    int rotated[] = {1, 2, 3, 4, 5, 6, 7};

    ASSERT_EQ(BinarySearch::search(rotated, 7, 3), 2);
}

TEST(BinarySearchTest, searchInRotatedLeft) {
    int rotated[] = {7, 1, 2, 3, 4, 5, 6};

    ASSERT_EQ(BinarySearch::search(rotated, 7, 3), 3);
}

TEST(BinarySearchTest, searchInRotatedRight) {
    int rotated[] = {3, 4, 5, 6, 7, 1, 2};

    ASSERT_EQ(BinarySearch::search(rotated, 7, 3), 0);
}

TEST(BinarySearchTest, searchInOrderedWithEqual) {
    int rotated[] = {1, 2, 3, 3, 4, 5, 5, 6, 6, 7};

    ASSERT_EQ(BinarySearch::search(rotated, 10, 3), 2);
}

TEST(BinarySearchTest, searchInRotatedLeftWithEqual) {
    int rotated[] = {6, 7, 1, 2, 3, 3, 4, 5, 5, 6};

    ASSERT_EQ(BinarySearch::search(rotated, 10, 3), 4);
}

TEST(BinarySearchTest, searchInRotatedRightWithEqual) {
    int rotated[] = {3, 4, 5, 5, 6, 6, 7, 1, 2, 3};

    ASSERT_EQ(BinarySearch::search(rotated, 10, 3), 0);
}


