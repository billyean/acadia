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
// Created by haibo on 5/19/18.
//

#include "../../algorithm/matrix/Matrix.h"
#include "gtest/gtest.h"

TEST(MatrixTest, setZeroes1) {
    vector<vector<int>> test_matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };
    vector<vector<int>> expected = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };

    ASSERT_EQ(Matrix::spiralOrder(test_matrix), expected);
}

TEST(MatrixTest, spiralOrder1) {
    vector<vector<int>> test_matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };
    vector<int> expected = {1, 2, 3, 6, 9, 8, 7, 4, 5};

    ASSERT_EQ(Matrix::spiralOrder(test_matrix), expected);
}

TEST(MatrixTest, spiralMatrix1) {
    vector<vector<int>> expected = {
            {1, 2, 3, 4},
            {12, 13, 14, 5},
            {11, 16, 15, 6},
            {10, 9, 8, 7}
    };

    ASSERT_EQ(Matrix::spinalMatrix(4), expected);
}


