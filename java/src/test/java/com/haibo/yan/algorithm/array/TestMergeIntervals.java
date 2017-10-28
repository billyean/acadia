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

package com.haibo.yan.algorithm.array;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class TestMergeIntervals {
    @DataProvider
    public Object[][] intervals() {
        return new Object[][]{
                {new ArrayList<Interval>(){
                    {
                        add(new Interval(1, 3));
                        add(new Interval(2, 6));
                        add(new Interval(8, 10));
                        add(new Interval(15, 18));
                    }
                }, Arrays.asList(new Interval(1, 6), new Interval(8, 10), new Interval(15, 18))},
                {new ArrayList<Interval>(){
                    {
                        add(new Interval(1, 4));
                        add(new Interval(4, 5));
                    }
                }, Arrays.asList(new Interval(1, 5))}
        };
    }

    @Test(dataProvider = "intervals")
    public void test(List<Interval> intervals, List<Interval> expectedMerged) {
        assertEquals(new MergeIntervals().merge(intervals), expectedMerged);
    }
}
