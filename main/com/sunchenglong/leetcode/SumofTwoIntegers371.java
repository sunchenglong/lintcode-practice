package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/9/27.
 */
public class SumofTwoIntegers371 {
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b,( a & b )<<1 ) ;
    }

    public static void main(String[] args) {
        System.out.println(11 << 1);
        System.out.println(0xffff);
        System.out.println(Integer.SIZE);
        System.out.println(new SumofTwoIntegers371().getSum(0, 1));
    }
}
