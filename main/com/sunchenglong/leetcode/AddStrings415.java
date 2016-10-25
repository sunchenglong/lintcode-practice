package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/25.
 */
public class AddStrings415 {
    private String[] table = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    public String addStrings(String num1, String num2) {
        int length1 = num1.length();
        int length2 = num2.length();
        if (length1 == 0 && length2 == 0) {
            return "0";
        }
        int carry = 0;
        StringBuilder result = new StringBuilder("");
        for (int i = length1 - 1, j = length2 - 1; i >= 0 || j >= 0 || carry > 0; i--, j--) {
            int a = 0, b = 0;
            if (i < 0 && j < 0) {
                result.append("1");
                break;
            } else if (i < 0) {
                b = num2.charAt(j) - '0';
            } else if (j < 0) {
                a = num1.charAt(i) - '0';
            } else {
                a = num1.charAt(i) - '0';
                b = num2.charAt(j) - '0';
            }
            result.append(table[(a + b + carry) % 10]);
            carry = (a + b + carry) / 10;
        }
        return result.reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println(new AddStrings415().addStrings("4334", "999999999999999999999999999999999999999999999999"));
    }
}
