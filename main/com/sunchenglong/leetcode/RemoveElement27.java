package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/8/9.
 */
//// TODO: 2016/8/9 unfinished
public class RemoveElement27 {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        int length = nums.length;
        int pre = 0;
        int post = 0;
            while (post < length) {
            if (nums[post] == val) {
                pre = post;
                post++;
                count++;
            } else {
                nums[pre] = nums[post];
                pre ++;
                post++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
