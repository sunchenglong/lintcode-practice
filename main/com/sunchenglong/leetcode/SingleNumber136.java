package com.sunchenglong.leetcode;

/**
 * Created by Administrator on 2016/8/7.
 */
public class SingleNumber136 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i: nums) {
            result = result ^ i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new SingleNumber136().singleNumber(new int[] {1,2,1,3,3}));
    }
}
