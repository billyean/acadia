//
// Created by haibo on 3/28/18.
//

#include "gtest/gtest.h"
#include "../../algorithm/array/MaxChunks.h"

TEST(MaxChunksTest, test1) {
    vector<int> test_data = {4, 3, 2, 1, 0};
    MaxChunks chunks(test_data);
    ASSERT_EQ(chunks.maxChunksToSorted(), 1);
}

TEST(MaxChunksTest, test2) {
    vector<int> test_data = {1, 0, 2, 3, 4};
    MaxChunks chunks(test_data);
    ASSERT_EQ(chunks.maxChunksToSorted(), 4);
}