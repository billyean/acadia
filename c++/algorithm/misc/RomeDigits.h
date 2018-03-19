//
// Created by haibo on 3/16/18.
//

#ifndef ALGORITHM_ROMEDIGITS_H
#define ALGORITHM_ROMEDIGITS_H

#include <vector>
#include <map>
#include <string>
#include <tuple>

using namespace std;

class RomeDigits {
public:
    RomeDigits();
    string int_to_rome(int);
    int rome_to_int(string);
private:
    map<char, int> _rtoi;
    vector<tuple<int, int, string, string>> _boundary;
};


#endif //ALGORITHM_ROMEDIGITS_H
