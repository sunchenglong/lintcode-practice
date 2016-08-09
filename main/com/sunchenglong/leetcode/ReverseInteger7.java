package com.sunchenglong.leetcode;

import java.util.Stack;

/**
 * Created by Administrator on 2016/8/9.
 */
public class ReverseInteger7 {
    public int reverse(int x) {
        int flag = x > 0 ? 1 : -1;
        int n = x > 0 ? x : -x;
        long result = 0;
        if (x == 0) return 0;
        int[] array = new int[1000];
        int count = 0;
        while (n != 0) {
            array[count] = n % 10;
            n = n / 10;
            count++;
        }
        for (int i = 0; i < count; i++){
            result = result * 10 + array[i];
            if(result > Integer.MAX_VALUE || result < 0)
                return 0;
        }
        return Integer.parseInt(String.valueOf(result)) * flag;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseInteger7().reverse(-1004));
    }
}
