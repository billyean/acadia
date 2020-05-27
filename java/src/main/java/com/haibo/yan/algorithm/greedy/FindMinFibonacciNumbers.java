package com.haibo.yan.algorithm.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/submissions/
 */
public class FindMinFibonacciNumbers {
    public int findMinFibonacciNumbers(int k) {
        if (k < 4) return 1;
        int n = 0;
        List<Integer> numbers = fibonaccis(k);
        while(k > 0) {
            for (int i = numbers.size() - 1; i >= 0; i--) {
                int v = numbers.get(i);
                if (v <= k) {
                    k -= v;
                    n++;
                    break;
                }
            }
        }
        return n;
    }

    private List<Integer> fibonaccis(int k) {
        List<Integer> numbers = new ArrayList<>();
        int a = 1, b = 2;
        numbers.add(1);
        numbers.add(2);
        int s = a + b;
        while(s <= k) {
            numbers.add(s);
            a = b;
            b = s;
            s = a + b;
        }
        return numbers;
    }

    public static void main(String[] args) {
        System.out.println(new FindMinFibonacciNumbers().findMinFibonacciNumbers(267));
    }
}
