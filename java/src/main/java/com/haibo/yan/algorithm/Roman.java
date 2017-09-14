package com.haibo.yan.algorithm;

import java.util.HashMap;

public class Roman {
    private static final HashMap<Character, Integer> romanToInt = new HashMap<>();

    static {
        romanToInt.put('I', 1);
        romanToInt.put('V', 5);
        romanToInt.put('X', 10);
        romanToInt.put('L', 50);
        romanToInt.put('C', 100);
        romanToInt.put('D', 500);
        romanToInt.put('M', 1000);
    }

    private static final Object[][] ROMAN_VALUE_BOUNDRY = new Object[][]{
            {1000, 900, "M", "C"},
            {500, 400, "D", "C"},
            {100, 90, "C", "X"},
            {50, 40, "L", "X"},
            {10, 9, "X", "I"},
            {5, 4, "V", "I"},
            {1, 1, "I", "I"},

    };


    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        for (Object[] check : ROMAN_VALUE_BOUNDRY) {
            int v2 = Integer.valueOf(check[1].toString());
            while (num >= v2) {
                int v1 = Integer.valueOf(check[0].toString());
                String c1 = check[2].toString();
                String c2 = check[3].toString();

                if (num < v1) {
                    sb.append(c2);
                }
                sb.append(c1);
                num -= v1;
                if (num < 0) {
                    num += v1 - v2;
                }
            }
        }

        return sb.toString();
    }

    public static int romanToInt(String roman) {
        int decimalValue = 0;
        char[] cs = roman.toCharArray();

        for (int i = 0; i < cs.length; i++) {
            int c1 = romanToInt.get(cs[i]);

            if (i < cs.length - 1 && c1 < romanToInt.get(cs[i + 1])) {
                decimalValue -= c1;
            } else {
                decimalValue += c1;
            }
        }

        return decimalValue;
    }
}
