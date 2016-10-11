package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/12.
 */
public class AddBinary67 {
    public String addBinary(String a, String b) {
        String result = "";
        int lengthA = a.length();
        int lengthB = b.length();
        int carry = 0;
        int x = 1;
        for (int i = lengthA - 1, j = lengthB - 1; i > -1 || j > -1 || carry == 1; i--, j--) {
            int valueA = (i > -1 ? a.charAt(i) : '0') - '0';
            int valueB = (j > -1 ? b.charAt(j) : '0') - '0';
            result = String.valueOf((valueA + valueB + carry) % 2) + result;
            carry = (valueA + valueB + carry) / 2;
            x *= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new AddBinary67().addBinary("11", "111"));
    }
}
