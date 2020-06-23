package com.haibo.yan.algorithm.array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/design-twitter/
 */
public class Twitter {
    Map<Integer, Set<Integer>> userFollowing = new HashMap<>();

    Map<Integer, LinkedList<int[]>> userTweets = new HashMap<>();

    int c = 0;

    /** Initialize your data structure here. */
    public Twitter() {
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        LinkedList<int[]> tweets = userTweets.getOrDefault(userId, new LinkedList<>());
        tweets.addFirst(new int[]{tweetId, c++});
        userTweets.put(userId, tweets);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<int[]> tens = new ArrayList<>();
        int x = 0;
        for (int[] y : userTweets.getOrDefault(userId, new LinkedList<>())) {
            if (x < 10) {
                tens.add(y);
            }
        }
        for (int followee : userFollowing.getOrDefault(userId, new HashSet<>())) {
            x = 0;
            for (int[] y : userTweets.getOrDefault(followee, new LinkedList<>())) {
                if (x < 10) {
                    tens.add(y);
                }
            }
        }
        Collections.sort(tens, Comparator.comparing((int[] v) -> -v[1]));
        int n = Integer.min(tens.size(), 10);
        return tens.subList(0, n).stream().map((int[] v) -> v[0]).collect(Collectors.toList());
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId)   return;
        Set<Integer> following = userFollowing.getOrDefault(followerId, new HashSet<>());
        following.add(followeeId);
        userFollowing.put(followerId, following);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> following = userFollowing.getOrDefault(followerId, new HashSet<>());
        if (following.remove(followeeId)) {
            userFollowing.put(followerId, following);
        }
    }
}
