//
// Created by haibo on 3/16/18.
//

#include "gtest/gtest.h"
#include "../../algorithm/str/RemoveLetters.h"

TEST(RemoveLettersTest, remove_bcabc) {
    ASSERT_EQ("abc", RemoveLetters::remove("bcabc"));
}

TEST(RemoveLettersTest, remove_cbacdcbc) {
    ASSERT_EQ("acdb", RemoveLetters::remove("cbacdcbc"));
}

