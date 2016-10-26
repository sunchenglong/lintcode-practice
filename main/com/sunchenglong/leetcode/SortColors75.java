package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/26.
 */
public class SortColors75 {
    public void sortColors(int[] nums) {
        int length = nums.length;
        int index2 = length - 1, index0 = 0;
        for (int i = 0; i <= index2; i++) {
            while (nums[i] == 2 && i < index2) {
                swap(nums, i, index2--);
            }
            while (nums[i] == 0 && i > index0) {
                swap(nums, i, index0++);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
