package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/9/28.
 */
public class AddDigits258 {
    public int addDigits(int num) {
        int result = num;
        while (result / 10 != 0) {
            result = addOne(result);
        }
        return result;
    }

    public int addOne(int num) {
        int result = 0;
        while (num != 0) {
            result += num % 10;
            num /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new AddDigits258().addOne(213));
        System.out.println(new AddDigits258().addDigits(2123));
    }
}
