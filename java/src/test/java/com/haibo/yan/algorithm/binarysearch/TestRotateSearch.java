package com.haibo.yan.algorithm.binarysearch;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestRotateSearch {
    @DataProvider
    public Object[][] rotatedArray() {
        return new Object[][]{
                {new int[]{}, 1, -1},
                {new int[]{}, 3, -1},
                {new int[]{}, 2, -1},
                {new int[]{1, 3}, 1, 0},
                {new int[]{1, 3}, 3, 1},
                {new int[]{1, 3}, 2, -1},
                {new int[]{1, 2, 3}, 1, 0},
                {new int[]{1, 2, 3}, 2, 1},
                {new int[]{1, 2, 3}, 3, 2},
                {new int[]{1, 2, 3}, 4, -1},
                {new int[]{2, 3, 1}, 1, 2},
                {new int[]{2, 3, 1}, 2, 0},
                {new int[]{2, 3, 1}, 3, 1},
                {new int[]{2, 3, 1}, 4, -1},
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 1, 0},
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 2, 1},
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 3, 2},
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 4, 3},
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 5, 4},
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 6, 5},
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 7, 6},
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 8, 7},
                {new int[]{3, 4, 5, 6, 7, 8, 1, 2}, 1, 6},
                {new int[]{3, 4, 5, 6, 7, 8, 1, 2}, 2, 7},
                {new int[]{3, 4, 5, 6, 7, 8, 1, 2}, 3, 0},
                {new int[]{3, 4, 5, 6, 7, 8, 1, 2}, 4, 1},
                {new int[]{3, 4, 5, 6, 7, 8, 1, 2}, 5, 2},
                {new int[]{3, 4, 5, 6, 7, 8, 1, 2}, 6, 3},
                {new int[]{3, 4, 5, 6, 7, 8, 1, 2}, 7, 4},
                {new int[]{3, 4, 5, 6, 7, 8, 1, 2}, 8, 5},
                {new int[]{7, 8, 1, 2, 3, 4, 5, 6}, 1, 2},
                {new int[]{7, 8, 1, 2, 3, 4, 5, 6}, 2, 3},
                {new int[]{7, 8, 1, 2, 3, 4, 5, 6}, 3, 4},
                {new int[]{7, 8, 1, 2, 3, 4, 5, 6}, 4, 5},
                {new int[]{7, 8, 1, 2, 3, 4, 5, 6}, 5, 6},
                {new int[]{7, 8, 1, 2, 3, 4, 5, 6}, 6, 7},
                {new int[]{7, 8, 1, 2, 3, 4, 5, 6}, 7, 0},
                {new int[]{7, 8, 1, 2, 3, 4, 5, 6}, 8, 1},
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 1, 0},
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 2, 1},
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 3, 2},
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 4, 3},
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 5, 4},
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 6, 5},
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 7, 6},
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 8, 7},
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 9, 8},
                {new int[]{3, 4, 5, 6, 7, 8, 9, 1, 2}, 1, 7},
                {new int[]{3, 4, 5, 6, 7, 8, 9, 1, 2}, 2, 8},
                {new int[]{3, 4, 5, 6, 7, 8, 9, 1, 2}, 3, 0},
                {new int[]{3, 4, 5, 6, 7, 8, 9, 1, 2}, 4, 1},
                {new int[]{3, 4, 5, 6, 7, 8, 9, 1, 2}, 5, 2},
                {new int[]{3, 4, 5, 6, 7, 8, 9, 1, 2}, 6, 3},
                {new int[]{3, 4, 5, 6, 7, 8, 9, 1, 2}, 7, 4},
                {new int[]{3, 4, 5, 6, 7, 8, 9, 1, 2}, 8, 5},
                {new int[]{3, 4, 5, 6, 7, 8, 9, 1, 2}, 9, 6},
                {new int[]{8, 9, 1, 2, 3, 4, 5, 6, 7}, 1, 2},
                {new int[]{8, 9, 1, 2, 3, 4, 5, 6, 7}, 2, 3},
                {new int[]{8, 9, 1, 2, 3, 4, 5, 6, 7}, 3, 4},
                {new int[]{8, 9, 1, 2, 3, 4, 5, 6, 7}, 4, 5},
                {new int[]{8, 9, 1, 2, 3, 4, 5, 6, 7}, 5, 6},
                {new int[]{8, 9, 1, 2, 3, 4, 5, 6, 7}, 6, 7},
                {new int[]{8, 9, 1, 2, 3, 4, 5, 6, 7}, 7, 8},
                {new int[]{8, 9, 1, 2, 3, 4, 5, 6, 7}, 8, 0},
                {new int[]{8, 9, 1, 2, 3, 4, 5, 6, 7}, 9, 1},
        };
    }

    @DataProvider
    public Object[][] hasDuplicate(){
        return new Object[][]{
                {new int[]{1, 1, 1, 3}, 3, true},
                {new int[]{1, 1, 3, 1}, 3, true},
                {new int[]{1, 3, 1, 1, 1}, 3, true},
        };
    }

    @Test(dataProvider = "rotatedArray")
    public void test1(int[] nums, int target, int expectedIndex){
        assertEquals(new RotateSearch().search1(nums, target), expectedIndex);
    }

    @Test(dataProvider = "rotatedArray")
    public void test2(int[] nums, int target, int expectedIndex){
        assertEquals(new RotateSearch().search2(nums, target), expectedIndex);
    }
}
