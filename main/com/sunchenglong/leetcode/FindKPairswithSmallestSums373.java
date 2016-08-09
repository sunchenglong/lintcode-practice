package com.sunchenglong.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Chenglong Sun on 2016/8/9.
 */
//// TODO: 2016/8/9 PriorityQueue
public class FindKPairswithSmallestSums373 {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new LinkedList<int[]>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return result;
        int length1 = nums1.length;
        int length2 = nums2.length;
        int top1 = 1, top2 = 1;
        int count = 1;
        result.add(new int[]{nums1[0], nums2[0]});
        while (count < k) {
            if (top1 >= length1 && top2 >= length2) {
                return result;
            } else if (top1 < length1 &&(top2 >= length2 || nums1[top1] < nums2[top2])) {
                for (int i = 0; i < top2; i++) {
                    if (count >= k) break;
                    result.add(new int[]{nums1[top1], nums2[i]});
                    count++;
                }
                top1++;
            } else {
                for (int i = 0; i < top1; i++) {
                    if (count >= k) break;
                    result.add(new int[]{nums1[i], nums2[top2]});
                    count++;
                }
                top2++;
            }
        }
        return result;
    }
}
