package com.haibo.yan.algorithm;



public class Solution {

    public static void main(String[] args) {
        L1:
        do {
            L2:
            do {
                L3:
                do {
                    System.out.println("L2");
                    break L2;
                } while(3 > 4);
            } while(2 > 3);
            System.out.println("L1");
        } while(1 > 2);
    }
}
