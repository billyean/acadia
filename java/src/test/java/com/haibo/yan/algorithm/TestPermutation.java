package com.haibo.yan.algorithm;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class TestPermutation {
//    @Test
//    public void testRecursivePermutateNoDup() {
//        Integer[] array = new Integer[]{1, 2, 3};
//
//        List<List<Integer>> result = Permutation.recursivePermutateNoDup(array);
//
//
//        TestUtilities.assertEquals(result,
//                Arrays.asList(Arrays.asList(1, 2, 3),
//                        Arrays.asList(1, 3, 2),
//                        Arrays.asList(2, 1, 3),
//                        Arrays.asList(2, 3, 1),
//                        Arrays.asList(3, 2, 1),
//                        Arrays.asList(3, 1, 2)));
//    }
//
//    @Test
//    public void testInsertPermutateNoDup() {
//        Integer[] array = new Integer[]{1, 2, 3};
//
//        List<List<Integer>> result = Permutation.insertPermutateNoDup(array);
//
//        TestUtilities.assertEquals(result,
//                Arrays.asList(Arrays.asList(3, 2, 1),
//                        Arrays.asList(2, 3, 1),
//                        Arrays.asList(2, 1, 3),
//                        Arrays.asList(3, 1, 2),
//                        Arrays.asList(1, 3, 2),
//                        Arrays.asList(1, 2, 3)));
//    }


    @Test
    public void testPermutateDup() {
        TestUtilities.assertEquals(Permutation.permuteDup(new Integer[]{1, 2, 3, 4}),
                Arrays.asList(Arrays.asList(1, 2, 3, 4),
                        Arrays.asList(1, 2, 4, 3),
                        Arrays.asList(1, 3, 2, 4),
                        Arrays.asList(1, 3, 4, 2),
                        Arrays.asList(1, 4, 2, 3),
                        Arrays.asList(1, 4, 3, 2),
                        Arrays.asList(2, 1, 3, 4),
                        Arrays.asList(2, 1, 4, 3),
                        Arrays.asList(2, 3, 1, 4),
                        Arrays.asList(2, 3, 4, 1),
                        Arrays.asList(2, 4, 1, 3),
                        Arrays.asList(2, 4, 3, 1),
                        Arrays.asList(3, 1, 2, 4),
                        Arrays.asList(3, 1, 4, 2),
                        Arrays.asList(3, 2, 1, 4),
                        Arrays.asList(3, 2, 4, 1),
                        Arrays.asList(3, 4, 1, 2),
                        Arrays.asList(3, 4, 2, 1),
                        Arrays.asList(4, 1, 2, 3),
                        Arrays.asList(4, 1, 3, 2),
                        Arrays.asList(4, 2, 1, 3),
                        Arrays.asList(4, 2, 3, 1),
                        Arrays.asList(4, 3, 1, 2),
                        Arrays.asList(4, 3, 2, 1)));

        TestUtilities.assertEquals(Permutation.permuteDup(new Integer[]{1, 2, 2, 3}),
                Arrays.asList(Arrays.asList(1, 2, 2, 3),
                        Arrays.asList(1, 2, 3, 2),
                        Arrays.asList(1, 3, 2, 2),
                        Arrays.asList(2, 1, 2, 3),
                        Arrays.asList(2, 1, 3, 2),
                        Arrays.asList(2, 2, 1, 3),
                        Arrays.asList(2, 2, 3, 1),
                        Arrays.asList(2, 3, 1, 2),
                        Arrays.asList(2, 3, 2, 1),
                        Arrays.asList(3, 1, 2, 2),
                        Arrays.asList(3, 2, 1, 2),
                        Arrays.asList(3, 2, 2, 1)));
    }
}
