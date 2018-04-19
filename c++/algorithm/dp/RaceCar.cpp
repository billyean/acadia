//
// Created by haibo on 4/16/18.
//

#include "RaceCar.h"
#include <climits>
#include <algorithm>

int RaceCar::racecar(int target) {
    if (target < 2) {
        return target;
    }
    int steps[target + 1][target + 1];

    for (int i = 0; i < target + 1; i++) {
        steps[0][i] = i;
    }

    for (int i = 1; i <= target; i++) {
        for (int j = 0; j <= target; j++) {
            steps[i][j] = min(steps[i - 1][j], steps[i-1][j-1]);
        }
    }

    return steps[target][target];
}