package com.haibo.yan.algorithm.dp;

import java.math.BigInteger;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/decode-ways-ii/submissions/
 */
public class NumDecoding {
    public int numDecodings(String s) {
        HashMap<String, Integer> cache = new HashMap<>();
        for (int i = 1; i < 10; i++) {
            cache.put(String.valueOf(i), 1);
        }
        cache.put("*", 9);
        if (s.length() < 2)    return cache.getOrDefault(s, 0);
        String s3 = "**";
        for (int i = 10; i <= 26; i++) {
            String v = String.valueOf(i);


            cache.put(String.valueOf(i), 1);
            if (i % 10 != 0) {
                int t = i / 10;
                String s1 = t + "*";
                cache.put(s1, cache.getOrDefault(s1, 0) + 1);
                cache.put(s3, cache.getOrDefault(s3, 0) + 1);
            }
            String s2 = "*" + (i % 10);
            cache.put(s2, cache.getOrDefault(s2, 0) + 1);
        }

        BigInteger n1 = BigInteger.ONE;
        BigInteger n2 = BigInteger.valueOf(cache.getOrDefault(s.substring(0, 1), 0));
        for (int i = 1; i < s.length(); i++) {
            int onev = cache.getOrDefault(s.substring(i, i + 1), 0);
            int twov = cache.getOrDefault(s.substring(i - 1, i + 1), 0);
            BigInteger nn2 = n2.multiply(BigInteger.valueOf(onev)).add(n1.multiply(BigInteger.valueOf(twov)));
            n1 = n2;
            n2 = nn2;
        }

        return n2.mod(BigInteger.valueOf(1000000007)).intValue();
    }

    public static void main(String[] args) {
        System.out.println(new NumDecoding().numDecodings("**********1111111111"));
    }
}
