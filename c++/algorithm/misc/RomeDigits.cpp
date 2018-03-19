//
// Created by haibo on 3/16/18.
//

#include "RomeDigits.h"

RomeDigits::RomeDigits() {
    _rtoi = {{'I', 1}, {'V', 5}, {'X', 10}, {'L', 50}, {'C', 100}, {'D', 500}, {'M', 1000}};
    _boundary = {
            {1000, 900, "M", "C"},
            {500,  400, "D", "C"},
            {100,   90, "C", "X"},
            { 50,   40, "L", "X"},
            { 10,    9, "X", "I"},
            {  5,    4, "V", "I"},
            {  1,    1, "I", "I"}
    };
}

string RomeDigits::int_to_rome(int num) {
    string rome = "";

    for (auto b = _boundary.begin(); b != _boundary.end(); b++) {
        auto t = (*b);
        while (num >= get<1>(t)) {
            if (num < get<0>(t)) {
                rome += get<3>(t);
            }
            rome += get<2>(t);
            num -= get<0>(t);
            if (num < 0) {
                num += get<0>(t) - get<1>(t);
            }
        }
    }

    return rome;
}

int RomeDigits::rome_to_int(string rome) {
    int r = 0;
    for (int i = 0; i < rome.length(); i++) {
        char c = rome[i];
        int c1 = _rtoi[c];

        if (i < rome.length() - 1 && c1 < _rtoi[rome[i + 1]]) {
            r -= c1;
        } else {
            r += c1;
        }
    }

    return r;
}
