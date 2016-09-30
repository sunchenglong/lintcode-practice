package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/8/9.
 */
public class RemoveElement27 {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        int num = 0;
        for (int i = 0; i < length; i++) {
            if(nums[i]!= val) {
               nums[num++] = nums[i];
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveElement27().removeElement(new int[]{3, 2, 2, 3}, 5));
    }
}
