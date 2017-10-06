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
package com.haibo.yan.algorithm.google;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class Google3 {
    int mostFrequentValue(int[]  array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("null array or size is zero");
        }
        HashMap<Integer, Integer> valueOccursTime = new HashMap<>();
        
        for (int i : array) {
            if (valueOccursTime.containsKey(i)) {
                valueOccursTime.put(i, valueOccursTime.get(i) + 1);    
            } else {
                valueOccursTime.put(i, 1);    
            }
        }
        
        int candidate = array[0];
        int mostTime = 0;
        
        for (Entry<Integer, Integer> entry : valueOccursTime.entrySet()) {
            Integer k = entry.getKey();
            Integer v = entry.getValue();
            
            if (v > mostTime) {
                candidate = k;
                mostTime = v;
            }
        }
        
        return candidate;
    }
    
    int mostFrequentValueO1Memory(int[]  array) {
        Arrays.sort(array);
        
        int candidate = array[0];
        int lastAccessedIndex = 0;
        int max = 1;
        int current = 1;
        
        while (current < array.length) {
            if (array[current] != array[lastAccessedIndex]) {
                int len = current - lastAccessedIndex;
                if (len > max) {
                    max = len;
                    candidate = array[lastAccessedIndex];
                }
                lastAccessedIndex = current;
            }
            current++;
        }
        return candidate;
    }

    public static void main(String[] args) {
        System.out.println(new Google3().mostFrequentValue(new int[]{3, 2, 2, 3, 2, 1}));
        System.out.println(new Google3().mostFrequentValueO1Memory(new int[]{3, 2, 2, 3, 2, 1}));
    }

}
