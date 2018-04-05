//
// Created by Haibo Yan on 4/5/18.
//

#ifndef ALGORITHM_EDITDISTANCE_H
#define ALGORITHM_EDITDISTANCE_H

#include <string>

using namespace std;

class EditDistance {
public:
    static int minD(string, string);

    static bool oneEditDistance(string, string);
private:
    static bool equals(string, string, int, int, int);
};


#endif //ALGORITHM_EDITDISTANCE_H
