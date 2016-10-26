package com.sunchenglong.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by Chenglong Sun on 2016/10/26.
 */
public class DataStreamasDisjointIntervals352 {
}

class SummaryRanges {

    TreeMap<Integer, Interval> treeMap;

    /**
     * Initialize your data structure here.
     */
    public SummaryRanges() {
        treeMap = new TreeMap<>();
    }

    public void addNum(int val) {
        if (treeMap.containsKey(val)) return;
        Integer low = treeMap.lowerKey(val);
        Integer high = treeMap.higherKey(val);
        if (low != null && high != null && treeMap.get(low).end + 1 == val && high == val + 1) {
            treeMap.get(low).end = treeMap.get(high).end;
            treeMap.remove(high);
        } else if (low != null && treeMap.get(low).end + 1 >= val) {
            treeMap.get(low).end = Math.max(treeMap.get(low).end, val);
        } else if (high != null && high == val + 1) {
            treeMap.put(val, new Interval(val, treeMap.get(high).end));
            treeMap.remove(high);
        } else {
            treeMap.put(val, new Interval(val, val));
        }
    }

    public List<Interval> getIntervals() {
        return new ArrayList<>(treeMap.values());
    }
}
