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
