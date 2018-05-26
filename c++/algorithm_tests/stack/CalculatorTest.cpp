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
// Created by Haibo Yan on 5/25/18.
//

#include "gtest/gtest.h"
#include "../../algorithm/stack/Calculator.h"

TEST(CalculatorTest, simple1) {
    ASSERT_EQ(Calculator::calculate("1 + 1"), 2);
    ASSERT_EQ(Calculator::calculate("(1 - (4-5))"), 2);
    ASSERT_EQ(Calculator::calculate("2 + (3 + (5 - 1))"), 9);
    ASSERT_EQ(Calculator::calculate("(1 + (3 - 2)) +  (5 - 1)"), 6);
    ASSERT_EQ(Calculator::calculate("3 + 5 - (11 + (3 - 2)) +  (5 - 1)"), 0);
}

