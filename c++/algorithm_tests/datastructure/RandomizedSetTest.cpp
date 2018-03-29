//
// Created by haibo on 3/29/18.
//

#include "gtest/gtest.h"
#include "../../algorithm/datastructure/RandomizedSet.h"

TEST(RandomizedSetTest, test1) {
    RandomizedSet set;

    ASSERT_TRUE(set.insert(1));
    ASSERT_FALSE(set.remove(2));
    ASSERT_TRUE(set.insert(2));

    set.getRandom();
    ASSERT_TRUE(set.remove(1));
    ASSERT_FALSE(set.insert(2));
    ASSERT_EQ(set.getRandom(), 2);
}

//TEST(RandomizedSetTest, test2) {
//    RandomizedSet set;
//
//    ASSERT_TRUE(set.insert(1));
//    ASSERT_FALSE(set.remove(2));
//    ASSERT_TRUE(set.insert(2));
//
//    set.getRandom();
//    ASSERT_TRUE(set.remove(1));
//    ASSERT_FALSE(set.insert(2));
//    ASSERT_EQ(set.getRandom(), 2);
//}