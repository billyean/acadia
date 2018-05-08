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
//limitations under the License
//
// Created by Haibo Yan on 4/20/18.
//

#include "gtest/gtest.h"
#include "../../algorithm/array/GasStation.h"

TEST(GasStationTest, simple1) {
    vector<int> gas = {1, 2, 3, 4, 5};
    vector<int> cost = {3, 4, 5, 1, 2};
    ASSERT_EQ(GasStation::canCompleteCircuit(gas, cost), 3);
}


TEST(GasStationTest, simple12) {
    vector<int> gas = {2, 3, 4};
    vector<int> cost = {3, 4, 3};
    ASSERT_EQ(GasStation::canCompleteCircuit(gas, cost), -1);
}


TEST(GasStationTest, simple13) {
    vector<int> gas = {3, 1, 1};
    vector<int> cost = {1, 2, 2};
    ASSERT_EQ(GasStation::canCompleteCircuit(gas, cost), 0);
}