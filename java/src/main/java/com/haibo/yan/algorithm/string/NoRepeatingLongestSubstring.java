package com.haibo.yan.algorithm.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * see https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a
 *       subsequence and not a substring.
 */
public class NoRepeatingLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();

        Queue<Character> queue = new LinkedList<>();

        int max = 0;

        char[] cs = s.toCharArray();

        for (int i = 0; i < cs.length; i++) {
            Character c = cs[i];
            while (set.contains(c)) {
                Character head = queue.poll();
                set.remove(head);
            }
            queue.offer(c);
            set.add(c);

            if (queue.size() > max) {
                max = queue.size();
            }
        }

        return max;
    }
}
