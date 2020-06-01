package com.haibo.yan.algorithm.bfs;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/open-the-lock/
 */
public class OpenLock {
    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = Arrays.stream(deadends).collect(Collectors.toSet());
        if (deadSet.contains(target) || deadSet.contains("0000")) {
            return -1;
        }
        HashSet<String> visisted = new HashSet<>(deadSet);
        Queue<String> queue = new LinkedList<>();

        queue.add("0000");
        int level = 0;
        while(queue.size() != 0) {
            int len = queue.size();
            for (int j = 0; j < len; j++) {
                String nextString = queue.poll();
                char[] sc = nextString.toCharArray();
                for (int i = 0; i < 4; i++) {
                    if (sc[i] == '9') {
                        sc[i] = '0';
                    } else {
                        sc[i]++;
                    }
                    String ns = String.valueOf(sc);
                    if (!visisted.contains(ns)) {
                        visisted.add(ns);
                        queue.add(ns);
                        if (ns.equals(target)) {
                            return level + 1;
                        }

                    }
                    if (sc[i] == '0') {
                        sc[i] = '9';
                    } else {
                        sc[i]--;
                    }


                    if (sc[i] == '0') {
                        sc[i] = '9';
                    } else {
                        sc[i]--;
                    }
                    ns = String.valueOf(sc);
                    if (!visisted.contains(ns)) {
                        visisted.add(ns);
                        queue.add(ns);
                        if (ns.equals(target)) {
                            return level + 1;
                        }

                    }
                    if (sc[i] == '9') {
                        sc[i] = '0';
                    } else {
                        sc[i]++;
                    }
                }
            }
            level++;
        }

        return -1;

    }
}
