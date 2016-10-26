package com.sunchenglong.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;

/**
 * Created by Chenglong Sun on 2016/10/26.
 */
public class MergeIntervals56 {
    class IntervalComparator implements Comparator<Interval> {

        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());
        List<Interval> result = new ArrayList<>();
        Interval currentInterval = null;
        for (Interval interval : intervals) {
            if (currentInterval == null) {
                currentInterval = interval;
                result.add(interval);
            } else if (currentInterval.end >= interval.start) {
                currentInterval.end = Math.max(interval.end, currentInterval.end);
            } else {
                currentInterval = interval;
                result.add(currentInterval);
            }
        }
        return result;
    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}