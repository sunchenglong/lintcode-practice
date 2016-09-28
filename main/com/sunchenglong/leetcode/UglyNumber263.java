package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/9/28.
 */
public class UglyNumber263 {
    public boolean isUgly(int num) {
        if(num == 0) return false;
        while (num % 2 == 0 && num != 1) {
            num /= 2;
        }
        while (num % 3 == 0 && num != 1) {
            num /= 3;
        }
        while (num % 5 == 0 && num != 1) {
            num /= 5;
        }
        if (num == 1) return true;
        else return false;
    }

    public static void main(String[] args) {
        System.out.println(new UglyNumber263().isUgly(1));
    }
}
