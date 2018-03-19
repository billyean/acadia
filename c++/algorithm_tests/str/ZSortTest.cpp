//
// Created by haibo on 3/16/18.
//

#include "gtest/gtest.h"
#include "../../algorithm/str/ZSort.h"

TEST(ZSortTest, zsort1) {
    vector<string> v = {"Cow", "Chicken", "Deer", "Rabbit"};
    ZSort::zsort(v, 3);
    ASSERT_EQ(vector<string>({"Rabbit", "Deer", "Chicken", "Cow"}), v);
}

TEST(ZSortTest, zsort2) {
    vector<string> v = {"Cow", "Chbcken", "Deer", "Rabbit"};
    ZSort::zsort(v, 4);
    ASSERT_EQ(vector<string>({"Rabbit", "Chbcken", "Deer","Cow"}), v);
}

TEST(ZSortTest, zsort3) {
    vector<string> v = {};
    ZSort::zsort(v, 3);
    ASSERT_EQ(vector<string>(), v);
}