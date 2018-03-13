//
// Created by Haibo Yan on 3/13/18.
//

#include "gtest/gtest.h"
#include "../../algorithm/array/RemoveDuplicate.h"

TEST(RemoveDuplictaeTest, RemoveDuplicate) {
    RemoveDuplicate rd;
    vector<int> vec1;
    vec1.push_back(1);
    vec1.push_back(2);
    vec1.push_back(2);

    ASSERT_EQ(rd.removeDuplicates(vec1), 2);
}

TEST(RemoveDuplictaeTest, removeDuplicateAtMostTwice) {
    RemoveDuplicate rd;
    vector<int> vec1;
    vec1.push_back(1);
    vec1.push_back(2);
    vec1.push_back(3);
    vec1.push_back(2);
    vec1.push_back(3);
    vec1.push_back(3);

    ASSERT_EQ(rd.removeDuplicateAtMostTwice(vec1), 5);
}
