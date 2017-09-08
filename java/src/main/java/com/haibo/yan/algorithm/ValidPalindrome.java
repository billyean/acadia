package com.haibo.yan.algorithm;


public class ValidPalindrome {
    public boolean isValid(String string) {
        char[] chars = string.toLowerCase().toCharArray();
        return isValid(chars, 0, chars.length - 1);
    }

    public boolean isValid(char[] chars, int start, int end) {
        if (start >= end ) {
            return true;
        }

        if (!Character.isLetterOrDigit(chars[start])) {
            return isValid(chars, start + 1, end);
        } else if (!Character.isLetterOrDigit(chars[end])) {
            return isValid(chars, start, end - 1);
        } else if (chars[start] == chars[end]) {
            return isValid(chars, start + 1, end - 1);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        ValidPalindrome instance = new ValidPalindrome();
        System.out.println(instance.isValid(""));
        System.out.println(instance.isValid("Red rum, sir, is murder"));
        System.out.println(instance.isValid("Programcreek is awesome"));
    }
}