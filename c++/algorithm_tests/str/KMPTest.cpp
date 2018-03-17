//
// Created by haibo on 3/17/18.
//

#include "gtest/gtest.h"
#include "../../algorithm/str/KMP.h"

TEST(KMPTest, substr_1) {
    ASSERT_EQ(-1, KMP::substr("BAAAB", "AAAA"));
}

TEST(KMPTest, substr_2) {
    ASSERT_EQ(1, KMP::substr("BAAAB", "AAA"));
}

TEST(KMPTest, substr_3) {
    ASSERT_EQ(1, KMP::substr("BAAAAB", "AAA"));
}

