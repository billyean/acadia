package com.haibo.yan.algorithm.math;

import java.math.BigInteger;

public class SuperPalindrome {
    public int superpalindromesInRange(String L, String R) {
        BigInteger s = new BigInteger(L).sqrt();
        BigInteger e = new BigInteger(R).sqrt();
        int c = 0;
        for (BigInteger i = s; i.compareTo(e) < 0; i = i.add(BigInteger.ONE)) {
            if (isPalindrome(i) && isPalindrome(i.multiply(i))) {
                c++;
            }
        }
        return c;
    }

    private boolean isPalindrome(BigInteger v) {
        char[] csv = v.toString().toCharArray();
        int h = csv.length >>> 1;
        for (int i = 0; i < h; i++) {
            if(csv[i] != csv[csv.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new SuperPalindrome().superpalindromesInRange("1", "2"));
    }
}
