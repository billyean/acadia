package com.haibo.yan.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/
 */
public class RemoveSubFolders {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> r = new ArrayList<>();

        int i = 0;
        r.add(folder[i]);
        int j = 1;

        while (j < folder.length) {
            if (!folder[j].startsWith(folder[i] + "/")) {
                i = j;
                r.add(folder[i]);
            }
            j++;
        }

        return r;
    }
}
