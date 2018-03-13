//
// Created by Haibo Yan on 3/13/18.
//

#include "Zigzag.h"

string Zigzag::convert(string s, int numRows) {
    if (numRows < 2 || s.length() == 0)
        return s;

    string zs = "";

    for (int i = 0; i < numRows; i++) {
        int sp1 = 2 * (numRows - i  - 1);
        int sp2 = 2 * i;

        int zi = i;
        bool add = true;

        while (zi < s.size()) {
            zs += s[zi];

            if (sp1 == 0) {
                zi += sp2;
            } else if (sp2 == 0) {
                zi += sp1;
            } else if (add) {
                zi += sp1;
            } else {
                zi += sp2;
            }
            add = !add;
        }
    }

    return zs;
}