//
// Created by Haibo Yan on 3/19/18.
//

#include "gtest/gtest.h"
#include "../../algorithm/array/BinarySearch.h"

TEST(BinarySearchTest, searchInOrdered) {
    int rotated[] = {1, 2, 3, 4, 5, 6, 7};

    ASSERT_EQ(BinarySearch::search(rotated, 7, 3), 2);
}

