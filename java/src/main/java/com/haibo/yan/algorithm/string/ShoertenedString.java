/*
 *
 *  * Copyright [2017] [Haibo(Tristan) Yan]
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *     http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.haibo.yan.algorithm.string;

import java.util.Stack;

public class ShoertenedString {
    String shortenedString(String ss) {
        char[] ts = ss.toCharArray();

        char[] csWithoutSpaces = new char[ts.length];
        int len = 0;

        for(char c: ts) {
            csWithoutSpaces[len++] = c;
        }
        String noSpaces = new String(csWithoutSpaces, 0, len);

        StringBuilder s = new StringBuilder();
        Stack<Integer> l = new Stack<>();

        char[] cs = noSpaces.toCharArray();
        boolean paren = false;

        int i = 0;
        while (i < cs.length) {
            char c = cs[i];
            if (c >= 'A' && c <= 'Z') {
                s.append(c);
            } else if (c == '(') {
                l.push(s.length());
            } else if (c == ')') {
                l.push(s.length());
                paren = true;
            } else if (c <= '9' && c >= '0') {
                int v = 0;
                for (; i < cs.length && (cs[i] <= '9' && cs[i] >= '0'); i++) {
                    if (cs[i] != ' ') {
                        v *= 10;
                        v += (int) (c - '0');
                    }
                    if (v == 0) {
                        int de = paren ? l.pop() : s.length();
                        int ds = paren ? l.pop() : s.length() - 1;
                        s.delete(ds, de);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        if (paren) {
                            int end = l.pop(), start = l.pop();
                            sb.append(s.substring(start, end));
                        } else {
                            sb.append(s.substring(s.length() - 1));
                        }

                        for (int j = 0; j < v - 1; j++) {
                            s.append(sb);
                        }
                    }
                }
                paren = false;
                i--;
            }
            i++;
        }

        return s.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ShoertenedString().shortenedString("((ABC 2)1( )0F )1"));
    }
}
