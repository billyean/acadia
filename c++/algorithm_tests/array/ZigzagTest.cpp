//
// Created by Haibo Yan on 3/13/18.
//

#include "gtest/gtest.h"
#include "../../algorithm/array/Zigzag.h"

TEST(ZigzagTest, PositiveNos) {
    Zigzag zigzag;

    ASSERT_EQ(zigzag.convert("PAYPALISHIRING", 3), "PAHNAPLSIIGYIR");
}