package com.haibo.yan.algorithm.array;

public class ReverseWords {
    /**
     * Given an input string , reverse the string word by word.
     *
     * Example:
     *
     * Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
     * Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
     * Note:
     *
     * A word is defined as a sequence of non-space characters.
     * The input string does not contain leading or trailing spaces.
     * The words are always separated by a single space.
     * @param s
     */
    public void reverseWordsII(char[] s) {
        int i = 0;
        while (i < s.length) {
            int len = 1;
            while(i + len < s.length && s[i + len] != ' ') len++;
            reverse(s, i, len);
            i += len + 1;
        }
        reverse(s, 0, s.length);
    }

    private void reverse(char[] s, int start, int len) {
        for (int i = 0; i < len / 2; i++) {
            char c = s[start + i];
            s[start + i] = s[start + len - 1 - i];
            s[start + len - 1 - i] = c;
        }
    }
}
