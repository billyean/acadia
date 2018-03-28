//
// Created by haibo on 3/28/18.
//

#include "BitUtilities.h"
#include <iostream>

using namespace std;

void BitUtilities::swap(int *v1, int *v2) {
    int v = (*v1) ^ (*v2);
    *v1 ^= v;
    *v2 ^= v;
}

bool BitUtilities::powerOfTwo(int n) {

    return (n & (n - 1)) == 0;
}

bool BitUtilities::powerOfFour(int n) {
    return n == 1 || (n & (n - 1)) == 0 && (n & 0xaaaaaaaa )== 0;
}
