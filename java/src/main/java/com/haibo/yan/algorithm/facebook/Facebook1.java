package com.haibo.yan.algorithm.facebook;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static java.util.stream.Collectors.joining;

import java.util.ArrayList;

public class Facebook1 {
    public Set<List<Integer>> subSet(int[] array) {
        Set<List<Integer>> sub = new HashSet<>();
        
        HashMap<Integer, Integer> vNums = new HashMap<>();
        for (int i : array) {
            int num = vNums.getOrDefault(i, 0);
            vNums.put(i, num + 1);
        }

        sub.add(new ArrayList<>());
        
        while (!vNums.isEmpty()) {
            Set<List<Integer>> temp = new HashSet<>();
            for (List<Integer> list : sub) {
                List<Integer> newList = new ArrayList<>();
                newList.addAll(list);
                temp.add(newList);
            }
            int nextV = vNums.keySet().iterator().next();
            for (List<Integer> set : temp) {
                set.add(nextV);
            }
            sub.addAll(temp);
            vNums.put(nextV, vNums.get(nextV) - 1);
            vNums.remove(nextV, 0);
        }
        
        return sub;
    }

    public static void main(String[] args) {
        Set<List<Integer>> subSet = new Facebook1().subSet(new int[]{3, 3, 6, 9});
        
        System.out.println(subSet.stream().map(s -> s.stream().map(String::valueOf).collect(joining(",", "[", "]"))).collect(joining("\n", "[", "]")));

    }

}

