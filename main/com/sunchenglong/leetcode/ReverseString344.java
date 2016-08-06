package com.sunchenglong.leetcode;

/**
 * Created by Administrator on 2016/8/6.
 */
public class ReverseString344 {
    public String reverseString(String s) {
        return new StringBuffer(s).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReverseString344().reverseString("Hello"));
        System.out.println(new ReverseString344().reverseString("o"));
    }
}
