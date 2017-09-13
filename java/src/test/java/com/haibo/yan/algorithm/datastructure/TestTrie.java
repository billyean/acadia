package com.haibo.yan.algorithm.datastructure;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class TestTrie {
    @Test
    public void testTrie() {
        Trie trie = new Trie();

        trie.addWord("hello");
        trie.addWord("world");
        trie.addWord("hi");
        trie.addWord("high");
        trie.addWord("low");

        assertTrue(trie.findWord("hi"));
        assertTrue(trie.findWord("hello"));
        assertTrue(trie.findWord("world"));
        assertTrue(trie.findWord("high"));
        assertTrue(trie.findWord("low"));

        assertFalse(trie.findWord("h"));
        assertFalse(trie.findWord("c"));
        assertFalse(trie.findWord("ha"));
        assertFalse(trie.findWord("ca"));
        assertFalse(trie.findWord("lo"));
        assertFalse(trie.findWord("lowe"));
        assertFalse(trie.findWord("highend"));

        assertTrue(trie.startWith("hi"));
        assertTrue(trie.startWith("hello"));
        assertTrue(trie.startWith("world"));
        assertTrue(trie.startWith("high"));
        assertTrue(trie.startWith("low"));

        assertTrue(trie.startWith("h"));
        assertFalse(trie.startWith("c"));
        assertFalse(trie.startWith("ha"));
        assertFalse(trie.startWith("ca"));
        assertTrue(trie.startWith("lo"));
        assertFalse(trie.startWith("lowe"));
        assertFalse(trie.startWith("highend"));
    }
}
