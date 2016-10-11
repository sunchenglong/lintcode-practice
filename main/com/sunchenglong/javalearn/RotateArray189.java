package com.sunchenglong.javalearn;

import java.util.Arrays;

/**
 * Created by Chenglong Sun on 2016/10/11.
 */
public class RotateArray189 {
    public void rotate(int[] nums, int k) {
        if (k <= 0) return;
        while (k-- > 0)
            rotateOne(nums);
    }

    public void rotateOne(int[] nums) {
        int length = nums.length;
        int tmp = nums[length - 1];
        for (int i = length - 1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }
        nums[0] = tmp;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1, 2};
        new RotateArray189().rotate(test, 1);
        System.out.println(test[0]);
    }
}
