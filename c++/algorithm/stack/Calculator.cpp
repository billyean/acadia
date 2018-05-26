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
// Created by Haibo Yan on 5/25/18.
//

#include "Calculator.h"
#include <stack>

int Calculator::calculate(string expr) {
    stack<int> opdl;

    stack<char> opr;

    bool level = true;

    for (int i = 0; i < expr.size(); i++) {
        char c = expr[i];
        if (c != ' ') {
            if (c == '+' || c == '-') {
                level = false;
                opr.push(c);
            } else if (c >= '0' && c <= '9') {
                int cv = c - '0';

                while (++i < expr.size() && expr[i] >= '0' && expr[i] <= '9') {
                    c = expr[i];
                    cv = cv * 10 + (c - '0');
                }
                if (!level) {
                    int t = opdl.top();
                    opdl.pop();
                    if (opr.top() == '+') {
                        t += cv;
                    } else {
                        t -= cv;
                    }
                    opr.pop();
                    cv = t;
                }
                opdl.push(cv);
                i--;
            } else if (c == '(') {
                level = true;
            } else if (c == ')') {
                if (opr.size() > 0) {
                    int t = opdl.top();
                    opdl.pop();
                    int cv = opdl.top();
                    opdl.pop();
                    if (opr.top() == '+') {
                        cv += t;
                    } else {
                        cv -= t;
                    }
                    opr.pop();
                    opdl.push(cv);
                }
            }
        }
    }

    return opdl.top();
}