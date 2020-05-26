package com.haibo.yan.algorithm.permutation;

import com.haibo.yan.algorithm.TestUtilities;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.haibo.yan.algorithm.TestUtilities.assertEquals;
import static com.haibo.yan.algorithm.TestUtilities.assertEqualsWithoutOrder;

public class TestCombinationSumII {
    @Test
    public void testRecursivePermutateNoDup() {
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        int target = 8;

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(1, 7));
        expected.add(Arrays.asList(1, 2, 5));
        expected.add(Arrays.asList(2, 6));
        expected.add(Arrays.asList(1, 1, 6));

        assertEqualsWithoutOrder(new CombinationSumII().combinationSum2(candidates, target),
                expected);
    }
}
