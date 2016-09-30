package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/9/30.
 */
public class RemoveDuplicatesfromSortedArray26 {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length < 1) return 0;
        int num = 0;
        for (int i = 0; i < length; i++) {
            if (nums[num] != nums[i]) {
                nums[++num] = nums[i];
            }
        }
        return num + 1;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicatesfromSortedArray26().removeDuplicates(new int[]{1, 2, 2, 3}));
    }
}
