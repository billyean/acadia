package com.haibo.yan.algorithm.array;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/reveal-cards-in-increasing-order/
 */
public class RevealCardsInIncreasingOrder {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int n = deck.length;

        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            deque.add(i);
        }
        int[] r = new int[n];


        for (int d : deck) {
            r[deque.pollFirst()] = d;
            if (!deque.isEmpty()) {
                deque.addLast(deque.pollFirst());
            }
        }

        return r;
    }
}
