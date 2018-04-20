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
// Created by Haibo Yan on 4/20/18.
//

#include "Decode.h"

#include <stack>

// see https://leetcode.com/problems/decode-string
// Given an encoded string, return it's decoded string.
//The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly
// k times. Note that k is guaranteed to be a positive integer.
// You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
//
//Furthermore, you may assume that the original data does not contain any digits and that digits are only for those
// repeat numbers, k. For example, there won't be input like 3a or 2[4].
//
//Examples:
//s = "3[a]2[bc]", return "aaabcbc".
//s = "3[a2[c]]", return "accaccacc".
//s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
string Decode::decodeString(string s) {
    string decoded;

    stack<string> decStack;

    stack<int> levels;

    stack<int> nStack;
    string cs = "";

    int n = 0;

    int level = 0;
    for (int i = 0; i < s.size(); i++) {
        char c = s[i];


        if (c >= '0' && c <= '9') {
            while (c >= '0' && c <= '9') {
                n *= 10;
                n += c - '0';
                c = s[++i];
            }

            i--;
        } else if (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z'){
            cs += c;
        } else if (c == '[') {
            if (cs != "") {
                decStack.push(cs);
                levels.push(level);
                cs = "";
            }
            nStack.push(n);
            n = 0;
            cs = "";
            level++;
        } else if (c == ']') {
            n = nStack.top();
            nStack.pop();
            string ncs = "";

            level--;
            if (!decStack.empty() && levels.top() == level) {
                ncs = decStack.top() + ncs;
                decStack.pop();
                levels.pop();
            }
            for (int j = 0; j < n; j++) {
                ncs += cs;
            }
            cs = ncs;
            n = 0;
        }
    }

    return cs;
}
