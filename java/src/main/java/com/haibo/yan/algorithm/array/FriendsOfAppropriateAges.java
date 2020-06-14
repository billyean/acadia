package com.haibo.yan.algorithm.array;

/**
 * https://leetcode.com/problems/friends-of-appropriate-ages/
 */
public class FriendsOfAppropriateAges {
    public int numFriendRequests(int[] ages) {
        int requests = 0;
        int[] ageNumber = new int[120];
        for (int age : ages) {
            ageNumber[age - 1]++;
        }

        for (int i = 0; i < 120; i++) {
            for (int j = 0; j < 120; j++) {
                if (valid(i + 1, j + 1)) {
                    requests += ageNumber[i] * (ageNumber[j] - (i==j? 1:0));
                }
            }
        }
        return requests;
    }
    private boolean valid (int a, int b) {
        return !(b <= 0.5*a+7 || b > a || (b > 100 && a < 100));
    }
}
