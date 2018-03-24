//
// Created by haibo on 3/24/18.
//

#include "Islands.h"

void Islands::dfs(int i, int j, char e, char n, char o) {
    if (i < 0 || i >= matrix.size()) {
        return;
    }

    if (j < 0 || j >= matrix[0].size()) {
        return;
    }

    if (matrix[i][j] != n) {
        return;
    }
    matrix[i][j] = o;

    dfs(i - 1, j, e, n, o);
    dfs(i + 1, j, e, n, o);
    dfs(i, j - 1, e, n, o);
    dfs(i, j + 1, e, n, o);
}

int Islands::size() {
    if (matrix.size() == 0 || matrix[0].size() == 0) {
        return 0;
    }

    const auto r = matrix.size();
    const auto c = matrix[0].size();

    int n = 0;
    for (auto i = 0; i < r; i++) {
        for (auto j = 0; j < c; j++) {
            if (matrix[i][j] == '1') {
                dfs(i, j, '0', '1', '#');
                n++;
            }
        }
    }

    return n;
}

