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

import java.util.HashMap;
import java.util.Random;
import java.util.function.Supplier;

class RandomGengerator {
    private Random rand; 
    
    public RandomGengerator() {
        rand = new Random();
    }
    
    int getRandomNumber() {
        return rand.nextInt();
    }
}

public class Google2 {
    
    public long numberOfCalls(Supplier<Integer> generator, int[] expected) {
        HashMap<Integer, Long> valueMap = new HashMap<>();
        
        for (int i : expected) {
            if (valueMap.containsKey(i)) {
                valueMap.put(i, valueMap.get(i) + 1L);
            } else {
                valueMap.put(i, 1L);
            }
        }
        
        long calls = 0;
        while (!valueMap.isEmpty()) {
            int randV = generator.get();
            if (valueMap.containsKey(randV)) {
                if (valueMap.get(randV) == 1) {
                    valueMap.remove(randV);
                } else {
                    valueMap.put(randV, valueMap.get(randV) - 1L);
                }
            }
            calls++;
        }
        
        return calls;
    }
    

    public static void main(String[] args) {
        RandomGengerator generator = new RandomGengerator();
        System.out.println(new Google2().numberOfCalls(generator::getRandomNumber, new int[]{1,2,3,4,5,6,7,8,9})); 

    }

}
