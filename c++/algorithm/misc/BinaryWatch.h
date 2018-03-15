//
// Created by haibo on 3/14/18.
//

#ifndef ALGORITHM_BINARYWATCH_H
#define ALGORITHM_BINARYWATCH_H

#include <string>
#include <vector>
#include <map>

using namespace std;

class BinaryWatch {
public:
    BinaryWatch();

    vector<string> get_n(int);
private:
    map<int, vector<string>> _cache;

    int bits(int, int);

    string time(int, int);
};


#endif //ALGORITHM_BINARYWATCH_H
