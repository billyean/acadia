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

package com.haibo.yan.algorithm.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Power2 {
    public boolean isPower(int a) {
        if (a == 1)
            return true;
        if (a < 4)
            return false;

        for (int i = 2; i < 31; i++) {
            int ceil = (int)Math.ceil(Math.exp(Math.log(a) / i));
//            System.out.printf("i = %d, ceil = %d, %8.3f\n", i, ceil);
            int product1 = 1, product2 = 1;
            for (int j = 0; j < i; j++) {
                product1 *= ceil;
                product2 *= ceil - 1;
            }

            if (product1 == a || product2 == a) {
                return true;
            }
        }

        return false;

    }
}
