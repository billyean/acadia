//
// Created by haibo on 3/24/18.
//

#include "gtest/gtest.h"
#include "../../algorithm/matrix/Islands.h"

TEST(IslandsTest, simple1) {
    vector<vector<char>> test_matrix = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
    };

    Islands il(test_matrix);

    ASSERT_EQ(il.size(), 1);
}

TEST(IslandsTest, simple2) {
    vector<vector<char>> test_matrix = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
    };

    Islands il(test_matrix);

    ASSERT_EQ(il.size(), 3);
}

TEST(IslandsTest, simple3) {
    vector<vector<char>> test_matrix = {
            {'1','0','0','0'},
            {'0','1','0','0'},
            {'0','0','1','0'},
            {'0','0','0','1'}
    };

    Islands il(test_matrix);

    ASSERT_EQ(il.size(), 4);
}

TEST(IslandsTest, simple4) {
    vector<vector<char>> test_matrix = {};

    Islands il(test_matrix);

    ASSERT_EQ(il.size(), 0);
}

