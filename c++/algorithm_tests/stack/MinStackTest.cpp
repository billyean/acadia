//Copyright [2018] [Haibo Yan]
//
//Licensed under the Apache License, Version 2.0 (the "License");
//you may not use this file except in compliance with the License.
//You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
//Unless required by applicable law or agreed to in writing, software
//distributed under the License is distributed on an "AS IS" BASIS,
//WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//See the License for the specific language governing permissions and
//limitations under the License.

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

