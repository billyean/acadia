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
// Created by haibo on 3/19/18.
//

#include "gmock/gmock.h"
#include "gmock/gmock-matchers.h"
#include <vector>
#include "../../algorithm/array/PrintPattern.h"

using namespace std;
using ::testing::ElementsAre;

// TODO: Stuck, must fix
//TEST(PrintPatternTest, patternCheckOn4) {
//    vector<vector<int>> p = PrintPattern::pattern(4);
//
//    ASSERT_THAT(p, ElementsAre(vector<int>{1},
//                               vector<int>{1, 1},
//                               vector<int>{2, 1},
//                               vector<int>{1, 2, 1, 1}));
//}

//TEST(PrintPatternTest, patternCheckOn8) {
//    vector<vector<int>> p = PrintPattern::pattern(8);
//
//    ASSERT_THAT(p, ElementsAre(vector<int>{1},
//                               vector<int>{1, 1},
//                               vector<int>{2, 1},
//                               vector<int>{1, 2, 1, 1},
//                               vector<int>{1, 1, 1, 2, 2, 1},
//                               vector<int>{3, 1, 2, 2, 1, 1},
//                               vector<int>{1, 3, 1, 1, 2, 2, 2, 1},
//                               vector<int>{1, 1, 1, 3, 2, 1, 3, 2, 1, 1}));
//}

