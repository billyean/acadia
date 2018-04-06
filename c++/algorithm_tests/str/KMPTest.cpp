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

