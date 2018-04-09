//
// Created by haibo on 4/9/18.
//

#include "gtest/gtest.h"
#include "../../algorithm/datastructure/BinaryHeap.h"

TEST(BinaryHeapTest, SimpleTest) {
    BinaryHeap<int> bh;

    bh.add(2);
    bh.add(1);
    bh.add(3);

    ASSERT_TRUE(bh.exists(1));
    ASSERT_FALSE(bh.exists(4));
    ASSERT_EQ(bh.top(), 1);
    ASSERT_EQ(bh.size(), 3);

    bh.add(0);
    ASSERT_TRUE(bh.exists(1));
    ASSERT_FALSE(bh.exists(4));
    ASSERT_EQ(bh.top(), 0);
    ASSERT_EQ(bh.size(), 4);

    bh.add(4);
    ASSERT_TRUE(bh.exists(1));
    ASSERT_TRUE(bh.exists(4));
    ASSERT_EQ(bh.top(), 0);
    ASSERT_EQ(bh.size(), 5);

    bh.remove(1);
    ASSERT_FALSE(bh.exists(1));
    ASSERT_TRUE(bh.exists(4));
    ASSERT_EQ(bh.top(), 0);
    ASSERT_EQ(bh.size(), 4);

    bh.remove(0);
    ASSERT_FALSE(bh.exists(1));
    ASSERT_TRUE(bh.exists(4));
    ASSERT_EQ(bh.top(), 2);
    ASSERT_EQ(bh.size(), 3);

    bh.add(1);
    ASSERT_TRUE(bh.exists(1));
    ASSERT_TRUE(bh.exists(4));
    ASSERT_EQ(bh.top(), 1);
    ASSERT_EQ(bh.size(), 4);
}



