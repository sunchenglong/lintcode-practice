package com.sunchenglong.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chenglong Sun on 2016/10/26.
 */
public class InsertInterval57 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        for (Interval interval : intervals) {
            if (newInterval == null) {
                result.add(interval);
                continue;
            }
            if (newInterval.start > interval.end) {
                result.add(interval);
                continue;
            }
            if (newInterval.end < interval.start) {
                result.add(newInterval);
                result.add(interval);
                newInterval = null;
                continue;
            }
            newInterval.start = Math.min(interval.start, newInterval.start);
            newInterval.end = Math.max(interval.end, newInterval.end);
        }
        if (newInterval != null) {
            result.add(newInterval);
        }
        return result;
    }
}
