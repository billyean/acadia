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
#include "../../algorithm/array/RotateArray.h"

TEST(RotateArrayTest, rotateLeft_0) {
    int array[] = {1, 2, 3, 4, 5, 6, 7};
    RotateArray::rotateLeft(array, 7, 0);
    int expected[] = {1, 2, 3, 4, 5, 6, 7};

    for (int i = 0; i < 7; i++) {
        ASSERT_EQ(array[i], expected[i]);
    }
}

TEST(RotateArrayTest, rotateLeft_1) {
    int array[] = {1, 2, 3, 4, 5, 6, 7};
    RotateArray::rotateLeft(array, 7, 1);
    int expected[] = {2, 3, 4, 5, 6, 7, 1};
    for (int i = 0; i < 7; i++) {
        ASSERT_EQ(array[i], expected[i]);
    }
}

TEST(RotateArrayTest, rotateRight_1) {
    int array[] = {1, 2, 3, 4, 5, 6, 7};
    RotateArray::rotateRight(array, 7, 1);
    int expected[] = {7, 1, 2, 3, 4, 5, 6};
    for (int i = 0; i < 7; i++) {
        ASSERT_EQ(array[i], expected[i]);
    }
}
