//
// Created by haibo on 3/28/18.
//

#include "SingleNumber.h"

int SingleNumber::findInTwos() {
    int s = 0;

    for (auto i = nums_.begin(); i != nums_.end(); i++) {
        s ^= (*i);
    }

    return s;
}

int SingleNumber::findInThrees() {
    int one = 0;
    int two = 0;
    int three = 0;

    for (auto i = nums_.begin(); i != nums_.end(); i++) {
        two |= one & (*i);
        one ^= (*i);
        three = one & two;
        one &= ~three;
        two &= ~three;

    }

    return one;
}

int SingleNumber::findInFours() {
    int one = 0;
    int two = 0;
    int three = 0;
    int four = 0;

    for (auto i = nums_.begin(); i != nums_.end(); i++) {
        two |= one & (*i);
        one ^= (*i);
        three = one & two;
        four = three & ~(one);
        one &= ~four;
        two &= ~four;
        three &= ~four;
    }

    return one;
}