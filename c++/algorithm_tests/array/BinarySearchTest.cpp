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


