//
// Created by haibo on 3/24/18.
//

#include "gtest/gtest.h"
#include "../../algorithm/datastructure/MagicDictionary.h"

TEST(MagicDictionaryTest, simple1) {
    MagicDictionary md;

    md.buildDict({"hello", "leetcode"});

    ASSERT_FALSE(md.search("hello"));
    ASSERT_TRUE(md.search("hhllo"));
    ASSERT_FALSE(md.search("hell"));
    ASSERT_FALSE(md.search("leetcoded"));
}

TEST(MagicDictionaryTest, simple2) {
    MagicDictionary md;

    md.buildDict({"hello", "hallo", "leetcode"});

    ASSERT_TRUE(md.search("hello"));
    ASSERT_TRUE(md.search("hhllo"));
    ASSERT_FALSE(md.search("hell"));
    ASSERT_FALSE(md.search("leetcoded"));
}
