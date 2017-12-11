//
// Created by Haibo Yan on 12/11/17.
//
#include "gtest/gtest.h"
#include "../../algorithm/datastructure/MedianFinder.h"

TEST(MedianFinderTest, PositiveNos) {
    MedianFinder mf;

    mf.addNum(1);
    mf.addNum(2);

    ASSERT_DOUBLE_EQ (mf.findMedian(), 1.50000);
}
