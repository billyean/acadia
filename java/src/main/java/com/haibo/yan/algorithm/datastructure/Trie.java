package com.haibo.yan.algorithm.datastructure;

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
}
