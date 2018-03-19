//
// Created by haibo on 3/17/18.
//

#include "KMP.h"

int* KMP::pattern(string pattern) {
    int *index = new int[pattern.size()];

    index[0] = 0;

    int i = 0;

    for (int j = 1; j < pattern.size(); j++) {
        while (i > 0 && pattern[j] != pattern[i]) {
            j = index[i];
        }
        if (pattern[i] == pattern[j]) {
            i++;
        }
        index[j] = i;
    }

    return index;
}

int KMP::substr(string s, string p) {
    int *pindex = pattern(p);

    int i = 0, j = 0;

    while (i < s.length() && j < p.length()) {
        if (s[i] == p[j]) {
            i++;
            j++;
        } else if (j > 0) {
            j = pindex[j - 1];
        } else {
            i++;
        }
    }

    if (j < p.length()) {
        return -1;
    } else {
        return i - j;
    }
}

