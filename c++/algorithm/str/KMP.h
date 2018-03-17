//
// Created by haibo on 3/17/18.
//

#ifndef ALGORITHM_KMP_H
#define ALGORITHM_KMP_H

#include <string>

using namespace std;

class KMP {
public:
    static int substr(string, string);
private:
    static int *pattern(string);
};


#endif //ALGORITHM_KMP_H
