package com.haibo.yan.algorithm.bfs;

import java.util.*;

import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.toSet;

public class OneRemoveConnect {
    /**
     * Breadth first search on the dictionary with checking one character remove from the source word to target word.
     * Word's one character removed neighbours are calculated and checked in dictionary with corresponding length.
     */
    public List<String> leastPathsByRemoveOneWithOptimize(String source, String target, Set<String> dict) {
        int sLen = source.length();
        int tLen = target.length();
        if (sLen <= tLen) Collections.emptyList();
        Map<Integer, Set<String>> wordByLen = dict.stream().collect(groupingBy(String::length, toSet()));
        Map<String, Integer> wordsIndices = new HashMap<>();
        List<List<Integer>> previousIndices = new ArrayList<>();
        wordsIndices.put(source, 0);
        Map<String, Integer> current = new HashMap<>();
        current.put(source, 0);
        previousIndices.add(new ArrayList<>());
        for (int len = sLen - 1; len >= tLen && !current.isEmpty(); len--) {
            Map<String, Integer> next = new HashMap<>();
            Set<String> candidates = wordByLen.getOrDefault(len, Collections.emptySet());
            for (Map.Entry<String, Integer> currentEntry : current.entrySet()) {
                // Possible multiple candidates
                String w = currentEntry.getKey();
                Integer p = currentEntry.getValue();
                oneRemovedSet(w).stream().filter(candidates::contains).forEach(x -> {
                    if (next.containsKey(x)) {
                        // Multiple neighbours found
                        previousIndices.get(next.get(x)).add(p);
                    } else {
                        next.put(x, previousIndices.size());
                        previousIndices.add(new ArrayList<>(){
                            { add(p); }
                        });
                    }
                });
            }
            for (Map.Entry<String, Integer> e: next.entrySet()) {
                wordsIndices.put(e.getKey(), e.getValue());
            }
            current = next;
        }

        if (current.isEmpty()) {
            return new ArrayList<>();
        } else {
            List<String> prev = new ArrayList<>();
            prev.add("");
            Map<Integer, String> idxWords
                    = wordsIndices.entrySet().stream().collect(toMap(Map.Entry::getValue, Map.Entry::getKey));
            Set<Integer> vertexes = new HashSet<>() {
                { add(wordsIndices.get(target)); }
            };
            while (!vertexes.isEmpty()) {
                List<String> next = new ArrayList<>();
                for (int vertex : vertexes) {
                    String prepend = idxWords.get(vertex);
                    for (String path : prev) {
                        next.add(path.isEmpty() ? prepend : prepend + " => " + path);
                    }
                }
                vertexes = vertexes.stream().flatMap(k -> previousIndices.get(k).stream()).collect(toSet());
                prev = next;
            }

            return prev;
        }
    }
    /**
     * Breadth first search on the dictionary with checking one character remove.
     */
    public List<String> leastPathsByRemoveOne(String source, String target, Set<String> dict) {
        if (source.equals(target))  return Collections.emptyList();
        // Map for looking up it's visited sequence from original
        Map<String, Integer> wordsIndices = new HashMap<>();
        List<List<Integer>> previousIndices = new ArrayList<>();
        Map<String, Integer> current = new HashMap<>();
        current.put(source, 0);
        wordsIndices.put(source, 0);
        previousIndices.add(new ArrayList<>());
        boolean reached = false;
        while (!current.isEmpty() && !reached) {
            Map<String, Integer> next = new HashMap<>();
            for (Map.Entry<String, Integer> currentEntry : current.entrySet()) {
                // Possible multiple candidates
                String w = currentEntry.getKey();
                Integer p = currentEntry.getValue();
                for (String lookup: dict) {
                    if (!wordsIndices.containsKey(lookup) && oneRemoved(lookup, w)) {
                        if (next.containsKey(lookup)) {
                            // Multiple neighbours found
                            previousIndices.get(next.get(lookup)).add(p);
                        } else {
                            next.put(lookup, previousIndices.size());
                            previousIndices.add(new ArrayList<>(){
                                { add(p); }
                            });
                        }

                        if (lookup.equals(target))
                            reached = true;
                    }
                }
            }
            for (Map.Entry<String, Integer> e: next.entrySet()) {
                wordsIndices.put(e.getKey(), e.getValue());
            }
            current = next;
        }

        if (!reached) {
            return new ArrayList<>();
        } else {
            List<String> prev = new ArrayList<>();
            prev.add("");
            Map<Integer, String> idxWords
                    = wordsIndices.entrySet().stream().collect(toMap(Map.Entry::getValue, Map.Entry::getKey));
            Set<Integer> vertexes = new HashSet<>() {
                { add(wordsIndices.get(target)); }
            };
            while (!vertexes.isEmpty()) {
                List<String> next = new ArrayList<>();
                for (int vertex : vertexes) {
                    String prepend = idxWords.get(vertex);
                    for (String path : prev) {
                        next.add(path.isEmpty() ? prepend : prepend + " => " + path);
                    }
                }
                vertexes = vertexes.stream().flatMap(k -> previousIndices.get(k).stream()).collect(toSet());
                prev = next;
            }

            return prev;
        }
    }



    /**
     * Return a set that contains all the words which is one char removed from string s
     */
    private Set<String> oneRemovedSet(String s) {
        Set<String> removed = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char[] cs = new char[s.length() - 1];
            s.getChars(0, i, cs, 0);
            s.getChars(i + 1, s.length(), cs, i);
            removed.add(String.copyValueOf(cs));
        }
        return removed;
    }

    /**
     * Check is s1 is one character removed from s2
     */
    private boolean oneRemoved(String s1, String s2) {
        int p1 = s1.length() - 1;
        int p2 = s2.length() - 1;
        if (p1 + 1 != p2)   return false;
        for (boolean oneDiff = false; p1>= 0; p1--) {
            if (s1.charAt(p1) != s2.charAt(p2--)) {
                if (oneDiff) {
                    return false;
                } else {
                    p1++;   // revert p1
                    oneDiff = true;
                }
            }
        }
        return true;
    }
}
