//
// Created by haibo on 3/13/18.
//


#include "gtest/gtest.h"
#include "../../algorithm/stack/MinStack.h"

TEST(MInStackTest, StackOps) {
    MinStack stack;

    stack.push(3);
    ASSERT_EQ (stack.top(), 3);
    ASSERT_EQ (stack.get_min(), 3);

    stack.push(5);
    ASSERT_EQ (stack.top(), 5);
    ASSERT_EQ (stack.get_min(), 3);

    stack.push(4);
    ASSERT_EQ (stack.top(), 4);
    ASSERT_EQ (stack.get_min(), 3);

    stack.push(2);
    ASSERT_EQ (stack.top(), 2);
    ASSERT_EQ (stack.get_min(), 2);

    stack.push(5);
    ASSERT_EQ (stack.top(), 5);
    ASSERT_EQ (stack.get_min(), 2);

    ASSERT_EQ (stack.pop(), 5);
    ASSERT_EQ (stack.top(), 2);
    ASSERT_EQ (stack.get_min(), 2);
    ASSERT_EQ (stack.pop(), 2);
    ASSERT_EQ (stack.top(), 4);
    ASSERT_EQ (stack.get_min(), 3);
}

