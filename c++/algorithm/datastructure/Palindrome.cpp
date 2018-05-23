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

#include <cctype>
#include <map>
#include <set>
#include <algorithm>
#include <numeric>
#include <iostream>


// 1990 -> 1991
// 399991 -> 400004

string Palindrome::nearestPalindromic(string n) {
    long v = atol(n.c_str());

    int m = (n.size() + 1) / 2;

    string pmv = "";

    for (int i = 0; i < m; i++) {
        pmv += n[i];
    }

    for (int i = m - 1; i >= 0; i--) {
        pmv += n[i];
    }

    long p1 = atol(pmv.c_str());
    int j = m - 1;

    while (j >= 0 && pmv[j] == '9') {
        j--;
    }


    for (int i = 0; i < j; i++) {

    }


    return pmv;
}


// (1000 - 3) * 997 = 9970 -  = 9000 -9 =
int Palindrome::largestPalindrome(int n) {
    return 1;
}

bool Palindrome::palindrome_number1(int x) {
    if (x < 0) {
        return false;
    }
    int div = 1;

    while (x / div >= 10) {
        div *= 10;
    }

    while (x != 0) {
        int d = x % 10;
        int h = x / div;

        if (d != h) {
            return false;
        }
        x %= div;
        x /= 10;
        div /= 100;
    }

    return true;
}

bool Palindrome::valid(const string& str) {
    if (str.size() < 2) {
        return true;
    }
    int l = 0, r = str.size() - 1;

    while (l < r) {
        while (l < r && (str[l] < 'A' || (str[l] > 'Z' && str[l] < 'a') || str[l] > 'z')) {
            l++;
        }
        while (l < r && (str[r] < 'A' || (str[r] > 'Z' && str[r] < 'a') || str[r] > 'z')) {
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

bool Palindrome::palindrome_number2(int n) {
    // Write your code here
    int i = n, r = 0;

    while (i != 0) {
        r <<= 1;
        r += i & 0x01;
        i >>= 1;
    }

    return r == n;
}

bool Palindrome::isPalindrome(string s) {
    int i = 0, j = s.size() - 1;

    while (i < j) {
        while (i < j && !isalpha(s[i]) ) {
            i++;
        }
        while (i < j && !isalpha(s[j]) ) {
            j--;
        }
        if (i < j) {
            char ci = s[i], cj = s[j];
            if (ci >= 'a') {
                ci = (char)('A' + (ci - 'a'));
            }
            if (cj >= 'a') {
                cj = (char)('A' + (cj - 'a'));
            }
            if (ci != cj) {
                return false;
            }
            i++;
            j--;
        }
    }

    return true;
}

// see https://leetcode.com/problems/longest-palindrome
// Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can
// be built with those letters.
//
//This is case sensitive, for example "Aa" is not considered a palindrome here.
//
//Note:
//Assume the length of given string will not exceed 1,010.
int Palindrome::longestPalindromeCanBuilt(string s) {
    int nums[52];

    for (int i = 0; i < 52; i++) {
        nums[i] = 0;
    }

    for (int i = 0; i < s.size(); i++) {
        char c = s[i];
        int p = c > 'Z' ? c - 'a' + 26 : c - 'A';
        nums[p]++;
    }

    bool odd = false;
    int len = 0;
    for (int i = 0; i < 52; i++) {
        if ((nums[i] & 0x01) == 0) {
            len += nums[i];
        } else {
            len += nums[i] - 1;
            odd = true;
        }
    }
    if (odd) {
        len++;
    }

    return len;
}

// Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation
// of the two words, i.e. words[i] + words[j] is a palindrome.
//
// Example 1:
// Given words = ["bat", "tab", "cat"]
// Return [[0, 1], [1, 0]]
// The palindromes are ["battab", "tabbat"]
// Example 2:
// Given words = ["abcd", "dcba", "lls", "s", "sssll"]
// Return [[0, 1], [1, 0], [3, 2], [2, 4]]
// The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
vector<vector<int>> Palindrome::palindromePairs(vector<string>& words) {
    set<int> lens;
    vector<string> reversed;

    for (auto i = 0; i < words.size(); i++) {
        string r = words[i];
        string w = words[i];
        reverse(r.begin(), r.end());

        reversed.push_back(r);
        lens.insert(w.size());
    }

    map<string, vector<int>> end_with, start_with;

    for (auto i = 0; i < reversed.size(); i++) {
        string r = reversed[i];
        for (auto ilen = lens.begin(); ilen != lens.end(); ilen++) {
            if (r.size() >= *ilen) {
                string p = r.substr(0, *ilen);
                if (end_with.find(p) == end_with.end()) {
                    end_with[p] = {i};
                } else {
                    end_with[p].push_back(i);
                }
            }
        }
    }

    for (auto i = 0; i < words.size(); i++) {
        string w = words[i];
        for (auto ilen = lens.begin(); ilen != lens.end(); ilen++) {
            if (w.size() >= *ilen) {
                string p = w.substr(0, *ilen);
                reverse(p.begin(), p.end());
                if (start_with.find(p) == start_with.end()) {
                    start_with[p] = {i};
                } else {
                    start_with[p].push_back(i);
                }
            }
        }
    }

    vector<vector<int>> pairs;
    for (auto i = 0; i < words.size(); i++) {
        string wi = words[i];
        if (end_with.find(wi) != end_with.end()) {
            vector<int> ev = end_with[wi];
            for (auto iev = ev.begin(); iev != ev.end(); iev++) {
                auto j = *iev;
                string wj = words[j];
                if (i != j && palindrome(wj, 0, wj.size() - wi.size())) {
                    pairs.push_back({i, j});
                }
            }
        }

        if (start_with.find(wi) != start_with.end()) {
            vector<int> ev = start_with[wi];
            for (auto iev = ev.begin(); iev != ev.end(); iev++) {
                auto j = *iev;
                string wj = words[j];
                if (i != j && wi.size() != words[j].size() && palindrome(wj, wi.size(), wj.size() - wi.size())) {
                    pairs.push_back({j, i});
                }
            }
        }
    }

    sort(pairs.begin(), pairs.end(), [](vector<int> p1, vector<int> p2) -> bool {
       int s1 = accumulate(p1.begin(), p1.end(), 0);
       int s2 = accumulate(p2.begin(), p2.end(), 0);


       if (s1 != s2) {
           return s1 < s2;
       } else {
           return p1[0] < p2[0];
       }

    });

    return pairs;
}

bool Palindrome::palindrome(string str, int s, int l) {
    if (s > str.size()) {
        return false;
    }

    int h = l >> 1;
    for (int i = 0; i < h; i++) {
        if (str[s + i] != str[s + l -1 - i]) {
            return false;
        }
    }

    return true;
}

bool Palindrome::isPalindrome(LinkedListNode<int>* head) {
    left_ = head;
    return isPalindromeHelper(head);
}

bool Palindrome::isPalindromeHelper(LinkedListNode<int>* right) {
    if (right == NULL) {
        return true;
    }

    bool rp = isPalindromeHelper(right->next_);
    if (!rp) {
        return false;
    }

    bool r = left_->t_ == right->t_;
    left_ = left_->next_;

    return r;
}

string Palindrome::shortestPalindrome(string s) {
    int n = s.size();
    string rev(s);
    reverse(rev.begin(), rev.end());

    string ds = s + "#" + rev;
    vector<int> indices(ds.size(), 0);

    int m = 0;
    for (int i = 1; i < ds.size(); i++) {
        while (m > 0 && ds[i] != ds[m]) {
            m = indices[m];
        }
        if (ds[i] == ds[m]) {
            m++;
        }
        indices[i] = m;
    }

    return rev.substr(0, n - indices[ds.size() - 1]) + s;
}

vector<int> Palindrome::kmp_index(string s) {
    vector<int> indices;

    indices.push_back(0);

    int m = 0;

    for (int i = 0; i < s.size(); i++) {
        while (m > 0 && s[i] != s[m]) {
            m = indices[m];
        }
        if (s[i] == s[m]) {
            m++;
        }
        indices.push_back(m);
    }

    return indices;
}

/**
 * "aabaaa"
 * "a#a#b#a#a#a"
 * [0 0 4 4]
 * [4 0 1 4]
 * [4 4 0 4]
 * [4 4 4 0]
 * @param s
 * @return
 */
int Palindrome::minCut(string s) {
    // Version 1, not optimized
//    vector<vector<int>> cuts;
//
//    for (int i = 0; i < s.size(); i++) {
//        vector<int> r(s.size(), s.size());
//        r[i] = 0;
//        cuts.push_back(r);
//    }
//
//    string ds = "";
//    ds += s[0];
//    for (int i = 1; i < s.size(); i++) {
//        ds += '#';
//        ds += s[i];
//    }
//
//    vector<int> lens = palindromeLens(ds);
//
//    for (int i = 1; i < s.size(); i++) {
//        for (int j = 0; j < s.size() - i; j++) {
//            if (palindrome(s, j, i + 1)) {
//                cuts[j][i + j] = 0;
//            } else {
//                for (int k = 0; k < i; k++) {
//                    cuts[j][i + j] = min(cuts[j][i + j], cuts[j][j + k] +  cuts[j + k + 1][i + j] + 1);
//                }
//            }
//        }
//    }
//
//    return cuts[0][s.size() - 1];

    //Version 2
    int n = s.size();
    vector<int> cuts(n, 0);
    bool isPa[n][n];

    for (int i = 0; i < n; i++) {
        cuts[i] = i;
        for (int j = 0; j <= i; j++) {
            if (s[i] == s[j] && (i - j <= 1 || isPa[j + 1][i - 1])) {
                isPa[j][i] = true;
                if (j > 0) {
                    cuts[i] = min(cuts[i], cuts[j - 1] + 1);
                } else {
                    cuts[i] = 0;
                }
            }
        }
    }

    return cuts[n - 1];
}

string Palindrome::rearrange(string s) {
    unsigned long l = s.size();
    unsigned long h = l / 2;
    int csi[256];

    for (unsigned long i = 0; i < l; i++) {
        int c = s[i] - '0';
        csi[c]++;
        if (csi[c] > h) {
            return "";
        }
    }

    int c = 0;
    int i = 0, j = 255;
    string fh, sh;
    while (c < i) {
        while (i < j && csi[i] == 0) {
            i++;
        }
        if (i < j) {
            fh += (char)i;
            csi[i]--;
        }
        while (i < j && csi[j] == 0) {
            j--;
        }
        if (i < j) {
            sh += (char)j;
            csi[j]--;
        }
    }

    return fh + sh;
}

int Palindrome::longestPalindrome(string s) {
    string ds = "";

    ds += s[0];

    for (int i = 1; i < s.size(); i++) {
        ds += '#';
        ds += s[i];
    }

    vector<int> lens = palindromeLens(ds);
    auto m = max_element(lens.begin(), lens.end());
    return (*m) >> 1;
}

vector<int> Palindrome::palindromeLens(string s) {
    vector<int> lens(s.size(), 0);

    for (int i = 0; i < s.size();) {
        lens[i] = palindomeLen(s, i);
        int b = lens[i] >> 1;

        int il = i - b;
        for (int j = 1; j <= b; j++) {

            int jl = i - j - (lens[i - j] >> 1);
            if (il < jl) {
                lens[i + j] = lens[i - j];
            } else {
                lens[i + j] = 1 + 2 * (b - j);
            }
        }
        i += b + 1;
    }

    return lens;
}

int Palindrome::palindomeLen(string s, int p) {
    int i = p, j = p;

    while (i >= 0 && j < s.size() && s[i] == s[j]) {
        i--;
        j++;
    }

    return j - i - 1;
}
