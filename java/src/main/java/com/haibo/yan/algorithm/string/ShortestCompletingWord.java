package com.haibo.yan.algorithm.string;

/**
 * https://leetcode.com/problems/shortest-completing-word/submissions/
 */
public class ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] plateChars = new int[26];

        int[][] wordSChars = new int[words.length][26];

        for (char c : licensePlate.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z')
                plateChars[c - 'a']++;
        }

        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                wordSChars[i][c - 'a']++;
            }
        }

        String candidate = null;

        for (int i = 0; i < wordSChars.length; i++) {
            int[] wi = wordSChars[i];
            boolean isCompleted = true;
            for (int j = 0; j < 26; j++) {
                if (wi[j] < plateChars[j]) {
                    isCompleted = false;
                    break;
                }
            }

            if (isCompleted && (candidate == null || words[i].length() < candidate.length())) {
                candidate =  words[i];
            }

        }

        return candidate;
    }
}
