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
// Created by Haibo Yan on 5/22/18.
//

#include "gtest/gtest.h"
#include "../../algorithm/math/Rectangle.h"

TEST(RectangleTest, perfect) {
    vector<vector<int>> rectangles1 = {
            {1, 1, 3, 3},
            {3, 1, 4, 2},
            {3, 2, 4, 4},
            {1 ,3, 2, 4},
            {2, 3, 3, 4}
    };

    ASSERT_TRUE(Rectangle::isPerfect(rectangles1));

    vector<vector<int>> rectangles2 = {
            {1, 1, 2, 3},
            {1, 3, 2, 4},
            {3, 1, 4, 2},
            {3 ,2, 4, 4}
    };

    ASSERT_FALSE(Rectangle::isPerfect(rectangles2));

    vector<vector<int>> rectangles3 = {
            {1, 1, 3, 3},
            {3, 1, 4, 2},
            {1, 3, 2, 4},
            {2 ,2, 4, 4}
    };

    ASSERT_FALSE(Rectangle::isPerfect(rectangles3));

    vector<vector<int>> rectangles4 = {
            {1, 1, 3, 3},
            {3, 1, 4, 2},
            {1, 3, 2, 4},
            {2 ,2, 4, 4}
    };

    ASSERT_FALSE(Rectangle::isPerfect(rectangles4));

    vector<vector<int>> rectangles5 = {
            {0, 0, 1, 1},
            {0, 1, 3, 2},
            {1, 0, 2, 2}
    };

    ASSERT_FALSE(Rectangle::isPerfect(rectangles5));
}

