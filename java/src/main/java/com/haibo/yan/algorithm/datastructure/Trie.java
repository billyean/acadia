package com.haibo.yan.algorithm.datastructure;

import java.util.Arrays;

public class Trie {
    public static final int ALPHABETIC_SIZE = 26;

    static class TrieNode {
        boolean leaf;

        final TrieNode[] children;

        TrieNode(int noOfNodes) {
            children = new TrieNode[noOfNodes];
        }

        TrieNode() {
            this(ALPHABETIC_SIZE);
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        char[] cs = word.toLowerCase().toCharArray();
        TrieNode current = root;

        for (char c : cs) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }

        current.leaf = true;
    }

    public boolean findWord(String word) {
        char[] cs = word.toLowerCase().toCharArray();
        TrieNode current = root;

        for (char c : cs) {
            int index = c - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }

        return current.leaf;
    }

    public boolean startWith(String word) {
        char[] cs = word.toLowerCase().toCharArray();
        TrieNode current = root;

        for (char c : cs) {
            int index = c - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }

        return true;
    }

    private String shortestPrefix(char[] cs, int begin) {
        TrieNode current = root;

        int len = 0;

        for (int i = begin; i < cs.length; i++) {
            int index = cs[i] - 'a';
            if (current.children[index] == null) {
                return null;
            } else if (current.children[index].leaf) {
                return new String(Arrays.copyOfRange(cs, begin, i + 1));
            }
        }

        return null;
    }
}
