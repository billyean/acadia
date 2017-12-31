/*
 *
 *  * Copyright [2017] [Haibo(Tristan) Yan]
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *     http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.haibo.yan.algorithm.array;

import com.haibo.yan.algorithm.Interval;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static org.testng.Assert.assertEquals;

public class TestInsertInterval {
    @DataProvider
    public Object[][] intervals() {
        return new Object[][] {
                {Arrays.asList(new Interval(1,3),
                        new Interval(6,9)),
                        new Interval(2, 5),
                        Arrays.asList(new Interval(1,5),
                                new Interval(6,9))},
                {Arrays.asList(new Interval(1,2),
                        new Interval(3,5),
                        new Interval(6,7),
                        new Interval(8,10),
                        new Interval(12,16)),
                        new Interval(4, 9),
                        Arrays.asList(new Interval(1,2),
                                new Interval(3,10),
                                new Interval(12,16))},
                {Arrays.asList(new Interval(1,5)),
                        new Interval(0, 1),
                        Arrays.asList(new Interval(0,5))},
                {Arrays.asList(),
                        new Interval(0, 1),
                        Arrays.asList(new Interval(0,1))},
        };
    }

    @Test(dataProvider = "intervals")
    public void testInsert(List<Interval> intervals, Interval newInterval, List<Interval> expected) {
        assertEquals(new InsertInterval().insert(intervals, newInterval), expected);
    }
}
