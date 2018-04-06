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
// Created by haibo on 3/16/18.
//

#include "gtest/gtest.h"
#include "../../algorithm/dp/Fibonacci.h"

TEST(FibonacciTest, nth) {
    vector<tuple<int, long>> test_data = {
                    {1, 1},
                    {2, 1},
                    {3, 2},
                    {4, 3},
                    {5, 5},
                    {6, 8},
                    {7, 13},
                    {8, 21},
                    {9, 34},
                    {23, 28657},
                    {50, 12586269025},
                    {92, 7540113804746346429}
            };

    Fibonacci fibonacci;

    for (auto t = test_data.begin(); t != test_data.end(); t++) {
        long e = get<1>(*t);
        int p = get<0>(*t);
        ASSERT_EQ(e, fibonacci.nth(p));
    }


}

