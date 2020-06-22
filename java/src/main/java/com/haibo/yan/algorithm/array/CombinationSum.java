package com.haibo.yan.algorithm.array;

import java.util.*;

public class CombinationSum {
    /**
     * https://leetcode.com/problems/combination-sum/
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return innerCom(candidates, 0, target);
    }

    private List<List<Integer>> innerCom(int[] candidates, int start, int target) {
        List<List<Integer>> l = new ArrayList<>();
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] < target) {
                List<List<Integer>> next = innerCom(candidates, target - candidates[i] >= candidates[i] ? i : i + 1, target - candidates[i]);
                for (List<Integer> nl : next) {
                    nl.add(0, candidates[i]);
                    l.add(nl);
                }
            } else if (candidates[i] == target) {
                List<Integer> nl = new ArrayList<>();
                nl.add(candidates[i]);
                l.add(nl);
            } else {
                break;
            }
        }
        return l;
    }

    /**
     * https://leetcode.com/problems/combination-sum-ii/
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        Set<List<Integer>> result = new HashSet<>();
        List<Integer> path = new ArrayList<>();

        back2(candidates, 0, target, result, path);
        return new ArrayList(result);
    }

    private void back2(int[] candidates, int p, int target, Set<List<Integer>> result, List<Integer> path) {
        if (p == candidates.length) {
            return;
        }

        if (candidates[p] > 0 && target < candidates[p]) {
            return;
        }
        if (candidates[p] == target) {
            List<Integer> c = new ArrayList<Integer>();
            List<Integer> l = new ArrayList<>();
            for (int x : path) {
                l.add(candidates[x]);
            }
            l.add(candidates[p]);
            result.add(l);
        }

        path.add(p);
        back2(candidates, p + 1, target - candidates[p], result, path);
        path.remove(path.size() - 1);
        back2(candidates, p + 1, target, result, path);
    }


    /**
     * https://leetcode.com/problems/combination-sum-iii/
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> r = new ArrayList<>();

        rec(new ArrayList<>(), 0, k, n, r);

        return r;
    }

    private void rec(List<Integer> p, int sum, int k, int n, List<List<Integer>> r) {
        int x = p.size() == 0 ? 1 : p.get(p.size() - 1) + 1;
        if (x > 9) {
            return;
        }
        for (int i = x; i <= 9; i++) {
            p.add(i);
            sum += i;
            if (p.size() == k) {
                if (sum == n) {
                    r.add(new ArrayList<>(p));
                }
            } else {
                rec(p, sum, k, n, r);
            }
            p.remove(p.size() - 1);
            sum -= i;
        }
    }
}
