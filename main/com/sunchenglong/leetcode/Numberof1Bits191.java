package com.sunchenglong.leetcode;

/**
 * Created by Administrator on 2016/8/9.
 */
public class Numberof1Bits191 {
    public int hammingWeight(int n) {
        char[] chars = Integer.toBinaryString(n).toCharArray();
        int count = 0;
        for(char c : chars) {
            if(c != '0') {
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Numberof1Bits191().hammingWeight(15));
    }
}
