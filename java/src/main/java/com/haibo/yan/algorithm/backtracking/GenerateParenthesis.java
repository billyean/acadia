/*
 * Copyright (c) [2017] [Haibo(Tristan) Yan]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.haibo.yan.algorithm.backtracking;

import java.util.*;

/**
 * https://leetcode.com/problems/generate-parentheses
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 ]
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return Collections.emptyList();
        }
        Stack<Character> stack = new Stack<>();
        stack.push('(');
        return generateParenthesis(stack, n, 1);
    }

    /**
     *
     * @param stack
     * @param n
     * @param p
     * @return
     */
    private List<String> generateParenthesis(Stack<Character> stack, int n, int p) {
        List<String> parenthesis = new ArrayList<>();


        if (p == n) {
            StringBuilder sb = new StringBuilder();
            Iterator<Character> i = stack.iterator();
            while (i.hasNext()) {
                sb.append(i.next());
            }

            for (int j = stack.size(); j < n * 2; j++) {
                sb.append(')');
            }
            parenthesis.add(sb.toString());
            return parenthesis;
        }

        stack.push('(');
        parenthesis.addAll(generateParenthesis(stack, n, p + 1));
        stack.pop();

        if (stack.size() < 2 * p) {
            stack.push(')');
            parenthesis.addAll(generateParenthesis(stack, n, p ));
            stack.pop();
        }

        return parenthesis;
    }

}
