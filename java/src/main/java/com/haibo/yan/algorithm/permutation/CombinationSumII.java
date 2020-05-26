package com.haibo.yan.algorithm.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        int i = 0;
        while (i < candidates.length) {
            result.addAll(combinationTotarget(candidates, i, target));
            int j = i + 1;
            while (j < candidates.length && candidates[j] == candidates[i]) {
                j++;
            }
            i = j;
        }
        return result;
    }

    private List<List<Integer>> combinationTotarget(int[] candidates, int index, int target) {
        if(index >= candidates.length) return new ArrayList<>();
        List<List<Integer>> pr = combinationTotarget(candidates, index + 1, target - candidates[index]);
        if (pr.size() > 0) {
            for (List<Integer> p: pr) {
                p.add(candidates[index]);
            }
        }
        if (target == candidates[index]) {
            List<Integer> s = new ArrayList() {{
                add(target);
            }};
            pr.add(s);
        }
        return pr;
    }
}
