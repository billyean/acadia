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
// Created by Haibo Yan on 12/12/17.
//

#include "gtest/gtest.h"
#include "../../algorithm/math/ArrangeCoins.h"

TEST(ArrangeCoinsTest, PositiveNos) {
    ArrangeCoins ac;

    ASSERT_EQ (ac.arrangeCoins(5), 2);
    ASSERT_EQ (ac.arrangeCoins(8), 3);
    ASSERT_EQ (ac.arrangeCoins(6), 3);
    ASSERT_EQ (ac.arrangeCoins(1804289383), 60070);
}
