package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/31.
 */
public class SearchInsertPosition35 {
    public int searchInsert(int[] nums, int target) {
        if (nums == null) return 0;
        int length = nums.length;
        int left = 0, right = length;
        while (left < right && left < length && right > -1) {
            int media = left + (right - left) / 2;
            if (nums[media] == target)
                return media;
            else if (nums[media] > target) {
                right = media - 1;
            } else {
                left = media + 1;
            }
        }
        if (right < 0) return 0;
        if (left >= length) return length;
        return nums[left] >= target ? left : left + 1;
    }
}
