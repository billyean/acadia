package com.haibo.yan.algorithm.string;

import java.util.HashMap;

/**
 * Given two strings s and t, determine if they are isomorphic. Two strings are isomorphic if the characters in s can be
 * replaced to get t.
 *
 * For example,"egg" and "add" are isomorphic, "foo" and "bar" are not.
 */
public class Isomorphic {
    public boolean isIsomorphic(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;

        HashMap<Character, Character> c1Mapc2 = new HashMap<>();
        HashMap<Character, Character> c2Mapc1 = new HashMap<>();

        char[] cs1 = str1.toCharArray(), cs2 = str2.toCharArray();

        for (int i = 0; i < cs1.length; i++) {
            char c1 = cs1[i], c2 = cs2[i];

            if (c1Mapc2.containsKey(c1)) {
                if (c1Mapc2.get(c1) != c2) {
                    return false;
                }
            } else {
                c1Mapc2.put(c1, c2);
            }

            if (c2Mapc1.containsKey(c2)) {
                if (c2Mapc1.get(c2) != c1) {
                    return false;
                }
            } else {
                c2Mapc1.put(c2, c1);
            }
        }

        return true;
    }
}
