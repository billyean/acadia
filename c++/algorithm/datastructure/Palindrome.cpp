//Copyright [2018] [Haibo Yan]
//
//Licensed under the Apache License, Version 2.0 (the "License");
//you may not use this file except in compliance with the License.
//You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
//Unless required by applicable law or agreed to in writing, software
//distributed under the License is distributed on an "AS IS" BASIS,
//WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//See the License for the specific language governing permissions and
//limitations under the License.

//
// Created by haibo on 3/28/18.
//

#include "Palindrome.h"

string Palindrome::nearestPalindromic(string n) {
    return "";
}

bool Palindrome::palindromeNumber(int x) {
    if (x < 0) {
        return false;
    }

    int div = 1;

    while (x / div >= 10) {
        div *= 10;
    }

    while (x > 0) {
        int v = x / div;
        int d = x % 10;

        if (v != d) {
            return false;
        }
        x %= div;
        x /= 10;
        div /= 10;
    }

    return true;
}

bool Palindrome::valid(const string& str) {
    if (str.size() < 2) {
        return true;
    }
    int l = 0, r = str.size() - 1;

    while (l < r) {
        while (l < r && (str[l] < 'A' || str[l] > 'Z' && str[l] < 'a' || str[l] > 'z')) {
            l++;
        }
        while (l < r && (str[r] < 'A' || str[r] > 'Z' && str[r] < 'a' || str[r] > 'z')) {
            r--;
        }

        if (l == r) {
            break;
        }
        char cl = str[l];
        char cr = str[r];
        int ls = cl <= 'Z' ? cl - 'A' : cl - 'a';
        int rs = cr <= 'Z' ? cr - 'A' : cr - 'a';
        if (ls != rs) {
            return false;
        }
        l++;
        r--;
    }

    return true;
}