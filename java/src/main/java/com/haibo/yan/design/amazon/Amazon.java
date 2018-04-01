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

// see https://github.com/billyean/algo_system_design/blob/master/amazon_1.png
// and https://github.com/billyean/algo_system_design/blob/master/amazon_2.png
package com.haibo.yan.design.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Amazon {
    public List<String> retrieveMostFrequentlyUsedWords(String literatureText,
                                                        List<String> wordsToExclude) {
        // WRITE YOUR CODE HERE
        Set<String> setToExcluded = new HashSet<>();
        for (String excluded : wordsToExclude) {
            if (excluded != null) {
                setToExcluded.add(excluded.trim().toLowerCase());
            }
        }

        Map<String, Integer> wordsMap = new HashMap<>();
        String[] words = literatureText.split("[[^a-z]&&[^A-Z]]");

        for (String word : words) {
            String low = word.toLowerCase();
            System.out.println(low);
            if (!setToExcluded.contains(low)) {
                wordsMap.put(low, wordsMap.getOrDefault(low, 0) + 1);
            }
        }
        List<String> mostFrequent = new ArrayList<>();
        int toppest = 0;
        for (int frequency : wordsMap.values()) {
            toppest = Math.max(toppest, frequency);
        }
        for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
            if (entry.getValue() == toppest) {
                mostFrequent.add(entry.getKey());
            }
        }
        Collections.sort(mostFrequent);
        return mostFrequent;
    }

    public List<String> reorderLines(int logFileSize, List<String> logLines) {
        // WRITE YOUR CODE HERE
        List<String> words = new ArrayList<>();
        if (logFileSize == 0 || logLines.size() == 0) {
            return words;
        }

        List<String> integers = new ArrayList<>();

        for (String fline : logLines) {
            String line = fline.trim();
            int sp1 = line.indexOf(' ');
            int sp2 = line.indexOf(' ', sp1 + 1);
            if (line.substring(sp1 + 1, sp2).trim().matches("\\d+")) {
                integers.add(line);
            } else {
                words.add(line);
            }
        }

        Collections.sort(words, (s1, s2) -> {
            String r1 = s1.substring(s1.indexOf(' ')).trim();
            String r2 = s2.substring(s2.indexOf(' ')).trim();

            if (r1.equals(r2)) {
                String identifier1 = s1.substring(0, s1.indexOf(' '));
                String identifier2 = s2.substring(0, s2.indexOf(' '));

                Pattern p = Pattern.compile("([a-z]+)(\\d+)");
                Matcher m1 = p.matcher(identifier1);
                Matcher m2 = p.matcher(identifier2);

                if (m1.find() && m2.find()) {
                    int i1 = Integer.parseInt(m1.group(2));
                    int i2 = Integer.parseInt(m2.group(2));

                    String is1 = m1.group(1);
                    String is2 = m2.group(1);

                    if (i1 == i2) {
                        return is1.compareTo(is2);
                    } else {
                        return Integer.compare(i1, i2);
                    }
                }

                return 0;
            } else {
                return r1.compareTo(r2);
            }
        });

        words.addAll(integers);
        return words;
    }
}
