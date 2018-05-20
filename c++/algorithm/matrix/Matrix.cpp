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
// Created by haibo on 5/11/18.
//

#include "Matrix.h"


void Matrix::setZeroes(vector<vector<int>>& matrix) {
    bool firstRowZero = false;
    bool firstColumnZero = false;


    for (int i = 0; i < matrix.size(); i++) {
        if (matrix[i][0] == 0) {
            firstColumnZero = true;
            break;
        }
    }

    for (int i = 0; i < matrix[0].size(); i++) {
        if (matrix[0][i] == 0) {
            firstRowZero = true;
            break;
        }
    }

    for (int i = 1; i < matrix.size(); i++) {
        for (int j = 1; j < matrix[0].size(); j++) {
            if (matrix[i][j] == 0) {
                matrix[i][0] = 0;
                matrix[0][j] = 0;
            }
        }
    }

    for (int i = 1; i < matrix.size(); i++) {
        if (matrix[i][0] == 0) {
            for (int j = 1; j < matrix[0].size(); j++) {
                matrix[i][j] = 0;
            }
        }
    }

    for (int i = 1; i < matrix[0].size(); i++) {
        if (matrix[0][i] == 0) {
            for (int j = 1; j < matrix.size(); j++) {
                matrix[j][i] = 0;
            }
        }
    }

    if (firstRowZero) {
        for (int i = 0; matrix[0].size(); i++) {
            matrix[0][i] = 0;
        }
    }

    if (firstColumnZero) {
        for (int i = 0; matrix.size(); i++) {
            matrix[i][0] = 0;
        }
    }
}

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements
 * of the matrix in spiral order.
 * For example, given the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 * @param matrix
 * @return
 */
vector<int> Matrix::spiralOrder(vector<vector<int>>& matrix) {
    vector<int> spiral;

    int m = matrix.size();
    int n = matrix.size() == 0 ? 0 : matrix[0].size();

    int x = 0, y = 0;
    while (m > 0 && n > 0) {
        // Handle last row or column when m or n is odd number.
        if (m == 1) {
            while (y <= n) {
                spiral.push_back(matrix[x][y++]);
            }
        } else if (n == 1) {
            while (x <= m) {
                spiral.push_back(matrix[x++][y]);
            }
        }

        // Every edge from 0 to len - 1
        for (int i = 0; i < n - 1; i++) {
            spiral.push_back(matrix[x][y++]);
        }
        for (int i = 0; i < m - 1; i++) {
            spiral.push_back(matrix[x++][y]);
        }
        for (int i = 0; i < n - 1; i++) {
            spiral.push_back(matrix[x][y--]);
        }
        for (int i = 0; i < m - 1; i++) {
            spiral.push_back(matrix[x--][y]);
        }

        x++;
        y++;
        m -= 2;
        n -= 2;
    }

    return spiral;
}

vector<vector<int>> Matrix::spinalMatrix(int n) {
    vector<vector<int>> matrix;
    for (int i = 0; i < n; i++) {
        vector<int> r(n, 0);
        matrix.push_back(r);
    }

    int i = 0;
    int v = 0;

    while (i < (n + 1) / 2) {
        int x = i;
        for (int j = i; j < n - i - 1; j++) {
            matrix[x][j] = ++v;
        }
        int y = n - i - 1;
        for (int j = i; j < n - i - 1; j++) {
            matrix[j][y] = ++v;
        }
        x = n - i - 1;
        for (int j = n - i - 1; j > i; j--) {
            matrix[x][j] = ++v;
        }
        y = i;
        for (int j = n - i - 1; j > i; j--) {
            matrix[j][y] = ++v;
        }
        i++;
    }

    return matrix;
}

bool Matrix::search1(vector<vector<int>>& matrix, int target) {
    int m = matrix.size(), n = matrix.size() == 0 ? 0 : matrix[0].size();

    int s = 0, e = m * n - 1;

    while (s <= e) {
        int med = (s + e) >> 1;
        int r = med / n;
        int c = med % n;
        if (matrix[r][c] > target) {
            e = med - 1;
        } else if (matrix[r][c] < target) {
            s = med + 1;
        } else {
            return true;
        }
    }

    return false;
}

bool Matrix::search2(vector<vector<int>>& matrix, int target) {
    int r = 0, c = matrix[0].size() - 1;

    while (r < 0 && c >= 0) {
        if (matrix[r][c] < target) {
            r++;
        } else if (matrix[r][c] > target) {
            c--;
        } else {
            return true;
        }
    }

    return false;
}