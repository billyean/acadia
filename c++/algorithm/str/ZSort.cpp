//
// Created by haibo on 3/16/18.
//

#include "ZSort.h"

#include <algorithm>

void ZSort::zsort(vector<string> &strings, int k) {
    stable_sort(strings.begin(), strings.end(), [k](string s1, string s2){
        if (s1.size() < k) {
            return false;
        }

        if (s2.size() < k) {
            return true;
        }

        return s1[k - 1] < s2[k - 1];
    });
}
