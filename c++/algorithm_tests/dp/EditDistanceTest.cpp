//
// Created by Haibo Yan on 4/5/18.
//

#include "gtest/gtest.h"
#include "../../algorithm/dp/EditDistance.h"

TEST(EditDistanceTest, minDistance) {
    ASSERT_EQ(EditDistance::minD("FAMILY", "FRAME"), 4);
}

TEST(EditDistanceTest, oneDistance1) {
    ASSERT_FALSE(EditDistance::oneEditDistance("FAMILY", "FRAME"));
}

TEST(EditDistanceTest, oneDistance2) {
    ASSERT_TRUE(EditDistance::oneEditDistance("FAMILY", "AMILY"));
}

TEST(EditDistanceTest, oneDistance3) {
    ASSERT_FALSE(EditDistance::oneEditDistance("CAT", "CATOON"));
}

TEST(EditDistanceTest, oneDistance4) {
    ASSERT_TRUE(EditDistance::oneEditDistance("CAT", "CUT"));
}

TEST(EditDistanceTest, oneDistance5) {
    ASSERT_TRUE(EditDistance::oneEditDistance("CUTE", "CUT"));
}

TEST(EditDistanceTest, oneDistance6) {
    ASSERT_TRUE(EditDistance::oneEditDistance("ANT", "ANTE"));
}

TEST(EditDistanceTest, oneDistance7) {
    ASSERT_FALSE(EditDistance::oneEditDistance("ANT", "ANTLE"));
}