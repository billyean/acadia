/*
 * Copyright (c) [2017] [Haibo(Tristan) Yan]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.haibo.yan.algorithm.permutation;

import com.haibo.yan.algorithm.TestUtilities;
import com.haibo.yan.algorithm.permutation.Permutation;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class TestPermutation {
    @Test
    public void testRecursivePermutateNoDup() {
        Integer[] array = new Integer[]{1, 2, 3};

        List<List<Integer>> result = Permutation.recursivePermutateNoDup(array);


        TestUtilities.assertEquals(result,
                Arrays.asList(Arrays.asList(1, 2, 3),
                        Arrays.asList(1, 3, 2),
                        Arrays.asList(2, 1, 3),
                        Arrays.asList(2, 3, 1),
                        Arrays.asList(3, 2, 1),
                        Arrays.asList(3, 1, 2)));
    }

    @Test
    public void testInsertPermutateNoDup() {
        Integer[] array = new Integer[]{1, 2, 3};

        List<List<Integer>> result = Permutation.insertPermutateNoDup(array);

        TestUtilities.assertEquals(result,
                Arrays.asList(Arrays.asList(3, 2, 1),
                        Arrays.asList(2, 3, 1),
                        Arrays.asList(2, 1, 3),
                        Arrays.asList(3, 1, 2),
                        Arrays.asList(1, 3, 2),
                        Arrays.asList(1, 2, 3)));
    }


//    @Test
//    public void testPermutateDup() {
//        TestUtilities.assertEquals(Permutation.permuteDup(new Integer[]{1, 2, 3, 4}),
//                Arrays.asList(Arrays.asList(1, 2, 3, 4),
//                        Arrays.asList(1, 2, 4, 3),
//                        Arrays.asList(1, 3, 2, 4),
//                        Arrays.asList(1, 3, 4, 2),
//                        Arrays.asList(1, 4, 2, 3),
//                        Arrays.asList(1, 4, 3, 2),
//                        Arrays.asList(2, 1, 3, 4),
//                        Arrays.asList(2, 1, 4, 3),
//                        Arrays.asList(2, 3, 1, 4),
//                        Arrays.asList(2, 3, 4, 1),
//                        Arrays.asList(2, 4, 1, 3),
//                        Arrays.asList(2, 4, 3, 1),
//                        Arrays.asList(3, 1, 2, 4),
//                        Arrays.asList(3, 1, 4, 2),
//                        Arrays.asList(3, 2, 1, 4),
//                        Arrays.asList(3, 2, 4, 1),
//                        Arrays.asList(3, 4, 1, 2),
//                        Arrays.asList(3, 4, 2, 1),
//                        Arrays.asList(4, 1, 2, 3),
//                        Arrays.asList(4, 1, 3, 2),
//                        Arrays.asList(4, 2, 1, 3),
//                        Arrays.asList(4, 2, 3, 1),
//                        Arrays.asList(4, 3, 1, 2),
//                        Arrays.asList(4, 3, 2, 1)));
//
//        TestUtilities.assertEquals(Permutation.permuteDup(new Integer[]{1, 2, 2, 3}),
//                Arrays.asList(Arrays.asList(1, 2, 2, 3),
//                        Arrays.asList(1, 2, 3, 2),
//                        Arrays.asList(1, 3, 2, 2),
//                        Arrays.asList(2, 1, 2, 3),
//                        Arrays.asList(2, 1, 3, 2),
//                        Arrays.asList(2, 2, 1, 3),
//                        Arrays.asList(2, 2, 3, 1),
//                        Arrays.asList(2, 3, 1, 2),
//                        Arrays.asList(2, 3, 2, 1),
//                        Arrays.asList(3, 1, 2, 2),
//                        Arrays.asList(3, 2, 1, 2),
//                        Arrays.asList(3, 2, 2, 1)));
//    }

    @DataProvider
    public Object[][] choices() {
        return new Object[][]{
                {Arrays.asList(new String[]{"Salmon", "Catfish"},
                        new String[]{"Beef", "Pork", "Chicken"}),
            Arrays.asList(Arrays.asList("Salmon", "Beef"),
                    Arrays.asList("Salmon", "Pork"),
                    Arrays.asList("Salmon", "Chicken"),
                    Arrays.asList("Catfish", "Beef"),
                    Arrays.asList("Catfish", "Pork"),
                    Arrays.asList("Catfish", "Chicken"))}
        };
    }
    @Test(dataProvider = "choices")
    public void testAllChoices(List<String[]> categories, List<List<String>> expected) {
        TestUtilities.assertEquals(new Permutation().allChoices(categories), expected);
    }
}
