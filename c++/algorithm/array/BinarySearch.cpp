//
// Created by Haibo Yan on 3/19/18.
//

#include "BinarySearch.h"

#include <iostream>

using namespace std;

int BinarySearch::search(int *rotated, int len, int k) {
    search(rotated, k, 0, len);
}

int BinarySearch::search(int *rotated, int k, int s, int e) {
    if (s > e) {
        return -1;
    }

    int m = (s + e) >> 1;

    if (k < rotated[m]) {
        if (rotated[s] < rotated[m] && k >= rotated[e - 1] && k > rotated[s]) {
            search(rotated, k, m + 1, e);
        } else {
            search(rotated, k, s, m - 1);
        }
    } else if (k > rotated[m]) {
        if (rotated[e - 1] > rotated[m] && k < rotated[s]) {
            search(rotated, k, s, m - 1);
        } else {
            search(rotated, k, m + 1, e);
        }
    } else {
        while (m - 1 > 0 && rotated[m - 1] == k) {
            m--;
        }

        return m;
    }
}

