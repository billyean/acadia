package com.haibo.yan.algorithm.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  https://leetcode.com/problems/snapshot-array/
 */
public class SnapshotArray {
    private int currentSnap = 0;

    private List<Integer>[] snapshots;

    private List<Integer>[] snapshotIds;

    public SnapshotArray(int length) {
        snapshots = new List[length];
        snapshotIds = new List[length];
    }

    public void set(int index, int val) {
        if (snapshots[index] == null) {
            snapshots[index] = new ArrayList<>();
            snapshotIds[index] = new ArrayList<>();
        }
        List<Integer> si = snapshots[index];
        List<Integer> sids = snapshotIds[index];

        int li = sids.size() - 1;
        if (sids.isEmpty() || sids.get(li) < currentSnap) {
            si.add(val);
            sids.add(currentSnap);
        }  else {
            si.remove(li);
            si.add(val);
        }
    }

    public int snap() {
        return currentSnap++;
    }

    public int get(int index, int snap_id) {
        if (snapshots[index] == null) {
            return 0;
        }

        List<Integer> snapshot = snapshots[index];
        List<Integer> history = snapshotIds[index];
        int x = Collections.binarySearch(history, snap_id);

        if (x >= 0) {
            return snapshot.get(x);
        } else {
            x = -x - 1;
            if (x == 0) {
                return 0;
            } else {
                return snapshot.get(x - 1);
            }
        }

    }
}
